package com.furmannsoft.secutirystudy.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.furmannsoft.secutirystudy.R
import com.furmannsoft.secutirystudy.data.model.Card
import com.furmannsoft.secutirystudy.databinding.CardLayoutBinding

class CardAdapter : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    private val listCard: ArrayList<Card> = ArrayList()
    private lateinit var context : Context

    fun updateList(listItems : List<Card>?){
        this.listCard.clear()
        this.listCard.addAll(listItems!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding : CardLayoutBinding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var currentItem = listCard[position]
        holder.bindData(currentItem)
    }

    override fun getItemCount(): Int {
       return listCard.size
    }

    class ViewHolder(binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        val cardNumber: TextView = binding.tvCardNumber
        val cardType: TextView = binding.tvCardType
        var cardFlag : ImageView = binding.imgCardFlag
        val cardBank : ConstraintLayout = binding.cardBank

        fun bindData(item: Card){
            cardNumber.setText(item.cardNumber)
            cardType.setText(item.cardType)

            if(item.cardBank == "Nubank"){
                cardBank.setBackgroundResource(R.drawable.bg_nubank)
            } else if(item.cardBank == "Caixa") {
                cardBank.setBackgroundResource(R.drawable.bg_caixa)
            }

            if(item.cardFlag == "MasterCard"){
                cardFlag.setBackgroundResource(R.drawable.ic_mastercard_logo)
            } else if(item.cardFlag == "Visa") {
                cardFlag.setBackgroundResource(R.drawable.ic_visa)
            }
        }
    }
}
