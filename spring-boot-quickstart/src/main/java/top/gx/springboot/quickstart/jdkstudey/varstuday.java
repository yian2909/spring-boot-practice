package top.gx.springboot.quickstart.jdkstudey;

import java.util.ArrayList;

public class varstuday {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<>();
        list.add("用var关键字定义的list");
        list1.add("常规方式定义的list");
        System.out.println(list.get(0));
        System.out.println(list1.get(0));
    }
}
