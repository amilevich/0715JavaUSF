package com.example.demo.viewmodel

import com.example.demo.model.Customer
import com.example.demo.model.User
import tornadofx.*

class UserViewModel(user: User) : ItemViewModel<User>(user)
{
    val username = bind(User::getUsername)
    val password = bind(User::getPassword)
}