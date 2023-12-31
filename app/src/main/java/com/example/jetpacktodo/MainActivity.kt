package com.example.jetpacktodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacktodo.ui.theme.JetpackTodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTodoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun MyAppContent() {
    Column {
        Greeting("Student")
        Image(
            painter = painterResource(id = R.drawable.ic_android), // Replace with your actual image resource
            contentDescription = "Android Image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Tagline()
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Tagline( modifier: Modifier = Modifier) {
    Text(
        text = "Lets learn compose with fatih",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingStudent() {
    JetpackTodoTheme {
        MyAppContent()
    }
}