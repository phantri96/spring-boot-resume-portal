package com.triphan.resumeportal.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ResumePortalUtil {

    public static String[] getNullPropertyNames (Object source, String... ignoreFields) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        emptyNames.addAll(Arrays.asList(ignoreFields));
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
