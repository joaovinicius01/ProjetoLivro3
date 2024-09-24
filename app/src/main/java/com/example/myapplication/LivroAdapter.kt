package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Data class para representar um livro
data class Book(
    val nome_livro: String,
    val msg: String,
    val image: Int
)

// Adapter para a lista de livros
class livroAdapter(private val lista: List<Livro>) : RecyclerView.Adapter<livroAdapter.LivroViewHolder>() {

    inner class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNomeLivro: TextView = itemView.findViewById(R.id.Nome_livro)
        val txtMsg: TextView = itemView.findViewById(R.id.msg)
        val imgLivro: ImageView = itemView.findViewById(R.id.img_livro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.fragment_item_list, parent, false)
        return LivroViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = lista[position]
        holder.txtNomeLivro.text = livro.nome_livro
        holder.txtMsg.text = livro.msg
        holder.imgLivro.setImageResource(livro.image)
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}

// MainActivity que configura o RecyclerView
class segunda_tela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        val rvLivros: RecyclerView = findViewById(R.id.rvLivros)

        val livros = listOf(
            Livro("Tesouro Perdido", "Uma incrível jornada", R.drawable.tesouro_perdido),
            Livro("Mogli", "Mogli o Menino Lobo", R.drawable.mogli),
            Livro("American Pie", "Comédia", R.drawable.americanpie),
            Livro("O livro de Eli", "Ação", R.drawable.livrodeeli)
        )

        rvLivros.adapter = LivroAdapter(livros)
        rvLivros.layoutManager = LinearLayoutManager(this)
    }
}
