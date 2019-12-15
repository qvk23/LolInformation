package com.test.lolinformation.ui.main

import android.view.Menu
import android.view.View
import android.widget.SearchView
import com.test.lolinformation.R
import com.test.lolinformation.databinding.ActivityMainBinding
import com.test.lolinformation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(),
    View.OnClickListener {

    override val viewModel: MainActivityViewModel by viewModel()
    override val layoutId: Int = R.layout.activity_main

    override fun initView() {
        setSupportActionBar(bottomAppBarMain)
        bottomAppBarMain.setNavigationOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        onSearch(searchView)
        return true
    }

    private fun onSearch(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let(viewModel::getQuery)
                return false
            }

        })
    }

    override fun onClick(view: View?) {
        val bottomDialogFragment = BottomDialogFragment.newInstance()
        bottomDialogFragment.show(supportFragmentManager, bottomDialogFragment.tag)
    }
}
