package com.example.demo.modals

import javafx.geometry.Pos
import tornadofx.*

class Approved : View("My View")
{
    override val root = vbox {
        spacing = 10.0
        paddingAll = 20.0
        alignment = Pos.CENTER
        label("The application has been approved.")
        button("Ok"){
            action {
                close()
            }
        }
    }
}
