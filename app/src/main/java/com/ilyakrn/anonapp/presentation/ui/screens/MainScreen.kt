package com.ilyakrn.anonapp.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MainScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(57.dp)
            .padding(4.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            IconButton(modifier = Modifier
                .align(Alignment.End),
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )
        }

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .weight(1F),
            content = {

            }
        )



        Column(modifier = Modifier
            .fillMaxWidth()
            .height(57.dp)
            .padding(4.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )
            IconButton(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(MaterialTheme.colorScheme.inversePrimary, MaterialTheme.shapes.small),
                onClick = {

                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "menu")
            }
        }
    }
}