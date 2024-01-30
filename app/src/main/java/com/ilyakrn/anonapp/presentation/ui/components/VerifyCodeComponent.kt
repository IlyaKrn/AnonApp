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
fun  VerifyCodeComponent(onVerify: ()-> Unit = {}, onSelectChangeEmail: ()-> Unit = {}) {

    val mutableCode1 = remember {
        mutableStateOf("")
    }
    val mutableCode2 = remember {
        mutableStateOf("")
    }
    val mutableCode3 = remember {
        mutableStateOf("")
    }
    val mutableCode4 = remember {
        mutableStateOf("")
    }
    val mutableCode5 = remember {
        mutableStateOf("")
    }

    Row(modifier = Modifier
        .padding(8.dp)
        .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.medium)
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Column{
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.enter_code),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                OutlinedTextField(
                    modifier = Modifier
                        .align(Alignment.Top)
                        .width(48.dp),
                    value = mutableCode1.value,
                    onValueChange = {
                        if (it.length == 1) {
                            mutableCode1.value = it[0].toString()
                        }
                        if (it.length == 2) {
                            mutableCode1.value = it[0].toString()
                            mutableCode2.value = it[1].toString()
                        }
                    },
                    textStyle = MaterialTheme.typography.bodyLarge
                )
                OutlinedTextField(
                    modifier = Modifier
                        .align(Alignment.Top)
                        .width(48.dp),
                    value = mutableCode2.value,
                    onValueChange = {
                        mutableCode3.value = it
                    },
                    textStyle = MaterialTheme.typography.bodyLarge
                )
                OutlinedTextField(
                    modifier = Modifier
                        .align(Alignment.Top)
                        .width(48.dp),
                    value = mutableCode3.value,
                    onValueChange = {
                        mutableCode3.value = it
                    },
                    textStyle = MaterialTheme.typography.bodyLarge
                )
                OutlinedTextField(
                    modifier = Modifier
                        .align(Alignment.Top)
                        .width(48.dp),
                    value = mutableCode4.value,
                    onValueChange = {
                        mutableCode4.value = it
                    },
                    textStyle = MaterialTheme.typography.bodyLarge
                )
                OutlinedTextField(
                    modifier = Modifier
                        .align(Alignment.Top)
                        .width(48.dp),
                    value = mutableCode5.value,
                    onValueChange = {
                        mutableCode5.value = it
                    },
                    textStyle = MaterialTheme.typography.bodyLarge
                )
            }



            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(id = R.string.verify),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            ClickableText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = AnnotatedString(stringResource(id = R.string.resend_code)),
                style = TextStyle(color = MaterialTheme.colorScheme.onPrimaryContainer),
                onClick = {

                }
            )
            ClickableText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = AnnotatedString(stringResource(id = R.string.change_email)),
                style = TextStyle(color = MaterialTheme.colorScheme.onPrimaryContainer),
                onClick = {
                    onSelectChangeEmail.invoke()
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.height(8.dp))

        }
        Spacer(modifier = Modifier.width(8.dp))
    }

}