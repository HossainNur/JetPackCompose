package com.nurhossain.myjetpackcompose

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun ButtonWithStyle(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth()
            .background(Color.Blue),
        onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}

@Composable
fun AppTitle() {
    Text(text = "My App",
        style = TextStyle(
            color = Color.Blue,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun AppIcon() {
    Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
}

@Composable
fun UserBio(name: String,bio: String) {
    Column {
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Text(text = bio, lineHeight = 24.sp)
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyJetPackComposeTheme {
        /*Greeting("Nur Hossain")
        MyButton("Click me"){

        }*/
        //UserProfile(name = "nur", age = 20)
       // Subject(favSub = "english", generalSub = "math")
        //CenterMessage(message = "Hello I am nur Hossain ")
        /*ButtonWithStyle(text = "Click Me") {
            
        }*/
        //AppTitle()
        //UserBio(name = "nur", bio = "Android Developer")
        //AppIcon()
    }
}