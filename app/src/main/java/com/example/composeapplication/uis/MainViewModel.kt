package com.example.composeapplication.uis

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.retrofit.MainRepository
import com.example.composeapplication.utills.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val mainRepository: MainRepository) : ViewModel() {

    val response: MutableState<ApiState> = mutableStateOf(ApiState.Empty)
    init {
        getPost()
    }

    fun getPost() = viewModelScope.launch {
        mainRepository.getPost()
            .onStart {
                response.value = ApiState.Loading
            }.catch {

                response.value = ApiState.Failure(it)
            }.collect {
                response.value = ApiState.Success(it)
            }

    }

}