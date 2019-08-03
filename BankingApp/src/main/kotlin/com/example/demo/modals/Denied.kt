package com.example.demo.modals

import javafx.geometry.Pos
import tornadofx.*

class Denied : View("My View")
{
    override val root = vbox {
        spacing = 10.0
        paddingAll = 20.0
        alignment = Pos.CENTER
        label("The application has been denied.")
        button("Ok") {
            action {
                close()
            }
        }
    }
}
