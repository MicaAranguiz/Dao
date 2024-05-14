package com.example.crud.db.Model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity (tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true) //para que siempre el id se incremente solo
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name = "email")
    var email : String,

)