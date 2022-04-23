package com.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {
    @Test
    public void testLocale()
    {
        //获取你系统默认的语言，国家信息
        Locale locale = Locale.getDefault();
        System.out.println(locale);
    }
    @Test
    public void testI18n()
    {
        //得到我们需要的Locale对象
        Locale locale =Locale.CHINA;
        //通过指定的basename和locale对象读取相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        String username = bundle.getString("username");
        System.out.println(username);
    }
}
