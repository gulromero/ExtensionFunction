package com.example.extensionfunction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.extensionfunction.ui.theme.ExtensionFunctionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExtensionFunctionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Extension1(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Extension1(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        //Hello Hi Double
        val originalText = "nuriye"
        val doubledText = originalText.double()

        Text(text = "Original: $originalText")
        Text(text = "Doubled: $doubledText")

        //Palindrome
        val palindromeText = "kayak"
        val isPalindrome = palindromeText.isPalindrome()
        Text(text = "Is Palindrome: ${palindromeText.isPalindrome()}")

        //First Word
        val sentence = "Gulsum was here"
        val firstWord = sentence.theFirstWord()
        Text(text = "Sentence: $sentence")
        Text(text = "First Word: $firstWord")



    }

}

// Extension Function for String
fun String.double(): String {
    return this + this
}

//Extension Function for Palindrome words
fun String.isPalindrome(): Boolean {
    return this == this.reversed()
}

//Extension Function for Returning first word in Stringg
fun String.theFirstWord(): String {
    return this.split(" ").first()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExtensionFunctionTheme {
        Extension1()
    }
}