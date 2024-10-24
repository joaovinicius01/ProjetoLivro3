package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LivroViewModel(application: Application) : AndroidViewModel(application) {

    val listaLivros: LiveData<List<Livro>>
    private val repository: LivroRespository

    init {
        val livroDao = LivroDataBase.getDatabase(application).livroDao()
        repository = LivroRespository(livroDao)
        listaLivros = repository.readAllData
    }

    fun addLivro(livro: Livro) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLivro(livro)
        }
    }

    fun updateLivro(livro: Livro) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.atualizarLivro(livro)
        }
    }

    fun deleteLivro(livro: Livro) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteLivro(livro)
        }
    }



}
