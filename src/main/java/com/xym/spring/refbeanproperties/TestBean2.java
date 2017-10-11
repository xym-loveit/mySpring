package com.xym.spring.refbeanproperties;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * desc
 *
 * @author xym
 */
public class TestBean2 {

    private String name;
    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}