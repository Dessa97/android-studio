package br.com.fiap.appgestaoresiduos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.appgestaoresiduos.ui.theme.AppGestaoResiduosTheme
import br.com.fiap.appgestaoresiduos.screens.SeparacaoScreen
import br.com.fiap.appgestaoresiduos.screens.GestaoScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppGestaoResiduosTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "gestao",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        }, enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                                animationSpec = tween(1000)
                            )
                        })
                    {
                        composable(route = "gestao") { GestaoScreen(navController) }
                        composable(route = "separacao") { SeparacaoScreen(navController) }
                    }
                }
            }
        }
    }
}




