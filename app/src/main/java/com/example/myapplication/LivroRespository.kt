package com.example.myapplication

import androidx.lifecycle.LiveData

class LivroRespository(private val livroDao: LivroDao) {

        val readAllData: LiveData<List<Livro>> = livroDao.readAllData()


        suspend fun addLivro(livro: Livro) {
            livroDao.addLivro(livro)
        }

        suspend fun atualizarLivro(livro: Livro) {
            livroDao.atualizazarLivro(livro)
        }

        suspend fun deleteLivro(livro: Livro) {
            livroDao.deletarLivro(livro)
        }



}