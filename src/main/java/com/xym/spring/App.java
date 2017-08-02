package com.xym.spring;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            //加载classpath类路径下所有文件
            Resource[] resources = patternResolver.getResources("classpath*:**/*");
            for (Resource resource : resources) {
                System.out.println(resource.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
