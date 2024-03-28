package br.com.fiap.appgestaoresiduos.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable

fun SeparacaoScreen(navController: NavHostController) {

    val visibleSeletiva = remember {
        mutableStateOf(false)
    }
    val visibleConvencional = remember {
        mutableStateOf(false)
    }
    val visibleEco = remember {
        mutableStateOf(false)
    }
    val enter = remember {
        mutableStateOf(fadeIn())
    }
    val exit = remember {
        mutableStateOf(fadeOut())
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            // --HEADER--
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(colorResource(id = br.com.fiap.appgestaoresiduos.R.color.greenEco))
            ) {
                Image(
                    painter = painterResource(id = br.com.fiap.appgestaoresiduos.R.drawable.eco2),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(top = 16.dp)
                )
                Text(
                    text = "Gestão de Resíduos",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            //--CARD--
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp, horizontal = 32.dp
                        )
                    ) {
                        Text(
                            text = "Separação de Resíduos",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = br.com.fiap.appgestaoresiduos.R.color.blueEco),
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {
                                val isOpen = visibleConvencional.value
                                if (isOpen) {
                                    visibleConvencional.value = false
                                }
                                if (!isOpen) {
                                    visibleSeletiva.value = false
                                    visibleEco.value = false
                                }
                                visibleConvencional.value = !isOpen
                                enter.value = expandVertically()
                                exit.value = shrinkVertically()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(0),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = br.com.fiap.appgestaoresiduos.R.color.yellowEco))
                        ) {
                            Text(
                                text = "Coleta Convencional",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                        BoxComponentConvencional(
                            visible = visibleConvencional.value,
                            enter = enter.value,
                            exit = exit.value
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {
                                val isOpen = visibleSeletiva.value
                                if (isOpen) {
                                    visibleSeletiva.value = false
                                }
                                if (!isOpen) {
                                    visibleConvencional.value = false
                                    visibleEco.value = false
                                }
                                visibleSeletiva.value = !isOpen
                                enter.value = expandVertically()
                                exit.value = shrinkVertically()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(0),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = br.com.fiap.appgestaoresiduos.R.color.redEco))
                        ) {
                            Text(
                                text = "Coleta Seletiva",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                        BoxComponentSeletiva(
                            visible = visibleSeletiva.value,
                            enter = enter.value,
                            exit = exit.value
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {
                                val isOpen = visibleEco.value
                                if (isOpen) {
                                    visibleEco.value = false
                                }
                                if (!isOpen) {
                                    visibleSeletiva.value = false
                                    visibleConvencional.value = false
                                }
                                visibleEco.value = !isOpen
                                enter.value = expandVertically()
                                exit.value = shrinkVertically()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(0),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = br.com.fiap.appgestaoresiduos.R.color.blueEco))
                        ) {
                            Text(
                                text = "Ecoponto",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                        BoxComponentEco(
                            visible = visibleEco.value,
                            enter = enter.value,
                            exit = exit.value
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = { navController.navigate("gestao") },
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(
                                    id = br.com.fiap.appgestaoresiduos.R.color.greenEco
                                )
                            )
                        ) {
                            Text(
                                text = "Voltar",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }

                    }
                }
            }
        }

    }
}

@Composable
fun BoxComponentConvencional(
    visible: Boolean,
    enter: EnterTransition,
    exit: ExitTransition,
) {
    AnimatedVisibility(
        visible = visible,
        enter = enter,
        exit = exit
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
            elevation = CardDefaults.cardElevation(1.dp),
            shape = RoundedCornerShape(0),
        )
        {
            Column(
                modifier = Modifier.padding(
                    vertical = 16.dp, horizontal = 32.dp
                )
            ) {
                Text(
                    text = "Coleta Convencional",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun BoxComponentSeletiva(
    visible: Boolean,
    enter: EnterTransition,
    exit: ExitTransition,
) {
    AnimatedVisibility(
        visible = visible,
        enter = enter,
        exit = exit
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
            elevation = CardDefaults.cardElevation(1.dp),
            shape = RoundedCornerShape(0),
        )
        {
            Column(
                modifier = Modifier.padding(
                    vertical = 16.dp, horizontal = 32.dp
                )
            ) {
                Text(
                    text = "Coleta Seletiva",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun BoxComponentEco(
    visible: Boolean,
    enter: EnterTransition,
    exit: ExitTransition,
) {
    AnimatedVisibility(
        visible = visible,
        enter = enter,
        exit = exit
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
            elevation = CardDefaults.cardElevation(1.dp),
            shape = RoundedCornerShape(0),
        )
        {
            Column(
                modifier = Modifier.padding(
                    vertical = 16.dp, horizontal = 32.dp
                )
            ) {
                Text(
                    text = "Ecoponto",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}







