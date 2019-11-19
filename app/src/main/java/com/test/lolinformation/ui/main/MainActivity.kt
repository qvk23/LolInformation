package com.test.lolinformation.ui.main

import android.view.View
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

    override fun onClick(view: View?) {
        val bottomDialogFragment = BottomDialogFragment.newInstance()
        bottomDialogFragment.show(supportFragmentManager, bottomDialogFragment.tag)
    }
}
