package com.example.rickmortyv3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmortyv3.R
import com.example.rickmortyv3.ui.all_characters.AllCharactersFragment
import com.example.rickmortyv3.ui.create_character.CreateNewCharacterFragment
import com.example.rickmortyv3.ui.create_character.CreatedCharactersFragment

private const val NUM_TABS = 4

//class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
//    FragmentStateAdapter(fragmentManager, lifecycle) {
//
//    override fun getItemCount(): Int {
//        return NUM_TABS
//    }
//
//    override fun createFragment(position: Int): Fragment {
//        when (position) {
//            0 -> return HomeFragment()
//            1 -> return AllCharactersFragment()
//            2 -> return CreateNewCharacterFragment()
//            3 -> return CreatedCharactersFragment()
//        }
//        return Fragment()
//    }
//}

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.EventViewHolder>() {
    val eventList = listOf(HomeFragment(), AllCharactersFragment(), CreateNewCharacterFragment(), CreatedCharactersFragment())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EventViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_layout_viewpager2, parent, false))

    override fun getItemCount() = eventList.count()
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
//        (holder.view as? TextView)?.also{
            eventList.get(position)
//        }
    }

    class EventViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}