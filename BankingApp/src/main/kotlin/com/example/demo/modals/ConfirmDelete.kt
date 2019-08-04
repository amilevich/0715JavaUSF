package com.example.demo.modals

import com.example.demo.Scopes.AccountScope
import com.example.demo.controllers.TransactionController
import com.example.demo.data.CurrentLoggedInEmployee
import com.example.demo.view.AccountView
import com.example.demo.view.CustomerHome
import com.example.demo.view.PersonalInfo
import javafx.geometry.Pos
import tornadofx.*

class ConfirmDelete : View("My View")
{
    private val controller = TransactionController()

    private val accountScope = super.scope as AccountScope

    override val root = vbox {
        spacing = 20.0
        paddingAll = 20.0
        alignment = Pos.CENTER

        label("Are you sure you want to delete this account?")
        hbox {
            spacing = 20.0
            alignment = Pos.CENTER
            button("Yes") {
                action {
                    close()
                    if (CurrentLoggedInEmployee.getInstance().employee != null)
                    {
                        val customerScope = controller.getCustomerScope(accountScope.model.accountNumber.value)
                        controller.delete(accountScope.model.accountNumber.value)
                        find(PersonalInfo::class, customerScope).openWindow()
                        find(DeleteConfirmation::class).openModal()
                    }
                    else
                    {
                        find(CustomerHome::class).openWindow()
                    }
                }
            }
            button("No")
            {
                action {
                    find(AccountView::class,accountScope).openWindow()
                }
            }
        }
    }
}
