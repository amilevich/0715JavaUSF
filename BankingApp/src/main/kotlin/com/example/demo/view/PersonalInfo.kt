package com.example.demo.view

import com.example.demo.Scopes.CustomerScope
import com.example.demo.components.AccountTable
import tornadofx.*

class PersonalInfo : Fragment("My View")
{
    private val accountTable = AccountTable()

    val customerScope = super.scope as CustomerScope

    val personalInfo = vbox {
        spacing = 10.0
        label("ID Number: ${customerScope.model.cid.value}")
        label("Username: ${customerScope.model.username.value}")
        label("Name: ${customerScope.model.firstname.value} ${customerScope.model.lastname.value}")
        label("Address: ${customerScope.model.address.value}")
    }

    override val root = borderpane {
        paddingAll = 10.0
        top = personalInfo
        center = accountTable.root
    }
}
