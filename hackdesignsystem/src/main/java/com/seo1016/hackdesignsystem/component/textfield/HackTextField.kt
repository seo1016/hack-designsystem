package com.seo1016.hackdesignsystem.component.textfield

import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

@Composable
fun HackTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
    enabled: Boolean = true,
    secured: Boolean = false,
    singleLine: Boolean = true,
    shape: Shape? = null,
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedTextColor = Color.Black,
        focusedContainerColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        unfocusedTextColor = Color.Black,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        disabledTextColor = Color.Black,
        disabledContainerColor = Color.Transparent,
    )
) {
    var isFocused by remember { mutableStateOf(false) }

}