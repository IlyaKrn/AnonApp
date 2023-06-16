package com.ilyakrn.anonapp.presentation.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import com.ilyakrn.anonapp.presentation.ui.components.LoginComponent
import com.ilyakrn.anonapp.presentation.ui.components.RegisterComponent


@Preview
@Composable
fun AuthScreen(onAuth: ()-> Unit = {}) {

    val mutableIsLogin = remember {
        mutableStateOf(true)
    }

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Box(modifier = Modifier
            .align(Alignment.Center)
        ) {

            if(mutableIsLogin.value){
                LoginComponent(
                    onSelectRegister = {mutableIsLogin.value = false},
                    onLogin = {onAuth.invoke()}
                )
            }
            else{
                RegisterComponent(
                    onSelectLogin = {mutableIsLogin.value = true},
                    onRegister = {onAuth.invoke()}
                    )
            }
        }

    }

}