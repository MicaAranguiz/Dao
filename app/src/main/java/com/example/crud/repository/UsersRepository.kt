package com.example.crud.repository

import androidx.lifecycle.LiveData
import com.example.crud.db.Model.User
import com.example.crud.db.UsersDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersRepository (private val usersDao: UsersDao) {
    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun insert(user: User) {
        coroutine.launch(Dispatchers.IO) {
            usersDao.insert(user)
        }
    }

    fun update(user: User){
        coroutine.launch(Dispatchers.IO){
            usersDao.update(user)
        }
    }

    fun getUsers(): LiveData<List<User>>{
        return usersDao.getUsers()
    }

    fun delete(id : Int){
        coroutine.launch(Dispatchers.IO){
            usersDao.delete(id)
        }
    }
}

