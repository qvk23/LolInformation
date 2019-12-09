package com.test.lolinformation.ui.tournament

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.test.lolinformation.ui.tournament.series.SerieFragment

class TournamentPagerAdapter(
    fragmentManager: FragmentManager,
    private val pageTitles: List<String>
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = SerieFragment.newInstance(pageTitles.get(position))

    override fun getPageTitle(position: Int): CharSequence? = pageTitles.get(position)

    override fun getCount(): Int = pageTitles.size
    companion object {
        const val LCK_ITEM = "LCK"
        const val LEC_ITEM = "LEC"
        const val LPL_ITEM = "LPL"
    }
}
