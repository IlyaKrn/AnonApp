package com.ilyakrn.anonapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ilyakrn.anonapp.R

@Preview
@Composable
fun RegisterComponent(onSelectLogin: ()-> Unit = {}, onRegister: ()-> Unit = {}) {

    val mutableLogin = remember {
        mutableStateOf("")
    }
    val mutablePassword = remember {
        mutableStateOf("")
    }
    val mutablePasswordRepeat = remember {
        mutableStateOf("")
    }
    val mutableWrongLogin = remember {
        mutableStateOf(false)
    }
    val mutableUsedLogin = remember {
        mutableStateOf(false)
    }
    val mutableWrongPasswordRepeat = remember {
        mutableStateOf(false)
    }
    val mutableShowPassword = remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier
        .padding(8.dp)
        .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.medium)
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Column{
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                value = mutableLogin.value,
                onValueChange = {
                    mutableLogin.value = it
                },
                textStyle = MaterialTheme.typography.bodyLarge,
                label = {
                    Text(
                        text = stringResource(id = R.string.login),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
            if(mutableWrongLogin.value){
                Text(
                    text = stringResource(id = R.string.wrong_login),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
            if(mutableUsedLogin.value){
                Text(
                    text = stringResource(id = R.string.used_login),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
            OutlinedTextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                value = mutablePassword.value,
                onValueChange = {
                    mutablePassword.value = it
                },
                textStyle = MaterialTheme.typography.bodyLarge,
                label = {
                    Text(
                        text = stringResource(id = R.string.password),
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                trailingIcon = {

                    val description = if (mutableShowPassword.value) "Hide password" else "Show password"

                    IconButton(
                        onClick = {
                            mutableShowPassword.value = !mutableShowPassword.value
                        }){
                        Icon(
                            painter  = if (mutableShowPassword.value) painterResource(id = R.drawable.visibility_on) else painterResource(id = R.drawable.visibility_off), description
                        )
                    }
                },
                visualTransformation = if (mutableShowPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
            )
            if(mutableWrongPasswordRepeat.value){
                Text(
                    text = stringResource(id = R.string.wrong_password_repeat),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
            OutlinedTextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                value = mutablePasswordRepeat.value,
                onValueChange = {
                    mutablePasswordRepeat.value = it
                },
                textStyle = MaterialTheme.typography.bodyLarge,
                label = {
                    Text(
                        text = stringResource(id = R.string.password_repeat),
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                trailingIcon = {

                    val description = if (mutableShowPassword.value) "Hide password" else "Show password"

                    IconButton(
                        onClick = {
                            mutableShowPassword.value = !mutableShowPassword.value
                        }){
                        Icon(
                            painter  = if (mutableShowPassword.value) painterResource(id = R.drawable.visibility_on) else painterResource(id = R.drawable.visibility_off), description
                        )
                    }
                },
                visualTransformation = if (mutableShowPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = {
                    if (mutablePassword.value == mutablePasswordRepeat.value || mutablePassword.value.isEmpty()){
                        mutableWrongPasswordRepeat.value = false
                        if (mutableLogin.value.isNotEmpty()){
                            mutableWrongLogin.value = false

                        }
                        else{
                            mutableWrongLogin.value = true
                        }
                    }
                    else{
                        mutableWrongPasswordRepeat.value = true
                    }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            ClickableText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = AnnotatedString(stringResource(id = R.string.sign_in)),
                style = TextStyle(color = MaterialTheme.colorScheme.onPrimaryContainer),
                onClick = {
                    onSelectLogin.invoke()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))

        }
        Spacer(modifier = Modifier.width(8.dp))
    }

}