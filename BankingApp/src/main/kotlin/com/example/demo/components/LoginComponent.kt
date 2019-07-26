package com.example.demo.components

import com.example.demo.controllers.LoginController
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import tornadofx.*

class LoginComponent : View("My View")
{
    private val controller = LoginController();

    var username = SimpleStringProperty()

    var password = SimpleStringProperty()

    var labelValue = SimpleStringProperty()

    override val root = vbox {
        spacing = 20.0
        padding = Insets(50.0, 50.0, 50.0, 50.0);
        alignment = Pos.CENTER

        label("Username:")
        textfield(username)

        label("Password:")
        textfield(password)

        button("Submit") {
            action {
                labelValue.set(controller.checkCredentials(username.value, password.value).toString())
            }
        }

        label(labelValue)
    }
}
