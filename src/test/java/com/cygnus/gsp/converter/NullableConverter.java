package com.cygnus.gsp.converter;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class NullableConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if("null".equalsIgnoreCase((String) source)){
            return null;
        }
        return DefaultArgumentConverter.INSTANCE.convert(source,targetType);
    }
}
