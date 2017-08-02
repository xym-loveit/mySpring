package com.xym.spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * desc
 *
 * @author xym
 */
public class TestResource {
    public static void main(String[] args) {
        Resource resource = new FileSystemResource("C:\\Users\\xym\\IdeaProjects\\mySpring\\src\\main\\resources\\log4j2.properties");
        System.out.println("resource.getDescription()--" + resource.getDescription());


        resource = new ClassPathResource("log4j2.properties");
        System.out.println("resource:" + resource.exists());


        ClassPathResource classPathResource = new ClassPathResource("a.txt");
        EncodedResource encodedResource = new EncodedResource(classPathResource, Charset.forName("utf-8"));

        try {
            String copyToString = FileCopyUtils.copyToString(encodedResource.getReader());
            System.out.println(copyToString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}