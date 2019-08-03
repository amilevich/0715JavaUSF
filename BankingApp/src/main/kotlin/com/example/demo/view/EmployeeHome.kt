package com.example.demo.view

import com.example.demo.components.CustomerTable
import com.example.demo.components.EmployeeActions
import com.example.demo.data.CurrentLoggedInEmployee
import tornadofx.*

class EmployeeHome : Fragment("My View")
{
    private val customerTable = CustomerTable()

    private val loggedInEmployee = CurrentLoggedInEmployee.getInstance()

    private val employeeActions = EmployeeActions()

    private val welcome = vbox {
        label("Welcome!")
        label("Employee ID: ${loggedInEmployee.employee.id}")
    }

    override val root = borderpane {
        paddingAll = 10.0
        top = welcome
        center = customerTable.root
        bottom = employeeActions.root
    }
}
