package com.xym.spring.propertyEditor;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * desc
 *
 * @author xym
 */
public class Car {

    private String color;
    private Integer speed;
    private Double price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}