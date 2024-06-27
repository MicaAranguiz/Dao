package com.example.crud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.crud.home.HomeScreen
import com.example.crud.ui.theme.CRUDTheme



data class Note(val titulo:String, val descripcion:String)

val notes: ArrayList<Note> = arrayListOf(
    Note("Ayuda", "No anda"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(notes)
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    CRUDTheme {
        HomeScreen(notes)
    }
}