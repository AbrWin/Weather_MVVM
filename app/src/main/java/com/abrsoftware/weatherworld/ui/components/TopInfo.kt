package com.abrsoftware.weatherworld.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abrsoftware.weatherworld.R
import com.abrsoftware.weatherworld.ui.theme.Orange300

@Composable
fun TopInfo() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.White)
        ) {
            Image(
                painterResource(R.drawable.ic_sunny),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.tint(Orange300)
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "25,6",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )

    }

}

@Preview(showBackground = true, widthDp = 350, heightDp = 350)
@Composable
fun PreInfo() {
    TopInfo()
}