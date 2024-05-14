package com.example.crud.db.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity (tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) //para que siempre el id se incremente solo
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "text")
    var text : String,

    @ColumnInfo(name = "update")
    var update : Date,
)