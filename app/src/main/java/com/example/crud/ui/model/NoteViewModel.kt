package com.example.crud.ui.model

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud.ui.model.Event
import com.example.crud.core.TextFieldState
import com.example.crud.db.Model.Note
import com.example.crud.db.NotesDatabase
import com.example.crud.repository.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.util.Date

class NoteViewModel (application: Application):ViewModel() {
    private val _text = mutableStateOf(TextFieldState())
    val text: State<TextFieldState> = _text
    private var currentId: Int? = null
    var openDialog by mutableStateOf(false)
    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()


    private var repository: NotesRepository
        get() {
            TODO()
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

    private fun load(id: Int? ) {
        viewModelScope.launch {
            if (id != null) {
                repository.findById(id).also { note ->
                    currentId = note.id
                    _text.value = text.value.copy(
                        text = note.text
                    )
                }
            } else {
                currentId = null
                _text.value = text.value.copy(
                    text = "text"
                )
            }
        }
    }


    fun onEvent(event: Event) {
        when (event) {
            is Event.SetText -> {
                _text.value = text.value.copy(
                    text = event.text
                )
            }

            is Event.Save -> {
                if (currentId != null) {
                    repository.update(Note(currentId, text.value.text, Date()))
                } else {
                    repository.insert(Note(null, text.value.text, Date()))
                }
                openDialog = false
                coroutineScope.launch(Dispatchers.IO) {
                    _eventFlow.emit(Event.Save)
                }
            }

            is Event.OpenDialog -> {
                openDialog = true
            }

            is Event.CloseDialog -> {
                openDialog = false
            }

            is Event.Load -> {
                load(event.id)
                openDialog = true
            }

            is Event.Delete -> {
                event.id?.let { repository.delete(it) }
            }
        }
    }
}
