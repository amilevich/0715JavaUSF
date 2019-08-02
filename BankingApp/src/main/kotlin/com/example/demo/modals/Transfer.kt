package com.example.demo.modals

import com.example.demo.Scopes.AccountScope
import com.example.demo.controllers.TransactionController
import com.example.demo.data.Amount
import com.example.demo.view.AccountView
import com.example.demo.viewmodel.AmountViewModel
import javafx.geometry.Pos
import tornadofx.*

class Transfer : View("My View")
{
    private val accountScope = super.scope as AccountScope

    private val model = accountScope.model

    private val amountModel = AmountViewModel(Amount(""))

    private val controller = TransactionController()

    override val root = Form()

    init
    {
        with(root)
        {
            fieldset("Withdrawal") {
                label("Balance: ${model.balance.value}")
                field("Amount: ") {
                    textfield(amountModel.amount) {
                        filterInput { it.controlNewText.isDouble() }
                        validator {
                            if (it.isNullOrBlank())
                            {
                                error("Must enter an amount to transfer.")
                            }
                            else if (amountModel.amount.value.toDouble() > model.balance.value)
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
                    button("Withdraw") {
                        enableWhen(amountModel.valid)
                        action {
                            controller.withdraw(model.accountNumber.value, amountModel.amount.value.toDouble())
                            model.balance.value -= amountModel.amount.value.toDouble()
                            close()
                            find(AccountView::class, accountScope).openWindow()
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
