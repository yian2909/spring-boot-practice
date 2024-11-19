package top.gx.springboot.quickstart.jdkstudey;

public class stringstudy {
    public static void main(String[] args) {
        String a = "";
        String b = "  hello  ";
        String c = "hello";
        System.out.println("判断字符串a是否为空或只含有空白字符:"+a.isBlank());
        System.out.println("判断字符串b是否为空或只含有空白字符:"+b.isBlank());
        System.out.println("字符串b:"+b);
        System.out.println("b字符串删去开头和结尾的空格后:"+b.strip());
        System.out.println("字符串c重复5次"+c.repeat(5));
    }
}
