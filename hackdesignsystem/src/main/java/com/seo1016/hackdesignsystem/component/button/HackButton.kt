package com.seo1016.hackdesignsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seo1016.hackdesignsystem.ui.theme.HackDesignSystemTheme
import com.seo1016.hackdesignsystem.ui.theme.TossBlue
import com.seo1016.hackdesignsystem.ui.theme.pretendard

sealed class ButtonType(
    val contentPadding: PaddingValues,
    val shape: Shape
) {
    data object Large: ButtonType(
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
        shape = RoundedCornerShape(10.dp)
    )

    data object Medium: ButtonType(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
        shape = RoundedCornerShape(8.dp)
    )

    data object Small: ButtonType(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
        shape = RoundedCornerShape(6.dp)
    )
}

@Composable
fun HackMaxWidthButton(
    modifier: Modifier = Modifier,
    text: String,
    tint: Color = TossBlue,
    type: ButtonType,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    shape: Shape? = null,
    contentPadding: PaddingValues? = null,
    onClick: () -> Unit,
) {
    val isEnabled = enabled && !isLoading

    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = tint,
        contentColor = Color.White,
        disabledContainerColor = tint,
        disabledContentColor = Color.White.copy(alpha = 0.5f)
    )

    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = buttonColors,
        enabled = isEnabled,
        contentPadding = contentPadding?: type.contentPadding,
        shape = shape?: type.shape
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun HackButton(
    modifier: Modifier = Modifier,
    text: String,
    tint: Color = TossBlue,
    type: ButtonType,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    shape: Shape? = null,
    contentPadding: PaddingValues? = null,
    onClick: () -> Unit,
) {
    val isEnabled = enabled && !isLoading

    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = tint,
        contentColor = Color.White,
        disabledContainerColor = tint,
        disabledContentColor = Color.White.copy(alpha = 0.5f)
    )

    Button(
        modifier = modifier,
        onClick = onClick,
        colors = buttonColors,
        enabled = isEnabled,
        contentPadding = contentPadding?: type.contentPadding,
        shape = shape?: type.shape
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HackButtonPreview() {
    HackDesignSystemTheme {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
        ) {
            HackMaxWidthButton(
                text = "로그인",
                type = ButtonType.Large
            ) {}
            HackMaxWidthButton(
                text = "변경하기",
                type = ButtonType.Medium
            ) {}
            HackMaxWidthButton(
                text = "확인하기",
                type = ButtonType.Small
            ) {}
            HackButton(
                text = "확인",
                type = ButtonType.Large
            ) {}
            HackButton(
                text = "확인",
                type = ButtonType.Medium
            ) {}
            HackButton(
                text = "확인",
                type = ButtonType.Small
            ) {}
        }
    }
}