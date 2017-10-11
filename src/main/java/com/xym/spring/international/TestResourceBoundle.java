package com.xym.spring.international;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 根据不同的本地化对象加载读取不同的资源文件
 *
 * @author xym
 */
public class TestResourceBoundle {
    public static void main(String[] args) {

        ResourceBundle bundleZH = ResourceBundle.getBundle("i18n/resource", Locale.CHINA);
        ResourceBundle bundleEN = ResourceBundle.getBundle("i18n/resource", Locale.US);

        System.out.println("zh=" + bundleZH.getString("greeting.common"));
        System.out.println("en=" + bundleEN.getString("greeting.common"));

    }

}