package com.example.demo.view

import com.example.demo.Scopes.CustomerScope
import com.example.demo.components.AccountTable
import com.example.demo.controllers.PersonalInfoController
import com.example.demo.data.CurrentLoggedInEmployee
import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class PersonalInfo : Fragment("Customer Info")
{
    private val accountTable = AccountTable()

    private val customerScope = super.scope as CustomerScope

    private val controller = PersonalInfoController()

    private val loggedInEmployee = CurrentLoggedInEmployee.getInstance()

    private val isAdmin = SimpleBooleanProperty(controller.checkType(loggedInEmployee.employee.username.value))

    val personalInfo = vbox {
        spacing = 10.0
        label("ID Number: ${customerScope.model.cid.value}")
        label("Username: ${customerScope.model.username.value}")
        label("Name: ${customerScope.model.firstname.value} ${customerScope.model.lastname.value}")
        label("Address: ${customerScope.model.address.value}")
    }

    val actions = hbox {
        spacing = 20.0
        paddingTop = 10.0
        button("Back") {
            action {
                close()
                find(EmployeeHome::class).openWindow()
            }
        }
        button("Edit") {
            visibleWhen(isAdmin)
            action {
                close()
                find(EditInfo::class, customerScope).openWindow()
            }
        }
    }

    override val root = borderpane {
        paddingAll = 10.0
        top = personalInfo
        center = accountTable.root
        bottom = actions
    }
}
