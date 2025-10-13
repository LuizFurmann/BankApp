package com.furmannsoft.secutirystudy.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.furmannsoft.secutirystudy.R
import com.furmannsoft.secutirystudy.data.model.Card
import com.furmannsoft.secutirystudy.data.model.Transaction
import com.furmannsoft.secutirystudy.databinding.CardLayoutBinding
import com.furmannsoft.secutirystudy.databinding.RowTransactionLayoutBinding

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    private val listTransactions: ArrayList<Transaction> = ArrayList()
    private lateinit var context : Context

    fun updateList(listItems : List<Transaction>?){
        this.listTransactions.clear()
        this.listTransactions.addAll(listItems!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding : RowTransactionLayoutBinding = RowTransactionLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var currentItem = listTransactions[position]
        val previousItem = if (position > 0) listTransactions[position - 1] else null
        holder.bindData(currentItem, previousItem)
    }

    override fun getItemCount(): Int {
        return listTransactions.size
    }

    class ViewHolder(binding: RowTransactionLayoutBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        val transactionPlace: TextView = binding.tvTransactionPlace
        val transactionAmount: TextView = binding.tvTransactionAmount
        var transactionDate : TextView = binding.tvTransactionDate

        fun bindData(item: Transaction, previousItem: Transaction?){
            transactionPlace.setText(item.transactionPlace)
            transactionAmount.setText(item.transactionAmout)
            transactionDate.setText(item.transactionDate)

            // Se a data do item anterior for igual, esconde a data deste item
            if (previousItem != null && previousItem.transactionDate == item.transactionDate) {
                transactionDate.visibility = View.GONE
            } else {
                transactionDate.visibility = View.VISIBLE
            }
        }
    }
}