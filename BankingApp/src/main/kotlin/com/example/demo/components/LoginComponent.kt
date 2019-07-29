package com.example.demo.components

import com.example.demo.controllers.LoginController
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import tornadofx.*

class LoginComponent : View()
{
    private val controller = LoginController()

    var username = SimpleStringProperty()

    var password = SimpleStringProperty()

    var labelValue = SimpleStringProperty()

    override val root = vbox {
        spacing = 20.0
        paddingAll = 50.0
        alignment = Pos.CENTER

        label("Username:")
        textfield(username)

        label("Password:")
        textfield(password)

        hbox {
            spacing = 30.0
            paddingAll = 10.0
            button("Login") {
                action {
                    labelValue.set(controller.checkCredentials(username.value, password.value).toString())
                }
            }

            button("Register") {
                action {
                    replaceWith<CustomerRegistration>()
                }
            }
        }



        label(labelValue)
    }
}
