package com.example.efrainjuarez.Componentes

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.efrainjuarez.api.NetworkResponse
import com.example.efrainjuarez.miviewmodel.ClimaViewModel

@Composable
fun PantallaClima(viewModel: ClimaViewModel,modifier: Modifier){

    var ciudad by remember{ mutableStateOf("") }
    val resultado=viewModel.resultado//observeState
    Column(modifier = Modifier.fillMaxSize()){
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)
            , verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceEvenly

        ){
            OutlinedTextField(value = ciudad,
                onValueChange= {ciudad=it}
                    , label = { Text("ciudad para el clima")})
            IconButton(onClick = {viewModel.getData(ciudad)}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "buscar")
            }

            }
        when(val result=resultado.value){
            is NetworkResponse.Error->Text(text = result.Message)
            NetworkResponse.loading->Text(text = "El contenido esta cargando...")
            is NetworkResponse.Success->{Text(text = result.data.toString())
                Log.d("respuesta", result.data.toString())
            }
            else -> {}

        }



        }
    }
