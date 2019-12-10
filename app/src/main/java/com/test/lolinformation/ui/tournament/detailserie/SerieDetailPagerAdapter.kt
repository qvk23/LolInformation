package com.test.lolinformation.ui.tournament.detailserie

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.test.lolinformation.ui.tournament.match.MatchFragment

class SerieDetailPagerAdapter(fragmentManager: FragmentManager, private val listItem: List<Fragment>) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = listItem[position]

    override fun getCount(): Int = listItem.size
}
