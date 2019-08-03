package com.example.demo.components

import com.example.demo.Scopes.CustomerScope
import com.example.demo.controllers.CustomerTableController
import com.example.demo.data.CurrentLoggedInCustomer
import com.example.demo.model.Customer
import com.example.demo.view.PersonalInfo
import tornadofx.*

class CustomerTable : Fragment("Employee")
{
    val controller = CustomerTableController()

    private val currentLoggedInCustomer = CurrentLoggedInCustomer.getInstance()

    override val root = vbox {
        paddingTop = 25.0
        spacing = 20.0
        tableview(controller.allCustomers) {
            minWidth = 280.0
            onUserSelect {customer ->
                val customerScope = CustomerScope()
                customerScope.model.item = customer
                currentLoggedInCustomer.loggedInCustomer = customer
                close()
                find(PersonalInfo::class, customerScope).openWindow()
            }
            column("Customer ID:", Customer::getCustomerID)
            column("First Name:", Customer::getFirstname)
            column("Last Name:", Customer::getLastname)
        }
    }
}
