package com.example.demo.viewmodel

import com.example.demo.model.Customer
import tornadofx.*

class FullCustomerViewModel() : ItemViewModel<Customer>()
{
    val firstname = bind(Customer::getFirstname)
    val lastname = bind(Customer::getLastname)
    val cid = bind(Customer::getCustomerID)
    val address = bind(Customer::getAddress)
    val username = bind(Customer::getUsername)
}