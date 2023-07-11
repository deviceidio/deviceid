package com.deviceID.deviceid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deviceID.deviceid.ui.theme.DeviceIDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deviceID = DeviceID(this.contentResolver)
        deviceID.load("6sX9Bvkm4AtyQYiqgCvEYsb5UVXz5lblZnw/S/QJGmY=",
            "8PbZI62vENLEtKM3HgpN7DgusgmrSlPuimYTT9kI2+E=")
        val listener = object : IdentificationRequest.ProgressListener {
            override fun onComplete(result: Response) {
                println(result.device_id)
            }
            override fun onError(errorMessage: String?) {

            }}
        deviceID.id(listener = listener)
        setContent {
            DeviceIDTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeviceIDTheme {
        Greeting("Android")
    }
}