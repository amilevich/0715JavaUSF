package com.example.demo.controllers;

import com.example.demo.DAO.PendingApplicationDAO;
import com.example.demo.data.CustomerApplicationJoin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ApproveOrDenyController
{
    PendingApplicationDAO pendingApplicationDAO = new PendingApplicationDAO();

    public ObservableList<CustomerApplicationJoin> getAllOpenApplications()
    {
        return FXCollections.observableArrayList(pendingApplicationDAO.selectAll());
    }
}
