package com.example.demo.view

import com.example.demo.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("Hello TornadoFX")
{
    var fieldValue = SimpleStringProperty()

    var labelValue = SimpleStringProperty();

    val centerComponent = vbox {
        spacing = 20.0
        padding = Insets(50.0, 50.0, 50.0, 50.0);
        alignment = Pos.CENTER

        val input = textfield(fieldValue)

        button("Submit") {
            action {
                labelValue.set(fieldValue.value)
            }
        }

        label(labelValue)
    }

    override val root = borderpane {
        label(title) {
            addClass(Styles.heading)
        }
        center = centerComponent
    }
}