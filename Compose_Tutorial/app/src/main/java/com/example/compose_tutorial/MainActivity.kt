package com.example.compose_tutorial

import androidx.compose.foundation.border
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import com.example.compose_tutorial.ui.theme.Compose_TutorialTheme
import android.content.res.Configuration
import android.os.Message
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_TutorialTheme(){
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Anderoid", "Jetpack Compose"))
                }

            }

        }
    }

    data class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: Message) {
        Row() {
            Image(
                painter= painterResource(R.drawable._000_f_383258331_d8imaeml8q3lf7eku2pi78cn0r7kkw9o),
                contentDescription = "Contact profile picture",modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)// Modifica espacios y material desing
            )
            Spacer(modifier = Modifier.width(8.dp)) //modifica espacios

            Column() {

                Text(text = msg.author,
                    color=MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.headlineMedium)

                Spacer(modifier = Modifier.height(5.dp)) //espaciador
                Surface(shape = MaterialTheme.shapes.extraLarge, tonalElevation = 2.dp, color = MaterialTheme.colorScheme.background) {
                Text(text = msg.body,
                style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Preview(showBackground = true)
    @Composable
    fun PreviewMessageCard() {
        Compose_TutorialTheme() {
            Surface() {
                MessageCard(
                    msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
                )
            }
        }

    }

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewConversation() {
        Compose_TutorialTheme {
            Conversation(SampleData.conversationSample)
        }
    }



}




