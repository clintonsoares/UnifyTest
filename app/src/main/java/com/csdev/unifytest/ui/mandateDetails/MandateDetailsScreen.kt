package com.csdev.unifytest.ui.mandateDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.csdev.unifytest.R
import com.csdev.unifytest.ui.common.TopBarCustom
import com.csdev.unifytest.ui.theme.Background_OffWhite
import com.csdev.unifytest.ui.theme.Background_Orange
import com.csdev.unifytest.ui.theme.Orange500
import com.csdev.unifytest.ui.theme.Orange500_Alpha10
import com.csdev.unifytest.ui.theme.Orange500_Alpha50
import com.csdev.unifytest.utils.enums.PaymentOption

@Composable
fun MandateDetailsScreen(
    viewModel: MandateDetailsViewModel = hiltViewModel()
) {

    var selectedPaymentOption by remember { mutableStateOf<PaymentOption?>(null) }

    viewModel.selectedPaymentOption.collectAsStateWithLifecycle().value?.let {
        selectedPaymentOption = it
    }

    Scaffold(
        topBar = {
            TopBarCustom(
                title = "Mandate Details",
                onBackIconClicked = {}
            )
        }
    ) { screenPadding ->

        val context = LocalContext.current

        Column(
            modifier = Modifier
                .padding(top = screenPadding.calculateTopPadding())
                .fillMaxSize()
                .background(Background_OffWhite)
                .padding(horizontal = 12.dp)
                .padding(top = 20.dp)
        ) {

            // Validity container
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 12.dp)
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {
                        Text(
                            text = "Valid till - ",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 1.sp
                        )
                        // hardcoded date for ui demo
                        Text(
                            text = "29 - May - 2024",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp
                        )
                    }

                    Row {
                        Text(
                            text = "Upto Amount - ",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 1.sp
                        )
                        // hardcoded date for ui demo
                        Text(
                            text = "UGX 10,000",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp
                        )
                    }

                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                        .alpha(0.1f),
                    thickness = 1.dp,
                    color = Color.Black
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 12.dp)
                        .padding(vertical = 12.dp)
                ) {
                    Text(
                        text = "Frequency - ",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "As Presented",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.sp
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                        .alpha(0.1f),
                    thickness = 1.dp,
                    color = Color.Black
                )

                Row(
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                            end = 12.dp,
                            top = 12.dp,
                            bottom = 10.dp
                        )
                        .fillMaxWidth()
                        .background(Background_Orange, RoundedCornerShape(8.dp))
                        .padding(vertical = 8.dp)
                        .padding(start = 12.dp, end = 32.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_info),
                        "info icon",
                        modifier = Modifier
                            .size(14.dp)
                            .clip(CircleShape)
                            .border(1.dp, Orange500, CircleShape)
                            .padding(2.dp),
                        tint = Orange500
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        buildAnnotatedString {
                            withStyle(style = ParagraphStyle(lineHeight = 16.sp)) {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                                    append("The amount will be blocked when ride is blocked with SafeBoda, subject to above mentioned limit and validity. The limit is upto ")
                                }
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("UGX 10,000")
                                }
                            }
                        },
                        fontSize = 10.sp,
                        letterSpacing = 1.sp
                    )
                }

            }

            // auto payment options
            Text(
                text = "Auto Payment Options",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.sp,
                modifier = Modifier
                    .padding(top = 32.dp, bottom = 16.dp, start = 8.dp)
            )

            // payment options container
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                val selectedModifier = Modifier
                    .background(Orange500_Alpha10, RoundedCornerShape(8.dp))
                    .border(2.dp, Orange500, RoundedCornerShape(8.dp))

                Card(
                    modifier = Modifier
                        .size(110.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                viewModel.onPaymentOptionSelected(PaymentOption.AIRTEL_MONEY)
                            }
                            .then(
                                if (selectedPaymentOption == PaymentOption.AIRTEL_MONEY) {
                                    selectedModifier
                                } else {
                                    Modifier
                                }
                            )
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(context)
                                .data(context.getDrawable(R.drawable.ic_airtel))
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.ic_airtel),
                            error = painterResource(R.drawable.ic_airtel),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize()
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .size(110.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                viewModel.onPaymentOptionSelected(PaymentOption.FLEXI_PAY)
                            }
                            .then(
                                if (selectedPaymentOption == PaymentOption.FLEXI_PAY) {
                                    selectedModifier
                                } else {
                                    Modifier
                                }
                            )
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(context)
                                .data(context.getDrawable(R.drawable.ic_flexi))
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.ic_flexi),
                            error = painterResource(R.drawable.ic_flexi),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize()
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .size(110.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                viewModel.onPaymentOptionSelected(PaymentOption.MTN)
                            }
                            .then(
                                if (selectedPaymentOption == PaymentOption.MTN) {
                                    selectedModifier
                                } else {
                                    Modifier
                                }
                            )
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(context)
                                .data(context.getDrawable(R.drawable.ic_mtn))
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.ic_mtn),
                            error = painterResource(R.drawable.ic_mtn),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize()
                        )
                    }
                }

            }

            // pay using
            Text(
                text = "Pay Using",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.sp,
                modifier = Modifier
                    .padding(top = 32.dp, bottom = 12.dp, start = 8.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Orange500_Alpha50, RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ){

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { }
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo_airtel),
                        "airtel icon",
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Airtel Money - XXX897",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 1.sp,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Icon(
                        Icons.Rounded.KeyboardArrowRight,
                        "back button",
                        modifier = Modifier
                            .size(24.dp),
                        tint = Orange500
                    )
                }

            }

        }
    }

}