package com.furmannsoft.secutirystudy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.furmannsoft.secutirystudy.R
import com.furmannsoft.secutirystudy.data.model.Card
import com.furmannsoft.secutirystudy.databinding.FragmentHomeBinding
import com.furmannsoft.secutirystudy.databinding.FragmentTransferBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val cardAdapter = CardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    fun setupRecyclerView() {

        val cardList = arrayListOf(
            Card(1, "Visa", "Crédito", "1234567890123456"),
            Card(2, "Mastercard", "Débito", "64378264864784")
        )

        binding.rvCards.adapter = cardAdapter
        binding.rvCards.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCards.setHasFixedSize(true)


        updateList(cardList)

    }

    private fun updateList(productList: List<Card>) {
        if (productList.isEmpty()) {
//            binding.rvExercise.visibility = View.GONE
//            binding.myExercisesTittle.visibility = View.GONE
//            binding.emptyExerciseList.visibility = View.VISIBLE
        } else {

            cardAdapter.updateList(productList)
        }
    }
}