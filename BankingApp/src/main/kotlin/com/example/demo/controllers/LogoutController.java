package com.example.demo.controllers;

import com.example.demo.utility.DataIO;

public class LogoutController
{
    DataIO dataIO = new DataIO();

    public void writeFiles()
    {
        dataIO.saveAllData();
    }
}
