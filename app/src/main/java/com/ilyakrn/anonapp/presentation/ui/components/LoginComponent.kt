package com.ilyakrn.anonapp.presentation.ui.components

import android.util.MutableBoolean
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ilyakrn.anonapp.R

@Preview
@Composable
fun LoginComponent(onSelectRegister: ()-> Unit = {}, onLogin: ()-> Unit = {}) {

    val mutableLogin = remember {
        mutableStateOf("")
    }
    val mutablePassword = remember {
        mutableStateOf("")
    }
    val mutableWrongLoginOrPassword = remember {
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
                textStyle = MaterialTheme.typography.labelMedium,
                label = {
                    Text(
                        text = stringResource(id = R.string.login),
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                isError = mutableWrongLoginOrPassword.value
            )
            if(mutableWrongLoginOrPassword.value){
                Text(
                    text = stringResource(id = R.string.wrong_login_or_password),
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
                textStyle = MaterialTheme.typography.labelMedium,
                label = {
                    Text(
                        text = stringResource(id = R.string.password),
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                isError = mutableWrongLoginOrPassword.value
            )
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.sign_in),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            ClickableText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = AnnotatedString(stringResource(id = R.string.register)),
                style = MaterialTheme.typography.bodyMedium,
                onClick = {
                    onSelectRegister.invoke()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))


        }
        Spacer(modifier = Modifier.width(8.dp))
    }

}