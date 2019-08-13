package com.example.demo.modals

import javafx.geometry.Pos
import tornadofx.*

class FailedLogin : View("My View") {
    override val root = vbox {
        spacing = 10.0
        alignment = Pos.CENTER
        paddingAll = 20.0

        label("The username/password you entered was incorrect.")
        button("Ok") {
            action {
                close()
            }
        }
    }
}
