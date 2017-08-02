package com.xym.spring.propertyEditor;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * desc
 *
 * @author xym
 */
public class Boss {

    private String name;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}