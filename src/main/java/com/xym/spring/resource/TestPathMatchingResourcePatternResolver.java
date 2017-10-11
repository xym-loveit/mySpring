package com.xym.spring.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * ant风格查找当前spring下properties文件
 *
 * @author xym
 */
public class TestPathMatchingResourcePatternResolver {
    public static void main(String[] args) throws IOException {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources("classpath*:/org/springframework/**/*.properties");
        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }
    }
}