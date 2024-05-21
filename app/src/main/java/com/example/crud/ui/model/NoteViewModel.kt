package com.example.crud.ui.model

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import com.example.crud.core.TextFieldState
import com.example.crud.db.Model.Note
import com.example.crud.db.NotesDatabase
import com.example.crud.repository.NotesRepository

class NoteViewModel(application: Application) {

    private val _text = mutableStateOf(TextFieldState())
    val text: State<TextFieldState> = _text
    private var repository: NotesRepository
        get() {
            TODO() //un metodo estatico se puede llamar sin crear la instancia de la clasee
        }

    var all: LiveData<List<Note>>
        get() {
            TODO()
        }

    init {
        val db = NotesDatabase.getInstance(application)
        val dao = db.notesDao()
        repository = NotesRepository(dao)

        all = repository.getNotes()


    }
}