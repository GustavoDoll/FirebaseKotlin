package com.doll.gustavo.firebaseexercice


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_cadastro.*
import kotlinx.android.synthetic.main.fragment_cadastro.view.*


class cadastro : Fragment() {
    val meubanco:DatabaseReference? = FirebaseDatabase.getInstance().getReference("Jogos")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var lista = Listar()
        // Inflate the layout for this fragment
        var view =   inflater.inflate(R.layout.fragment_cadastro, container, false)


        view.cadastrar.setOnClickListener {if(!view.data.text.isEmpty() && !view.genero.text.isEmpty() && !view.nome.text.isEmpty() && !view.plataforma.text.isEmpty()) {
            var id: String = meubanco!!.push().key
            var user = Jogos(id, nome.text.toString(), genero.text.toString(), data.text.toString(), plataforma.text.toString())
            meubanco.child(id).setValue(user)
            reset()
            fragmentManager.beginTransaction().replace(R.id.tela,lista).commit()
            fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss()




        }else{
            data.setError("Preencha a data")
            nome.setError("Preencha o nome")
            plataforma.setError("Preencha a plataforma")
            genero.setError("Preencha o genero")

        }
        }
        return view


    }
    fun reset(){
        view.data.text = null
        view.genero.text = null
        view.plataforma.text = null
        view.nome.text = null
    }

    data class Jogos(var _id:String = "",
                       var nomeJogo:String = "",
                       var generoJogo:String = "",
                       var anoJogo:String = "",
                       var plataformaJogo:String = "")




}
