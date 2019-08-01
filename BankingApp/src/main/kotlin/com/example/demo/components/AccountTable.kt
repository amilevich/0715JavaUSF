package com.example.demo.components

import com.example.demo.controllers.CustomerHomeController
import com.example.demo.model.Account
import tornadofx.*

class AccountTable : Fragment("My View")
{
    private val controller = CustomerHomeController()

    override val root = vbox {
        paddingTop = 25.0
        tableview(controller.customerAccounts) {
            maxHeight = 200.0
            column("Account Number", Account::getAccountNumber)
            column("Balance", Account::getBalance)
        }
    }
}
