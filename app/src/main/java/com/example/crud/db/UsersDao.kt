package com.example.crud.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.crud.db.Model.Note
import com.example.crud.db.Model.User

@Dao
interface UsersDao {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user : User)

    @Query("DELETE FROM users WHERE id = :id")
    fun delete(id : Int)

    // LiveData es un observable
    @Query("Select * from users")
    fun getUser() : LiveData<List<User>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getById(id : Int) : User


}