package com.efalone.barbershop

import com.parse.ParseClassName
import com.parse.ParseObject

@ParseClassName("User")
class User : ParseObject() {

    fun setName(name: String) {
        //TODO
    }

    fun getName(): String {
        // TODO
        return ""
    }

    companion object {
        const val KEY_NAME = "user"
        const val ACCOUNT_TYPE = "accountType"
    }
}