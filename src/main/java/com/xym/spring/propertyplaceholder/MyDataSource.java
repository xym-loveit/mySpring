package com.xym.spring.propertyplaceholder;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

/**
 * desc
 *
 * @author xym
 */
@Component
public class MyDataSource {

    //@Value(value = "${driverName}")
    //private String driverName;
    //@Value(value = "${userName}")
    //private String username;
    //@Value(value = "${url}")
    //private String url;
    //@Value(value = "${password}")
    //private String password;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}