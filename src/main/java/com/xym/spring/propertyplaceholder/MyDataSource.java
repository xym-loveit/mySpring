package com.xym.spring.propertyplaceholder;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * desc
 *
 * @author xym
 */
@Component
public class MyDataSource {

    @Value(value = "${driverClassName}")
    private String driverName;
    @Value(value = "${userName2}")
    private String username;
    @Value(value = "${url}")
    private String url;
    @Value(value = "${password}")
    private String password;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}