package com.mcava.samples.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.mcava.samples.R
import com.mcava.samples.dialogs.FullScreenDialog
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val vm: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        view.btnFullScreenDialog.setOnClickListener {
            val dialog = FullScreenDialog.newInstance()
            dialog.show(parentFragmentManager, "tag")
        }

        view.btnNavigate.setOnClickListener {
            navigateToSecondSampleScreen()
        }

        vm.doSomething()

    }

    private fun navigateToSecondSampleScreen() {

        findNavController().navigate(
            // safe args direction classes
            // se non metto valore di default devo passare per forza il parametro
            HomeFragmentDirections.actionHomeFragmentToSecondSampleFragment(4)
        )

//        findNavController().navigate(R.id.action_homeFragment_to_secondSampleFragment)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController()) || super.onOptionsItemSelected(item)
    }
}