package com.test.lolinformation.ui.gameplay.detailchamp

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.test.lolinformation.R
import com.test.lolinformation.databinding.DetailChampionFragmentBinding
import com.test.lolinformation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailChampionFragment :
    BaseFragment<DetailChampionFragmentBinding, DetailChampionViewModel>() {

    override val viewModel: DetailChampionViewModel by viewModel()
    override val layoutId: Int = R.layout.detail_champion_fragment
    private val args: DetailChampionFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.apply {
            args.championArg.let {
                setChampionValue(it)
            }
        }
    }

    override fun initView() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().popBackStack(R.id.championFragment, false)
            (activity as AppCompatActivity).run {
                supportActionBar?.show()
            }
        }
        (activity as AppCompatActivity).run {
            supportActionBar?.hide()
        }
    }

    override fun observeData() {}
}
