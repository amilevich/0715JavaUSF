package com.example.demo.viewmodel

import com.example.demo.data.Amount
import tornadofx.*

class AmountViewModel(amount: Amount) : ItemViewModel<Amount>(amount)
{
    val amount = bind(Amount::getAmount)
}