package com.srikarsams.authenticationform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.srikarsams.authenticationform.ui.theme.Authentication
import com.srikarsams.authenticationform.ui.theme.AuthenticationFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthenticationFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Authentication()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview()
@Composable
fun DefaultPreview() {
    AuthenticationFormTheme {
        Surface(color = MaterialTheme.colors.background) {
            Authentication()
        }
    }
}