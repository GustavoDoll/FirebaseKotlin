package com.doll.gustavo.firebaseexercice


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.jogos.view.*

class Adapter(val mcontext: Context, val layoutId:Int, val lista:List<cadastro.Jogos>)
    :ArrayAdapter<cadastro.Jogos>(mcontext,layoutId,lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mcontext )
        val view:View = layoutInflater.inflate(layoutId,null)

        val nameView = view.nome
        val anoView = view.ano
        val genView = view.genero
        val platView = view.plataforma

        val jogo = lista[position]

        nameView.text = jogo.nomeJogo
        anoView.text = jogo.anoJogo
        genView.text = jogo.generoJogo
        platView.text = jogo.plataformaJogo

        return view
    }
}