package com.test.lolinformation.ui.gameplay

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.ListFragment
import com.test.lolinformation.ui.gameplay.container.ChampionContainerFragment

class GamePlayPagerAdapter(
    fragmentManager: FragmentManager,
    private val listItem: List<Fragment>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        var item = Fragment()
        if (position == 0) item = listItem.get(FIRST_PAGE)
        return item
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> CHAMPION
            1 -> ITEM
            else -> CHAMPION
        }
    }

    override fun getCount(): Int = NUM_PAGER

    companion object {
        const val FIRST_PAGE = 0
        const val NUM_PAGER = 1
        const val CHAMPION = "Champion"
        const val ITEM = "Item"
    }
}
