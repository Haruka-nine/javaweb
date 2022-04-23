package com.utils;

import com.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {
    public static <T>  T copyParamToBean(Map value, T bean)
    {
        try {

            BeanUtils.populate(bean,value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转化为int类型的值
     * @param strInt 字符串
     * @param defaultValue 默认返回值
     * @return  返回转换成功的值或者默认值
     */
    public static int parseInt(String strInt, int defaultValue)
    {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  defaultValue;
    }
}
