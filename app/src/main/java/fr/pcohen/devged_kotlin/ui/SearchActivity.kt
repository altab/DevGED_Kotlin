package fr.pcohen.devged_kotlin.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import fr.pcohen.devged_kotlin.R
import fr.pcohen.devged_kotlin.base.BaseActivity
import fr.pcohen.devged_kotlin.ui.search.SearchFragment
import javax.inject.Inject

class SearchActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }

}
