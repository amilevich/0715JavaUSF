package com.example.demo.tests;

import com.example.demo.utility.Login;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest
{
    private Login loginUtil = new Login();

    @Test
    public void checkCorrectLogin()
    {
        String username = "dan";
        String password = "password";
        assertEquals("Should return true", true, loginUtil.login(username, password));
    }

    @Test
    public void checkWrongLogin()
    {
        String username = "dan";
        String password = "sgksfjjkg";
        assertEquals("Should return false", false, loginUtil.login(username, password));
    }
}
