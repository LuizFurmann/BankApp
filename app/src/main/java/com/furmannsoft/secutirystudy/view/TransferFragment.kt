package com.furmannsoft.secutirystudy.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.furmannsoft.secutirystudy.R
import com.furmannsoft.secutirystudy.data.model.Card
import com.furmannsoft.secutirystudy.data.model.Transaction
import com.furmannsoft.secutirystudy.databinding.FragmentHomeBinding
import com.furmannsoft.secutirystudy.databinding.FragmentTransferBinding

class TransferFragment : Fragment() {
    private var _binding: FragmentTransferBinding? = null
    private val binding get() = _binding!!

    val transactionAdapter = TransactionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransferBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    fun setupRecyclerView() {

        val transactionList = arrayListOf(
            Transaction(1, "Cafe da esquina", "Débito", "50,00", "10/10/2025"),
            Transaction(2, "Restaurante da avenida", "Crédito", "130,00","10/10/2025"),
            Transaction(3, "Loja de roupa", "Crédito", "230,00","10/10/2025"),
            Transaction(4, "Posto de combustível", "Débito", "100,00","09/10/2025"),
            Transaction(5, "Padaria", "Débito", "50,00","09/10/2025"),
            Transaction(6, "Restaurante", "Crédito", "70,00","08/10/2025"),
        )

        binding.rvTransactions.adapter = transactionAdapter
        binding.rvTransactions.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvTransactions.setHasFixedSize(true)


        updateList(transactionList)

    }

    private fun updateList(productList: List<Transaction>) {
        if (productList.isEmpty()) {
//            binding.rvExercise.visibility = View.GONE
//            binding.myExercisesTittle.visibility = View.GONE
//            binding.emptyExerciseList.visibility = View.VISIBLE
        } else {

            transactionAdapter.updateList(productList)
        }
    }
}