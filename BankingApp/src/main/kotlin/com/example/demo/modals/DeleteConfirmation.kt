package com.example.demo.modals

import javafx.geometry.Pos
import tornadofx.*

class DeleteConfirmation : View("My View")
{
    override val root = vbox {
        spacing = 20.0
        paddingAll = 20.0
        alignment = Pos.CENTER

        label("The account has been deleted.")
        button("Ok") {
            action {
                close()
            }
        }
    }
}
