package com.example.demo.modals

import com.example.demo.Scopes.AccountScope
import com.example.demo.controllers.TransactionController
import com.example.demo.data.TransferAmount
import com.example.demo.view.AccountView
import com.example.demo.viewmodel.TransferViewModel
import javafx.collections.FXCollections
import javafx.geometry.Pos
import tornadofx.*

class Transfer : View("Transfer")
{
    private val accountScope = super.scope as AccountScope

    private val model = accountScope.model

    private val transferModel = TransferViewModel(TransferAmount())

    private val controller = TransactionController()

    override val root = Form()

    init
    {
        with(root)
        {
            fieldset("Transfer Funds") {
                label("Balance: ${model.balance.value}")
                field("Account #:") {
                    textfield(transferModel.accountNumber) {
                        filterInput { it.controlNewText.isInt() }
                        validator {
                            if (it.isNullOrBlank())
                            {
                                error("Must enter an account number to transfer to.")
                            } else null
                        }
                    }
                }
                field("Amount:") {
                    textfield(transferModel.amount) {
                        filterInput { it.controlNewText.isDouble() }
                        validator {
                            if (it.isNullOrBlank())
                            {
                                error("Must enter an amount to transfer.")
                            }
                            else if (transferModel.amount.value.toDouble() > model.balance.value)
                            {
                                error("You can not transfer more than your balance.")
                            } else null
                        }
                    }
                }
                hbox {
                    paddingTop = 10.0
                    spacing = 20.0
                    alignment = Pos.CENTER_LEFT
                    button("Transfer") {
                        enableWhen(transferModel.valid)
                        action {
                            if (controller.checkAccountNumber(transferModel.accountNumber.value.toInt()))
                            {
                                controller.transfer(model.accountNumber.value, transferModel.accountNumber.value.toInt(),
                                        transferModel.amount.value.toDouble())
                                model.balance.value -= transferModel.amount.value.toDouble()
                                close()
                                find(AccountView::class, accountScope).openWindow()
                            }
                            else
                            {
                                find(NoSuchAccount::class).openModal()
                            }
                        }
                    }
                    button("Close")
                    {
                        action {
                            close()
                            find(AccountView::class, accountScope).openWindow()
                        }
                    }
                }
            }
        }
    }
}
