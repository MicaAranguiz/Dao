package com.example.crud.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.crud.db.Model.Note


@Database(
    entities = [(Note::class)],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class) //trabajamos con una fecha y pasa el objeto a un numero y lo guarda y muestra
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? =
            null //si no hay una instancia creala y si ya hay una tiene que retornarla
    }

    fun getInstance(context: Context): NotesDatabase {
        synchronized(this) { //this haciendo referencia a NoteDatabase, varios procesos pueden estar accediendo
            var instance = INSTANCE

            if (instance == null) { // esta creada?
                instance = Room.databaseBuilder(
                    context.applicationContext, NotesDatabase::class.java,
                    "notes_database"
                ).fallbackToDestructiveMigration() // limpia las versiones anteriores si es que las hubieran
                    .build()

                INSTANCE = instance
            }
            return instance
        }
    }
}
