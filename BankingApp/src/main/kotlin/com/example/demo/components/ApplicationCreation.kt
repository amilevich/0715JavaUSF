package com.example.demo.components

import com.example.demo.controllers.ApplicationCreationController
import com.example.demo.modals.NoSuchCustomer
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.geometry.Pos
import tornadofx.*

class ApplicationCreation : Fragment("Apply for Account")
{
    private val accountTypes = FXCollections.observableArrayList("Checking Account", "Joint Account")

    private val selectedType = SimpleStringProperty()

    private val secondaryAccount = SimpleStringProperty("")

    private val controller = ApplicationCreationController()

    override val root = vbox {
        paddingAll = 50.0
        spacing = 20.0
        alignment = Pos.CENTER
        label("Please select the type of account you want to apply for.")
        combobox(selectedType, accountTypes) {
            selectionModel.selectFirst()
        }
        hbox {
            spacing = 10.0
            alignment = Pos.CENTER_LEFT
            enableWhen(selectedType.isEqualTo("Joint Account"))
            label("Other Customer id:")
            textfield(secondaryAccount) {
                filterInput { it.controlNewText.isInt() }
            }
        }
        hbox {
            spacing = 20.0
            alignment = Pos.CENTER
            button("Apply") {
                enableWhen(selectedType.isNotNull)
                action {
                    if (selectedType.value.equals("Checking Account"))
                    {
                        controller.createApplication()
                        close()
                        find<ApplicationConfirmation>().apply { openModal() }
                    }
                    else
                    {
                        if (controller.checkCustomerId(secondaryAccount.value.toInt()))
                        {
                            controller.createJointApplication(secondaryAccount.value.toInt())

                            close()
                            find<ApplicationConfirmation>().apply { openModal() }
                        }
                        else
                        {
                            find(NoSuchCustomer::class).openModal()
                        }
                    }
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
