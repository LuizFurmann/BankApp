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

    var hideAmount = false

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
        showHideAmount()
    }

    fun setupRecyclerView() {

        val cardList = arrayListOf(
            Card(1, "Nubank", "MasterCard", "Crédito", "123123123"),
            Card(2, "Caixa", "Visa", "Débito", "123123123")
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

    fun showHideAmount() {
        binding.btnVisibility.setBackgroundResource(R.drawable.ic_visibility_off)
        binding.btnVisibility.setOnClickListener {

            if(hideAmount){
                binding.btnVisibility.setBackgroundResource(R.drawable.ic_visibility_off)
                hideAmount = false
                binding.tvBalanceAmount.text = "R$ 131.670,30"
            } else {
                binding.btnVisibility.setBackgroundResource(R.drawable.ic_visibility_on)
                hideAmount = true

                binding.tvBalanceAmount.text = "R$ ***,**"
            }
        }
    }
}