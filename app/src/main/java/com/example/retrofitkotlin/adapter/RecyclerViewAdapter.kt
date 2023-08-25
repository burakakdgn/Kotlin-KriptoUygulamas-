package com.example.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.R
import com.example.retrofitkotlin.model.CryptoModel


class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>,private val listener: Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener {

        fun onItemClick(cryptoModel: CryptoModel)
    }


    private val colors: Array<String> = arrayOf("#FD2D00","#005BFD","#7104B7","#984D02","#85021B")

    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun  bind(cryptoModel: CryptoModel,colors : Array<String>,position: Int,listener: Listener)  {

            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }

            itemView.setBackgroundColor(Color.parseColor(colors[position % 5]))
            val textCurrency=itemView.findViewById<TextView>(R.id.text_name)
            val textPrice=itemView.findViewById<TextView>(R.id.text_price)
            textCurrency.text = cryptoModel.currency
            textPrice.text = cryptoModel.price



        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {

        //kaç tane row olucağını söylüyoruz
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)

    }
}