package com.example.crud.repository

import androidx.lifecycle.LiveData
import com.example.crud.db.Model.Note
import com.example.crud.db.NotesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesRepository (private val notesDao: NotesDao) {
    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun insert(note:Note) {
        coroutine.launch(Dispatchers.IO) {
            notesDao.insert(note)
        }
    }

    fun update(note:Note){
        coroutine.launch(Dispatchers.IO){
            notesDao.update(note)
        }
    }

    fun getNotes(): LiveData<List<Note>>{
        return notesDao.getNotes()
    }

    fun delete(id : Int){
        coroutine.launch(Dispatchers.IO){
            notesDao.delete(id)
        }
    }

    suspend fun findById(id: Int):Note{
        return notesDao.getById(id)
    }
}

