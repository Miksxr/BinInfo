package com.example.bininfo.presentation.screens.bininput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BinInputScreen(
    viewModel: BinInputViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onNavigateToHistory: () -> Unit
) {
    var bin by remember { mutableStateOf("") }
    val state = viewModel.state.collectAsState().value

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(value = bin, onValueChange = { bin = it }, label = { Text("Enter BIN") })
        Button(onClick = { viewModel.fetchBinInfo(bin) }, modifier = Modifier.padding(top = 8.dp)) {
            Text("Search")
        }
        Button(onClick = onNavigateToHistory, modifier = Modifier.padding(top = 8.dp)) {
            Text("View History")
        }

        state.binInfo?.let {
            Text("Scheme: ${it.scheme}")
            Text("Type: ${it.type}")
            Text("Bank: ${it.bankName}")
        }

        state.error?.let {
            Text("Error: $it", color = Color.Red)
        }
    }
}