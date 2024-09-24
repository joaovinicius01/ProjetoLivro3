package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.databinding.FragmentItemBinding

// Adapter para exibir a lista de livros
class MyItemRecyclerViewAdapter(
    private val values: List<Livro> // Alterado para o tipo correto 'Livro'
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    // Cria o ViewHolder e infla o layout para cada item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Associa os dados do item da lista com as views
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nomeLivroView.text = item.nome_livro
        holder.msgView.text = item.msg
    }

    // Retorna o tamanho da lista
    override fun getItemCount(): Int = values.size

    // ViewHolder interno para gerenciar as views de cada item
    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val nomeLivroView: TextView = binding.NomeLivro // Referência ao TextView do nome do livro
        val msgView: TextView = binding.NomeLivro // Referência ao TextView da mensagem (ou descrição) do livro

        // Para fins de debug ou visualização do estado atual do ViewHolder
        override fun toString(): String {
            return super.toString() + " '" + msgView.text + "'"
        }
    }
}
