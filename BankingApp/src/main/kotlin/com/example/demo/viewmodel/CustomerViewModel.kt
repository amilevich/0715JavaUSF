package com.example.demo.viewmodel

import com.example.demo.model.Customer
import tornadofx.*

class CustomerViewModel(customer: Customer) : ItemViewModel<Customer>(customer)
{
    val firstname = bind(Customer::getFirstname)
    val lastname = bind(Customer::getLastname)
    val address = bind(Customer::getAddress)
    val username = bind(Customer::getUsername)
    val password = bind(Customer::getPassword)
}