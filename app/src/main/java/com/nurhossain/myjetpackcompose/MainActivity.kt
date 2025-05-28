package com.nurhossain.myjetpackcompose

import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                MyButton()
                FloatingActionButtons()

                Column {
                    SimpleRadioButtonComponent()
                }
            }
        }
    }
}

@Composable
fun SimpleRadioButtonComponent() {
    val radioOptions = listOf("DSA", "Java", "C++")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // we are displaying all our
        // radio buttons in column.
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val context = LocalContext.current

                // below line is used to
                // generate radio button
                RadioButton(
                    // inside this method we are
                    // adding selected with a option.
                    selected = (text == selectedOption),

                    onClick = {
                        onOptionSelected(text)
                        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.padding(8.dp),

                    // below line is used to make the RadioButton
                    // is enabled, allowing it to be clickable
                    enabled = true,

                    // below line is used for customizing colors in RadioButton
                    colors = RadioButtonDefaults.colors(
                        Color.Green,
                        Color.DarkGray
                    ),

                    // below line is uses a default MutableInteractionSource
                    // to handle interaction states
                    interactionSource = remember { MutableInteractionSource() }
                )

                // below line is used to add
                // text to our radio buttons
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun FloatingActionButtons() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Floating Action Buttons in Android\nJetpack Compose",
            color = Color.Green,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        // a simple floating action button
        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Simple Floating Action Button",
                    Toast.LENGTH_SHORT).show()
            },
            containerColor = Color.Green,
            contentColor = Color.White
        ) {
            // adding icon for button.
            Icon(Icons.Filled.Add, "")
        }
        Spacer(modifier = Modifier.height(20.dp))

        // a square floating action button
        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Square Floating Action Button",
                    Toast.LENGTH_SHORT).show()
            },
            shape = RectangleShape,
            containerColor = Color.Green,
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add, "")
        }
        Spacer(modifier = Modifier.height(20.dp))

        // an extended floating action button.
        ExtendedFloatingActionButton(
            text = { Text(text = "Extended FAB") },
            onClick = {
                Toast.makeText(context, "Extended Floating Action Button",
                    Toast.LENGTH_SHORT).show()
            },
            containerColor = Color.Green,
            contentColor = Color.White,
            icon = { Icon(Icons.Filled.Add, "") }
        )
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

@Composable
fun MyButton() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val context = LocalContext.current

        Button(
            onClick = {
                Toast.makeText(context, "Welcome to Geeks for Geeks", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.padding(16.dp),
            enabled = true,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Green,
                containerColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
            border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Green)),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            interactionSource = remember { MutableInteractionSource() }
        ) {
            Text(
                text = "Geeks for Geeks",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Serif
            )
        }
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