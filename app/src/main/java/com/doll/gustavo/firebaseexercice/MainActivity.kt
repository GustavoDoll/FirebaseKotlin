package com.doll.gustavo.firebaseexercice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var cadastroTela = cadastro()
    var listarTela = Listar()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adicionar.setOnClickListener {

           fragmentManager.beginTransaction().replace(R.id.tela,cadastroTela).commit()
        }
        listar.setOnClickListener {

            fragmentManager.beginTransaction().replace(R.id.tela,listarTela ).commit()
        }
    }
}
