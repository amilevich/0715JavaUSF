package com.example.demo.viewmodel

import com.example.demo.data.CustomerAccountJoin
import tornadofx.*

class AccountJoinViewModel : ItemViewModel<CustomerAccountJoin>()
{
    val accountNumber = bind(CustomerAccountJoin::getAccountNumber)
    val balance = bind(CustomerAccountJoin::getBalance)
    val name = bind(CustomerAccountJoin::getName)
    val type = bind(CustomerAccountJoin::getType)
}