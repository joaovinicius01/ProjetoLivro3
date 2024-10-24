package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.databinding.FragmentItemBinding


class MyItemRecyclerViewAdapter(
    private val values: List<Livro>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nomeLivroView.text = item.nome_livro
        holder.msgView.text = item.msg
    }


    override fun getItemCount(): Int = values.size


    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val nomeLivroView: TextView = binding.NomeLivro
        val msgView: TextView = binding.NomeLivro


        override fun toString(): String {
            return super.toString() + " '" + msgView.text + "'"
        }
    }
}
