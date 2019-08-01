package com.example.demo.components

import com.example.demo.controllers.ApplicationCreationController
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.geometry.Pos
import tornadofx.*

class ApplicationCreation : Fragment("Apply for Account")
{
    private val accountTypes = FXCollections.observableArrayList("Checking Account", "Joint Account")

    private val selectedType = SimpleStringProperty()

    private val controller = ApplicationCreationController()

    override val root = vbox {
        paddingAll = 50.0
        spacing = 20.0
        alignment = Pos.CENTER
        label("Please select the type of account you want to apply for.")
        combobox(selectedType, accountTypes)
        hbox {
            spacing = 20.0
            alignment = Pos.CENTER
            button("Apply") {
                enableWhen(selectedType.isNotNull)
                action {
                    controller.createApplication(selectedType.value)
                    close()
                    find<ApplicationConfirmation>().apply { openModal() }
                }
            }
            button("Back") {
                action {
                    close()
                }
            }
        }
    }
}
