package com.example.crud.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.LazyColumn
import com.example.crud.Note


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(notes: List<Note>) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        Text(
            text = "Mis Notas",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Nombre nota") })
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "descripcion") })
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Agregar Nota")
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()){

        }
    }
}