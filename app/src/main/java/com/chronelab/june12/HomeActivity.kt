package com.chronelab.june12

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chronelab.june12.ui.theme.June12Theme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userName = intent.getStringExtra("userName") ?: "No User Name"
        val password = intent.getStringExtra("password") ?: "No Password"

        Log.i("HomeActivity", "Username: $userName")
        Log.i("HomeActivity", "Password: $password")

        setContent {
            June12Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(userName, password) {
                        btnLogoutAction()
                    }
                }
            }
        }
    }

    fun btnLogoutAction() {
        finish()
    }
}

@Composable
fun HomeScreen(userName: String, password: String, btnLogoutLambda: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Your username is :  $userName!")
        Text(text = "Your password is : $password")
        Button(onClick = { btnLogoutLambda() }) {
            Text(text = stringResource(id =R.string.txt_logout))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    June12Theme {
        HomeScreen("PreviewUser", "PreviewPass") {
            // Your code
        }
    }
}
