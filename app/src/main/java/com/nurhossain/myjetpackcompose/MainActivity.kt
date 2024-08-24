package com.nurhossain.myjetpackcompose

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nurhossain.myjetpackcompose.ui.theme.MyJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Nur Hossain")
                    //UserProfile(name ="Nur Hossain" , age = 25 )
                    Subject(favSub = "english", generalSub = "math")
                }
            }
        }
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
fun UserProfile(name: String,age:Int) {
    Column {
        Text(text = name, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun Subject(favSub: String,generalSub:String) {
    Row {
        Text(text = favSub)
        Text(text = generalSub)
    }
}
@Composable
fun MyButton(text: String,onClick:() -> Unit){
    Button(onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}

@Composable
fun CenterMessage(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = message)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyJetPackComposeTheme {
        /*Greeting("Nur Hossain")
        MyButton("Click me"){

        }*/
        //UserProfile(name = "nur", age = 20)
        Subject(favSub = "english", generalSub = "math")
        CenterMessage(message = "Hello I am nur Hossain")
    }
}