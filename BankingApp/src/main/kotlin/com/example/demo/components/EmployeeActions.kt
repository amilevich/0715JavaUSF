package com.example.demo.components

import com.example.demo.controllers.LogoutController
import com.example.demo.data.CurrentLoggedInEmployee
import com.example.demo.view.ApproveOrDeny
import com.example.demo.view.MainView
import javafx.geometry.Pos
import tornadofx.*

class EmployeeActions : Fragment("My View")
{
    private val logout = LogoutController()

    override val root = vbox {
        paddingAll = 10.0
        spacing = 10.0
        alignment = Pos.CENTER

        hbox {
            spacing = 20.0
            alignment = Pos.CENTER
            button("View All Open Applications") {
                action {
                    close()
                    find(ApproveOrDeny::class).openWindow()
                }
            }
            button("Logout") {
                action {
                    logout.writeFiles()
                    close()
                    CurrentLoggedInEmployee.getInstance().employee = null
                    find(MainView::class).openWindow()
                }
            }
        }
    }
}
