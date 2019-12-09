package com.test.lolinformation.ui.gameplay

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class GamePlayPagerAdapter(
    fragmentManager: FragmentManager,
    private val listItem: List<Fragment>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = listItem.get(position)

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> CHAMPION
            1 -> ITEM
            else -> CHAMPION
        }
    }

    override fun getCount(): Int = NUM_PAGER

    companion object {
        const val NUM_PAGER = 2
        const val CHAMPION = "Champion"
        const val ITEM = "Item"
    }
}
