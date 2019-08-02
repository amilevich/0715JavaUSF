package com.example.demo.view

import com.example.demo.components.AccountTable
import com.example.demo.components.CustomerActions
import com.example.demo.components.CustomerInfo
import tornadofx.*

class CustomerHome : View("Home")
{
    private val customerInfo = CustomerInfo()

    private val customerActions: CustomerActions by inject()

    private val accountTable = AccountTable()

    override val root = borderpane {
        paddingAll = 10.0
        top = customerInfo.root
        center = accountTable.root
        bottom = customerActions.root
    }
}
