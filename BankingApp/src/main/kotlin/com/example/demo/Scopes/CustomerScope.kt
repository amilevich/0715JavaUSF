package com.example.demo.Scopes

import com.example.demo.viewmodel.FullCustomerViewModel
import tornadofx.*

class CustomerScope() : Scope()
{
    val model = FullCustomerViewModel()
}