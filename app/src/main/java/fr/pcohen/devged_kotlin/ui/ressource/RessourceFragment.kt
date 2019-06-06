package fr.pcohen.devged_kotlin.ui.ressource

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import fr.pcohen.devged_kotlin.base.BaseFragment
import fr.pcohen.devged_kotlin.databinding.FragmentRessourceBinding
import javax.inject.Inject

class RessourceFragment : BaseFragment() {

    companion object {
        private val TAG = RessourceFragment::class.java.simpleName
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var passwordChangeViewModel: RessourceViewModel

    private lateinit var binding: FragmentRessourceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        passwordChangeViewModel = ViewModelProviders.of(this, viewModelFactory).get(RessourceViewModel::class.java)

        binding = FragmentRessourceBinding.inflate(inflater, container, false)

        return binding.root
    }


}