package com.example.demo.view

import com.example.demo.Scopes.AccountScope
import com.example.demo.components.AccountTable
import com.example.demo.controllers.TransactionController
import com.example.demo.data.CurrentLoggedInEmployee
import com.example.demo.modals.ConfirmDelete
import com.example.demo.modals.Deposit
import com.example.demo.modals.Transfer
import com.example.demo.modals.Withdraw
import javafx.geometry.Pos
import tornadofx.*

class AccountView : Fragment("Account View")
{
    private val accountScope = super.scope as AccountScope

    private val accountModel = accountScope.model

    private val controller = TransactionController()

    override val root = vbox {
        spacing = 10.0
        alignment = Pos.CENTER_LEFT
        paddingAll = 50.0

        label("Name: ${accountModel.name.value}")
        label("Account Number: ${accountModel.accountNumber.value}")
        label("Account Type: ${accountModel.type.value}")
        label("Balance: $${accountModel.balance.value}")

        hbox {
            spacing = 10.0
            alignment = Pos.CENTER
            button("Withdraw") {
                action {
                    find(Withdraw::class,accountScope).openWindow()
                    close()
                }
            }
            button("Deposit") {
                action {
                    find(Deposit::class,accountScope).openWindow()
                    close()
                }
            }
            button("Transfer") {
                action {
                    find(Transfer::class,accountScope).openWindow()
                    close()
                }
            }
            button("Delete") {
                action {
                    close()
                    find(ConfirmDelete::class).openWindow()
                }
            }
        }
        button("Done") {
            action {
                close()
                if (CurrentLoggedInEmployee.getInstance().employee != null)
                {
                    val customerScope = controller.getCustomerScope(accountScope.model.accountNumber.value)
                    find(PersonalInfo::class, customerScope).openWindow()
                }
                else
                {
                    find(CustomerHome::class).openWindow()
                }
            }
        }
    }
}
