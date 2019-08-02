package com.example.demo.modals

import com.example.demo.Scopes.AccountScope
import com.example.demo.controllers.TransactionController
import com.example.demo.data.Amount
import com.example.demo.view.AccountView
import com.example.demo.viewmodel.AmountViewModel
import tornadofx.*

class Deposit : View("My View")
{
    override val root = Form()

    private val accountScope = super.scope as AccountScope

    private val model = accountScope.model

    private val amountModel = AmountViewModel(Amount(""))

    private val controller = TransactionController()

    init
    {
        with(root)
        {
            fieldset("Deposit") {
                label("Balance: ${model.balance.value}")
                field("Amount:") {
                    textfield(amountModel.amount) {
                        filterInput { it.controlNewText.isDouble() }
                        validator {
                            if (it.isNullOrBlank())
                            {
                                error("Must enter an amount to withdraw.")
                            } else null
                        }
                    }
                }
                hbox {
                    spacing = 20.0
                    paddingTop = 10.0

                    button("Deposit") {
                        action {
                            controller.deposit(model.accountNumber.value, amountModel.amount.value.toDouble())
                            model.balance.value += amountModel.amount.value.toDouble()
                            close()
                            find(AccountView::class, accountScope).openWindow()
                        }
                    }
                    button("Close") {
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
