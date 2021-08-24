package com.advnmpproj.adv160818008homeworkweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class MainFragment : Fragment() {
    var mathRes = 0
    var score = 0
    var answer = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refreshQuestion()

        btnAnswer.setOnClickListener {
            answer = Integer.parseInt(txtAnswer.text.toString())

            if(answer == mathRes)
            {
                score++
                refreshQuestion()
            }
            else
            {
                val action = MainFragmentDirections.actionResultFrag(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun refreshQuestion()
    {
        var num1 = Random.nextInt(1, 30)
        var num2 = Random.nextInt(1, 30)
        mathRes = num1 + num2

        txtQuestion.text = "$num1 + $num2"
    }
}