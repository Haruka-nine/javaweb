package com.test;

import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login() {
        System.out.println("这是login()方法");
    }

    public void regist() {
        System.out.println("这是regist()方法");
    }

    public void updateUser() {
        System.out.println("updateUser()");
    }

    public void updateUserPassword() {
        System.out.println("updateUserPassword()");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            //通过action业务鉴别
            Method method = UserServletTest.class.getDeclaredMethod(action);

            method.invoke(new UserServletTest());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

