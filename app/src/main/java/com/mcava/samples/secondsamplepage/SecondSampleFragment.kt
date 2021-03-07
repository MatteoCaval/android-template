package com.mcava.samples.secondsamplepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mcava.samples.R
import kotlinx.android.synthetic.main.fragment_sample_second.view.*

class SecondSampleFragment : Fragment(R.layout.fragment_sample_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val flowStepNumber = arguments?.getInt("flowStepNumber") // vecchio modo
        val safeArgs: SecondSampleFragmentArgs by navArgs()
        val flowStepNumber = safeArgs.flowStepNumber
        Toast.makeText(context, flowStepNumber.toString(), Toast.LENGTH_SHORT).show()


        view.txv.setOnClickListener {
//            findNavController().navigate(R.id.go_home)
            SecondSampleFragmentDirections.goHome()
        }

    }

}