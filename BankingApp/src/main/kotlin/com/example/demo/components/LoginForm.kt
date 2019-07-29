package com.example.demo.components

import com.example.demo.controllers.LoginController
import com.example.demo.model.User
import com.example.demo.viewmodel.UserViewModel
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class LoginForm : View("My View")
{
    override val root = Form()

    private val controller = LoginController()

    val userModel = UserViewModel(User())

    var labelValue = SimpleStringProperty()

    init
    {
        with(root)
        {
            fieldset("Login") {
                field("Username") {
                    textfield(userModel.username).required()
                }
                field("Password") {
                    passwordfield(userModel.password).required()
                }
            }
            button("Login") {
                enableWhen(userModel.valid)
                action {
                    userModel.commit()
                    val user = userModel.item
                    labelValue.set(controller.checkCredentials(user.username.value, user.password.value).toString())
                }
            }
            label(labelValue)
        }
    }
}
