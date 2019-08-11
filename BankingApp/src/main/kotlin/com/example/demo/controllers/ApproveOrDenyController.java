package com.example.demo.controllers;

import com.example.demo.DAO.PendingApplicationDAO;
import com.example.demo.DAO.PendingJointApplicationDAO;
import com.example.demo.data.CustomerApplicationJoin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ApproveOrDenyController
{
    PendingApplicationDAO pendingApplicationDAO = new PendingApplicationDAO();

    PendingJointApplicationDAO pendingJointApplicationDAO = new PendingJointApplicationDAO();

    public ObservableList<CustomerApplicationJoin> getAllOpenApplications()
    {
        ObservableList<CustomerApplicationJoin> joinList = FXCollections.observableArrayList();
        joinList.addAll(pendingApplicationDAO.selectAll());
        joinList.addAll(pendingJointApplicationDAO.selectAll());
        return joinList;
    }

    public void approveApp(int id)
    {
        pendingApplicationDAO.approveApplication(id);
    }

    public void denyApp(int id)
    {
        pendingApplicationDAO.denyApplication(id);
    }

    public void approveJointApp(int id)
    {
        pendingJointApplicationDAO.approveJointAccount(id);
    }

    public void denyJointApp(int id)
    {
        pendingJointApplicationDAO.denyJoinAccount(id);
    }
}
