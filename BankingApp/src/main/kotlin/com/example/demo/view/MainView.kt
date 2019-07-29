package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.components.LoginComponent
import com.example.demo.components.LoginForm
import com.example.demo.components.RegisterComponent
import tornadofx.*

class MainView : View("Banking App")
{
    val login: LoginForm by inject()
    val register: RegisterComponent by inject()

    override val root = borderpane {
        label(title) {
            addClass(Styles.heading)
        }
        top = register.root
        center = login.root
    }
}