package com.xym.spring.xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期转换器
 *
 * @author xym
 */
public class DateConvert implements Converter {


    private Locale locale;

    public DateConvert() {
        this.locale = Locale.CHINA;
    }

    public DateConvert(Locale locale) {
        this.locale = locale;
    }

    //java对象到xml的转换逻辑
    @Override
    public void marshal(Object value, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
        hierarchicalStreamWriter.setValue(dateInstance.format(value));
    }

    //XML到java对象转换
    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.DATE_FIELD, locale);

        try {
            gregorianCalendar.setTime(dateInstance.parse(hierarchicalStreamReader.getValue()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return gregorianCalendar.getGregorianChange();
    }

    //判断要转换的类型
    @Override
    public boolean canConvert(Class aClass) {
        return Date.class.isAssignableFrom(aClass);
    }
}