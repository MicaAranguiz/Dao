package com.example.crud.ui.model

sealed class Event {
    data class setText(val text:String): Event()
    object OpenDialog: Event()
    object CloseDialog: Event()
    object Save: Event()

    data class Delete(val id: Int): Event()

    data class Load (val id:Int?): Event()
}


