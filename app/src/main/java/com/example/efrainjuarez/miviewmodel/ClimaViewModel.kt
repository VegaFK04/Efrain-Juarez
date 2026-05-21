package com.example.efrainjuarez.miviewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.efrainjuarez.api.InstanciaRetroFit
import com.example.efrainjuarez.api.Modelos.ClimaModel
import com.example.efrainjuarez.api.NetworkResponse
import kotlinx.coroutines.launch

class ClimaViewModel: ViewModel(){
    private val ClimaApi= InstanciaRetroFit().climaApi

    private val _climaRes= MutableLiveData<NetworkResponse<ClimaModel>>()
    val resultado=_climaRes

    fun getData(ciudad: String){
        _climaRes.value= NetworkResponse.loading
        viewModelScope.launch {
            try {
                val res = ClimaApi.getClima("f0ca34efcba8616c4e49071939938188", ciudad, "metric")
                if(res.isSuccessful) {
                    res.body()?.let {
                        _climaRes.value= NetworkResponse.Success(it)
                    }
                } else {
                    _climaRes.value= NetworkResponse.Error("No se pudieron cargar los datos")

                }
            }catch (e: Exception){
                _climaRes.value= NetworkResponse.Error("Un error inesperado acaba de suceder")
               //vincular composable con interfaz
            }
        }
    }
}
