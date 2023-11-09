package com.pnt.back_press

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ExitAppDialog(
    openDialogCustom: MutableState<Boolean>,
    onPressNotNow: () -> Unit = {},
    onPressAllow: () -> Unit = {}
) {
    Dialog(onDismissRequest = { openDialogCustom.value = true }) {
        RequestPermissionDialogUI(
            openDialogCustom = openDialogCustom,
            onPressNotNow = onPressNotNow,
            onPressAllow = onPressAllow,
        )
    }
}

@Composable
fun RequestPermissionDialogUI(
    modifier: Modifier = Modifier,
    openDialogCustom: MutableState<Boolean>,
    onPressNotNow: () -> Unit = {},
    onPressAllow: () -> Unit = {},
) {
    Card(
        //shape = MaterialTheme.shapes.medium,
        shape = RoundedCornerShape(10.dp),
//         modifier = modifier.size(280.dp, 240.dp),
//        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier.background(Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Close the app",
                    textAlign = TextAlign.Center,
                    color = Color(0xFF565656),
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(),
//                    style = AppTypography.labelLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "Do you want to exit the app?",
                    textAlign = TextAlign.Center,
                    color = Color(0xFF565656),
                    modifier = Modifier
                        .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(12.dp))

                TextButton(
                    onClick = {
                        openDialogCustom.value = false

                        onPressNotNow()
                    }, border = BorderStroke(
                        width = 2.dp,
                        color = Color(0xFFFF9417),
                    ), shape = RoundedCornerShape(8.dp), modifier = Modifier.weight(1f)
                ) {
                    Text(
                        "No",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
//                        style = AppTypography.labelLarge,
                        color = Color(0xFF565656),
                        modifier = Modifier.padding(
                            top = 5.dp,
                            bottom = 5.dp,
                        )
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                TextButton(
                    onClick = {
                        openDialogCustom.value = false

                        onPressAllow()
                    },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color(0xFFFF9417),
                        contentColor = Color.White,
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        "Yes",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
//                        style = AppTypography.labelLarge,
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                top = 5.dp,
                                bottom = 5.dp,
                                start = 24.dp,
                                end = 24.dp,
                            )
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))
            }

            Spacer(modifier = Modifier.height(35.dp))
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(name = "Custom Dialog")
@Composable
fun MyDialogUIPreview() {
    ExitAppDialog(openDialogCustom = mutableStateOf(false))
}