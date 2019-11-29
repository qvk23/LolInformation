package com.test.lolinformation.ui.main

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.test.lolinformation.R
import kotlinx.android.synthetic.main.fragment_bottom_dialog.*

class BottomDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_dialog, container, false)
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    private fun initComponent() {
        val navController = activity?.findNavController(R.id.navHostfragment)
        AppBarConfiguration(setOf(R.id.gamePlayFragment, R.id.tournamentFragment))
        navController?.let { navigationViewMain.setupWithNavController(it) }
    }

    companion object {
        fun newInstance() = BottomDialogFragment()
    }
}
