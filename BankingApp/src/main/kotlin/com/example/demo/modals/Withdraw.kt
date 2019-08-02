package com.example.demo.modals

import com.example.demo.DAO.TransactionDAO
import com.example.demo.Scopes.AccountScope
import com.example.demo.data.Amount
import com.example.demo.viewmodel.AmountViewModel
import javafx.beans.property.SimpleDoubleProperty
import javafx.geometry.Pos
import javafx.util.converter.DoubleStringConverter
import javafx.util.converter.NumberStringConverter
import tornadofx.*

class Withdraw : View("Withdrawal")
{
    override val root = Form()

    override val scope = super.scope as AccountScope

    private val model = scope.model

    private val amountModel = AmountViewModel(Amount(""))

    private val transactionDAO = TransactionDAO()

    init
    {
        with(root)
        {
            fieldset("Withdrawal") {
                field("Amount: ") {
                    textfield(amountModel.amount) {
                        filterInput { it.controlNewText.isDouble() }
                        validator {
                            if (it.isNullOrBlank())
                            {
                                error("Must enter an amount to withdraw.")
                            }
                            else if (amountModel.amount.value.toDouble() > model.balance.value)
                            {
                                error("You can not withdraw more than your balance.")
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
                            transactionDAO.withdraw(model.accountNumber.value, amountModel.amount.value.toDouble())
                            model.balance.value -= amountModel.amount.value.toDouble()
                        }
                    }
                    button("Close")
                    {
                        action {
                            close()
                        }
                    }
                }

            }
        }
    }
}
