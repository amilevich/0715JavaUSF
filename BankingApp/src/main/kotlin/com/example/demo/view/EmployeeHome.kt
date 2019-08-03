package com.example.demo.view

import com.example.demo.components.CustomerTable
import com.example.demo.data.CurrentLoggedInEmployee
import tornadofx.*

class EmployeeHome : Fragment("My View")
{
    val customerTable = CustomerTable()

    val loggedInEmployee = CurrentLoggedInEmployee.getInstance()

    val welcome = vbox {
        label("Welcome!")
        label("Employee ID: ${loggedInEmployee.employee.id}")
    }

    override val root = borderpane {
        paddingAll = 10.0
        top = welcome
        center = customerTable.root
    }
}
