package net.kibotu.webviewbottomsheet

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import net.kibotu.webviewbottomsheet.ui.theme.WebViewBottomSheetTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebViewBottomSheetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StartScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xff0563c1))
                            .padding(innerPadding),
                        onOpen = ::showWebViewSheet,
                    )
                }
            }
        }
    }

    private fun showWebViewSheet() {
        if (supportFragmentManager.findFragmentByTag(WebViewBottomSheetFragment.TAG) != null) return
        WebViewBottomSheetFragment().show(supportFragmentManager, WebViewBottomSheetFragment.TAG)
    }
}

@Composable
private fun StartScreen(modifier: Modifier = Modifier, onOpen: () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Button(onClick = onOpen) { Text("Open WebView") }
    }
}
