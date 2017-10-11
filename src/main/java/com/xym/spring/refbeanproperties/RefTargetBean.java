package com.xym.spring.refbeanproperties;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * spring 注解及java类配置--引用bean属性
 *
 * @author xym
 */
@Component
public class RefTargetBean {

    @Value("#{testBean.name}")
    private String refName;
    @Value("#{testBean.info}")
    private String refInfo;

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getRefInfo() {
        return refInfo;
    }

    public void setRefInfo(String refInfo) {
        this.refInfo = refInfo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}