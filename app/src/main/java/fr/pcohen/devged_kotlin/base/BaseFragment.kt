package fr.pcohen.devged_kotlin

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment


abstract class BaseFragment : DaggerFragment(), OnBackPressedCallback {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, this)
    }

    override fun handleOnBackPressed(): Boolean {
        return findNavController().popBackStack()
    }
}