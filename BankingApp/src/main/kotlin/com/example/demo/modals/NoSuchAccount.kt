package com.example.demo.modals

import javafx.geometry.Pos
import tornadofx.*

class NoSuchAccount : View("My View")
{
    override val root = vbox {
        alignment = Pos.CENTER
        paddingAll = 50.0
        spacing = 20.0

        label("That account does not exist.")
        label("Please enter an existing account number.")
        button("Ok") {
            action {
                close()
            }
        }
    }
}
