package com.example.demo.viewmodel

import com.example.demo.data.CustomerApplicationJoin
import tornadofx.*

class AppJoinViewModel : ItemViewModel<CustomerApplicationJoin>()
{
    val appId = bind(CustomerApplicationJoin::getApplicationId)
    val firstname = bind(CustomerApplicationJoin::getFirstname)
    val lastname = bind(CustomerApplicationJoin::getLastname)
    val address = bind(CustomerApplicationJoin::getAddress)
}