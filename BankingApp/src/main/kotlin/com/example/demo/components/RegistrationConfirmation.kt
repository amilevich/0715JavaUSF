package com.example.demo.components

import javafx.geometry.Pos
import tornadofx.*

class RegistrationConfirmation : Fragment("My View")
{
    override val root = vbox {
        paddingAll = 50.0
        spacing = 20.0
        alignment = Pos.CENTER

        label("Your account has been successfully registered!")
        button("Ok") {
            action {
                close()
            }
        }
    }
}
