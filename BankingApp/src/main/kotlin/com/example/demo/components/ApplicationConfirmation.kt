package com.example.demo.components

import javafx.geometry.Pos
import tornadofx.*

class ApplicationConfirmation : View("Application Submitted")
{
    override val root = vbox {
        spacing = 20.0
        alignment = Pos.CENTER
        paddingAll = 50.0

        label("Your application has been submitted for review.")
        button("Ok") {
            action {
                close()
            }
        }
    }
}
