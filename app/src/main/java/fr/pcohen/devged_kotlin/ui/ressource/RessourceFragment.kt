package fr.pcohen.devged_kotlin.ui.ressource

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import fr.pcohen.devged_kotlin.base.BaseFragment
import fr.pcohen.devged_kotlin.business.Ressource
import fr.pcohen.devged_kotlin.business.Type
import fr.pcohen.devged_kotlin.databinding.FragmentRessourceBinding
import org.threeten.bp.LocalDateTime.now
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

        var type: String? = null

        passwordChangeViewModel = ViewModelProviders.of(this, viewModelFactory).get(RessourceViewModel::class.java)
        binding = FragmentRessourceBinding.inflate(inflater, container, false)

        val adapter = ArrayAdapter(context!!, R.layout.simple_spinner_item, listOf("URL", "TEXT"))
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        val title = binding.textinputTitle.text
        val ressource = binding.editTextRessource.text
        val listTags = binding.TextinputTags.text

        binding.spinnerType.adapter = adapter
        binding.spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val item = adapter.getItem(position)
                Log.d(TAG, "item selected : $item")
                when (item) {
                    Type.TEXT.toString() -> type = item
                    Type.URL.toString() -> type = item
                }
            }
        }

        binding.buttonSave.setOnClickListener {
            val objetRessource = Ressource(
                null,
                title.toString(),
                ressource.toString(),
                now(),
                transformStringToTags(listTags.toString()),
                type!!
            )
        }

        return binding.root
    }

    private fun transformStringToTags(listTags: String): List<String> {
        return listTags.split(",").map { it -> it.trim() }
    }


}

/*
<com.google.android.material.textfield.TextInputLayout
android:layout_width="0dp"
android:layout_height="wrap_content"
app:layout_constraintStart_toStartOf="@+id/textInputLayout"
app:layout_constraintEnd_toEndOf="@+id/textInputLayout"
app:layout_constraintTop_toBottomOf="@+id/spinner_type"
android:id="@+id/intextinput_ressource"
android:layout_margin="10dp">

<com.google.android.material.textfield.TextInputEditText
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:hint="@string/url"/>

</com.google.android.material.textfield.TextInputLayout>*/
