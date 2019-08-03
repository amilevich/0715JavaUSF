package com.example.demo.view

import com.example.demo.controllers.ApproveOrDenyController
import com.example.demo.data.CustomerApplicationJoin
import tornadofx.*

class ApproveOrDeny : Fragment("Open Applications")
{
    val controller = ApproveOrDenyController()

    override val root = vbox {
        paddingAll = 10.0
        spacing = 10.0
        minWidth = 475.0
        tableview(controller.allOpenApplications) {
            column("Application ID",CustomerApplicationJoin::getApplicationId)
            column("First Name", CustomerApplicationJoin::getFirstname)
            column("Last Name", CustomerApplicationJoin::getLastname)
            column("Address", CustomerApplicationJoin::getAddress)
        }
    }
}
