package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.components.LoginComponent
import com.example.demo.controllers.LoginController
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("Banking App")
{
    val login: LoginComponent by inject()

    override val root = borderpane {
        label(title) {
            addClass(Styles.heading)
        }
        center = login.root
    }
}