package com.example.demo.view

import com.example.demo.modals.RegistrationConfirmation
import com.example.demo.controllers.RegistrationController
import com.example.demo.model.Customer
import com.example.demo.viewmodel.CustomerViewModel
import javafx.geometry.Pos
import tornadofx.*

class CustomerRegistration : Fragment("Registration")
{
    override val root = Form()

    private val customerModel = CustomerViewModel(Customer())

    private val controller = RegistrationController()

    init {
        with(root)
        {
            fieldset("Personal Information") {
                field("Firstname") {
                    textfield(customerModel.firstname).required()
                }
                field("Lastname") {
                    textfield(customerModel.lastname).required()
                }
                field("Address") {
                    textfield(customerModel.address).required()
                }
            }
            fieldset("Credentials") {
                field("Username") {
                    textfield(customerModel.username).required()
                }
                field("Password") {
                    passwordfield(customerModel.password).required()
                }
            }
            hbox {
                spacing = 10.0
                alignment = Pos.CENTER
                button("Submit") {
                    enableWhen(customerModel.valid)
                    action {
                        customerModel.commit()
                        controller.registerCustomer(customerModel.item)
                        controller.saveData()
                        close()
                        find(MainView::class).openWindow()
                        find<RegistrationConfirmation>().apply { openModal() }
                    }
                }
                button("Back") {
                    action {
                        close()
                        find(MainView::class).openWindow()
                    }
                }
            }

        }
    }
}
