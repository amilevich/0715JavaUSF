package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.components.LoginForm
import com.example.demo.components.RegisterComponent
import com.example.demo.controllers.LoginController
import tornadofx.*

class MainView : View("Log In/Register")
{
    val login = LoginForm()
    val register: RegisterComponent by inject()

    override val root = borderpane {
        label(title) {
            addClass(Styles.heading)
        }
        top = register.root
        center = login.root

    }
}