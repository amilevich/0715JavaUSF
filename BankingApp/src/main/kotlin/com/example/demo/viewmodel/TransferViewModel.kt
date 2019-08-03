package com.example.demo.viewmodel

import com.example.demo.data.TransferAmount
import tornadofx.*

class TransferViewModel(transferAmount: TransferAmount) : ItemViewModel<TransferAmount>(transferAmount)
{
    val amount = bind(TransferAmount::getAmount)
    val accountNumber = bind(TransferAmount::getAccountNumber)
}