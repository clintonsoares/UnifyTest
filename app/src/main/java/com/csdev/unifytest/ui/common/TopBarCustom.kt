package com.csdev.unifytest.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csdev.unifytest.ui.theme.Orange500

@Composable
fun TopBarCustom(
    title: String,
    backIcon: ImageVector = Icons.Rounded.KeyboardArrowLeft,
    onBackIconClicked: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp)
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        //back button
        IconButton(
            onClick = onBackIconClicked,
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
        ) {
            Icon(
                backIcon,
                "back button",
                modifier = Modifier
                    .size(32.dp),
                tint = Orange500
            )
        }

        //Title
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(end = 28.dp),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

}