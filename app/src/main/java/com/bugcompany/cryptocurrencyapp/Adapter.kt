package com.bugcompany.cryptocurrencyapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugcompany.cryptocurrencyapp.databinding.CardDesignBinding

class Adapter(var mContext: Context, var cryptoList: ArrayList<CryptoModel>) :
    RecyclerView.Adapter<Adapter.CardDesign>() {


    inner class CardDesign(val binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesign(binding)

    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val color: Array<Int> = arrayOf(
            Color.BLUE,
            Color.CYAN,
            Color.GRAY,
            Color.GREEN,
            Color.MAGENTA,
            Color.YELLOW,
            Color.RED,
            Color.TRANSPARENT
        )
        val crypto = cryptoList[position]
        holder.binding.textViewCurrency.text = crypto.currency
        holder.binding.textViewPrice.text = crypto.price
        holder.itemView.setBackgroundColor(color[position % 8])


    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }


}