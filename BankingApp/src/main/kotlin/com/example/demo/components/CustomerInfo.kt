package com.example.demo.components

import com.example.demo.data.CurrentLoggedInCustomer
import javafx.geometry.Pos
import tornadofx.*

class CustomerInfo : Fragment("My View")
{
    val customer = CurrentLoggedInCustomer.getInstance().loggedInCustomer

    override val root = vbox {
        spacing = 10.0
        paddingAll = 50.0
        paddingBottom = 0.0
        alignment = Pos.CENTER_LEFT

        label("Name: ${customer.firstname.value} ${customer.lastname.value}")
        label("Address: ${customer.address.value}")
    }
}
