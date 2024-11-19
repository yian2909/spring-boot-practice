package top.xg.springboot.filter.interceptor;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.xg.springboot.filter.util.OssTemplate;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Lenovo
 */
@Component
@Slf4j
public class PhotoUploadInterceptor implements HandlerInterceptor {
    @Resource
    private OssTemplate ossTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");

        //检查文件是否为空
        if (file == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("null file");
            return false;
        }

        //1.文件类型检查
        String type = file.getContentType();
        if (!"image/jpeg".equals(type) && !"image/png".equals(type)) {
            response.getWriter().write("type mismatch");
            return false;
        }

        //2.文件大小限制,不得大于4MB
        long maxSize = 4 * 1024 * 1024;
        if (file.getSize() > maxSize) {
            response.getWriter().write("photo is too large");
            return false;
        }

        //3.图片尺寸检查,不得小于 500 * 300
        if (!checkImageSize(file)) {
            response.getWriter().write("photo is too small");
            return false;
        }

        //4.文件重命名为 upload_上传时间.后缀名
        String newFileName = renameFile(file.getOriginalFilename());
        request.setAttribute("newFileName", newFileName);

        //5.添加水印
        String tempFilePath = addWatermark(file);
        if (tempFilePath == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("图片处理出错");
            return false;
        }

        // 将临时文件路径存储在请求属性中
        request.setAttribute("tempFilePath", tempFilePath);

        //6.记录上传日志
        log.info("上传成功");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    private boolean checkImageSize(MultipartFile file) throws IOException {
        BufferedImage image = ImgUtil.read(file.getInputStream());
        int width = image.getWidth();
        int height = image.getHeight();

        return width >= 500 && height >= 300;
    }

    private String renameFile(String originalFilename) {
        String extension = FileUtil.extName(originalFilename);
        String newFilename = "upload_" + LocalDateTime.now() + "." + extension;
        return newFilename;
    }

    private String addWatermark(MultipartFile file) {
        try {
            // 将 MultipartFile 转换为 File
            File tempFile = FileUtil.file("temp/" + file.getOriginalFilename());
            file.transferTo(tempFile);

            // 添加水印
            String newFileName = "watermarked_" + file.getOriginalFilename();
            File watermarkedFile = FileUtil.file("temp/" + newFileName);
            ImgUtil.pressText(tempFile, watermarkedFile, "GX", Color.WHITE,
                    new Font("黑体", Font.BOLD, 100), 0, 0, 0.9f);

            // 返回处理后的文件路径
            return watermarkedFile.getAbsolutePath();
        } catch (IOException e) {
            log.error("添加水印失败: " + e.getMessage());
            return null;
        }
    }
}
