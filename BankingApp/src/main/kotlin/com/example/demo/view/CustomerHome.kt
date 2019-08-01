package com.example.demo.view

import com.example.demo.components.CustomerActions
import com.example.demo.components.CustomerInfo
import tornadofx.*

class CustomerHome : View("Home")
{
    private val customerInfo = CustomerInfo()

    private val customerActions: CustomerActions by inject()

    override val root = borderpane {
        paddingAll = 50.0
        top = customerInfo.root
        bottom = customerActions.root
    }
}
