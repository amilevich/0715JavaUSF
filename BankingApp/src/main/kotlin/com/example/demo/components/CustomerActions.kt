package com.example.demo.components

import com.example.demo.controllers.CustomerHomeController
import javafx.geometry.Pos
import javafx.scene.layout.VBox
import tornadofx.*

class CustomerActions : View("My View")
{
    val controller = CustomerHomeController()

    override val root = vbox {
        alignment = Pos.CENTER_LEFT
        spacing = 20.0
        paddingAll = 50.0
        paddingTop = 30.0
        hbox {
            spacing = 50.0
            alignment = Pos.CENTER_LEFT
            button("Withdraw") {
                action {

                }
            }
            button("Deposit") {
                action {

                }
            }
        }
        hbox {
            spacing = 50.0
            alignment = Pos.CENTER_LEFT
            button("Transfer") {
                action {

                }
            }
            button("Apply for account") {
                action {

                }
            }
        }
    }
}
