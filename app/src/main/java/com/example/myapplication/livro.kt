package com.example.myapplication

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "livro_table")
data class Livro(
    @PrimaryKey(autoGenerate = true) //autoincrement
    val nome_livro: String,
    val msg: String,
    val image: Int


) : Parcelable


class LivroAdapter(
    private val lista: List<Livro>
) : RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.fragment_item_list, parent, false)
        return LivroViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = lista[position]
        holder.txtNome.text = livro.nome_livro
        holder.txtMsg.text = livro.msg
        holder.imgLivro.setImageResource(livro.image)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNome: TextView = itemView.findViewById(R.id.Nome_livro)
        val txtMsg: TextView = itemView.findViewById(R.id.msg)
        val imgLivro: ImageView = itemView.findViewById(R.id.img_livro)
    }
}


class segundaTela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)


        val listaLivros = listOf(
            Livro("Tesouro Perdido", "Uma incrível jornada", R.drawable.tesouro_perdido),
            Livro("Mogli", "Mogli o menino Lobo", R.drawable.mogli),
            Livro("American Pie", "Comédia", R.drawable.americanpie),
            Livro("Livro de Eli", "Aventura sem fim", R.drawable.livrodeeli)
        )


        val rvLivros: RecyclerView = findViewById(R.id.rvLivros)
        rvLivros.adapter = LivroAdapter(listaLivros)
        rvLivros.layoutManager = LinearLayoutManager(this)
    }
}
