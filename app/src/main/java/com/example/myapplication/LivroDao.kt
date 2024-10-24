package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface LivroDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addLivro (livro: Livro)

    @Update
    fun atualizazarLivro(livro: Livro)

    @Delete
    fun deletarLivro(livro: Livro)

    @Query("SELECT*FROM livro_table ")
    fun listarLivros()

    @Query("SELECT*FROM livro_table ORDER BY msg ASC")// trocar a msg pela forma como queremos chamar a ordem
    fun readAllData(): LiveData<List<Livro>>


}