<<<<<<< HEAD
package top.xg.springboot.configure.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.configure.service.ConfigBackupService;

@RestController
@AllArgsConstructor
public class ConfigBackupController {
    private final ConfigBackupService configBackupService;

    @GetMapping("/backup")
    public void backupConfig(){
        configBackupService.backupConfigFile();
    }
}
=======
package top.xg.springboot.configure.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.configure.service.ConfigBackupService;

>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
