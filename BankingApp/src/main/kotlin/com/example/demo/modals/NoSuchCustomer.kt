package com.example.demo.modals

import javafx.geometry.Pos
import tornadofx.*

class NoSuchCustomer : View("My View")
{
    override val root = vbox {
        paddingAll = 20.0
        spacing = 20.0
        alignment = Pos.CENTER

        label("That customer id could not be found.")
        button("Ok") {
            action {
                close()
            }
        }
    }
}
