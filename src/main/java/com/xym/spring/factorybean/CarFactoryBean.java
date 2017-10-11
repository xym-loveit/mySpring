package com.xym.spring.factorybean;

import com.xym.spring.propertyEditor.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义FactoryBean
 *
 * @author xym
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] carStrs = carInfo.split(",");
        car.setColor(carStrs[0]);
        car.setPrice(Double.parseDouble(carStrs[1]));
        car.setSpeed(Integer.parseInt(carStrs[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}