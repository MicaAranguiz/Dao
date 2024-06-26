package com.example.crud.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.crud.db.Model.Note

@Dao
interface NotesDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Query("DELETE FROM notes WHERE id = :id")
    fun delete(id : Int)

    // LiveData es un observable
    @Query("Select * from notes")
    fun getNotes() : LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id : Int) : Note
    abstract fun all(): LiveData<List<Note>>

}
