package com.doll.gustavo.firebaseexercice


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_listar.*
import kotlinx.android.synthetic.main.fragment_listar.view.*


class Listar : Fragment() {
    lateinit var listaJogos : MutableList<cadastro.Jogos>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        this.isDetached
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_listar, container, false)
        listaJogos = mutableListOf()

        cadastro().meubanco!!.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {

            }


            override fun onDataChange(p0: DataSnapshot?) {
                if (activity != null) {
                    if (p0!!.exists()) {
                        for (j in p0.children) {
                            val jogo = j.getValue(cadastro.Jogos::class.java)
                            listaJogos.add(jogo!!)
                        }

                        val adapter = Adapter(activity.applicationContext, R.layout.jogos, listaJogos)
                        listaJogosView.adapter = adapter
                    }
                }else{
                    return
                }
            }

        })
        

        return view


    }
    fun apagar(){
        //TErminar esta parte!!
        cadastro().meubanco!!.child("Jogos").child("-LLeEFrkmsgFi4dIov5T").setValue(null)
    }


}
