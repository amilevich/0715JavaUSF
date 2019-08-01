package com.example.demo.view

import com.example.demo.components.CustomerInfo
import tornadofx.*

class CustomerHome : View("My View")
{
    private val customerInfo = CustomerInfo()

    override val root = borderpane {
        paddingAll = 50.0
        top = customerInfo.root
    }
}
