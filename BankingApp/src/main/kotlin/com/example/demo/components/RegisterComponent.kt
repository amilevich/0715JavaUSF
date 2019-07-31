package com.example.demo.components

import com.example.demo.view.CustomerRegistration
import javafx.geometry.Pos
import tornadofx.*

class RegisterComponent : View("My View")
{
    override val root = hbox {
        spacing = 20.0
        paddingTop = 10.0
        paddingAll = 5.0
        alignment = Pos.CENTER_LEFT
        label("Need an account? Click Here to register:")
        button("Register") {
            action {
                close()
                find(CustomerRegistration::class).openWindow()
                //find(MainView::class).replaceWith<CustomerRegistration>()
            }
        }
    }
}
