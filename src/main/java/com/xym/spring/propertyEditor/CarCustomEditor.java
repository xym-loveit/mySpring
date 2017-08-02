package com.xym.spring.propertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * desc
 *
 * @author xym
 */
public class CarCustomEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (null != text && text.lastIndexOf(",") != -1) {
            String[] values = text.split(",");
            Car car = new Car();
            car.setColor(values[0]);
            car.setSpeed(Integer.parseInt(values[1]));
            car.setPrice(Double.parseDouble(values[2]));
            setValue(car);
        }else{
            throw new IllegalArgumentException("设置的字符串格式有误!");
        }
    }
}