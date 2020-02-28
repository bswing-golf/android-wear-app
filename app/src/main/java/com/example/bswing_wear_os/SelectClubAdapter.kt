package com.example.bswing_wear_os

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.select_club_item_row.view.*

class SelectClubAdapter(private val clubList: Array<String>): RecyclerView.Adapter<SelectClubAdapter.ClubHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubHolder {
        val inflatedView = parent.inflate(R.layout.select_club_item_row, false)
        return ClubHolder(inflatedView)
    }

    override fun getItemCount() = this.clubList.size

    override fun onBindViewHolder(holder: ClubHolder, position: Int) {
        val itemClub = clubList[position]
        holder.bindClub(itemClub)
    }

    class ClubHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var club: String? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Helper.swingController.globalClubInstance.selectClub(Helper.clubList.getClubNameFromString(club))

            val context = itemView.context
            val selectedClubIntent = Intent(context, SwingNotStartedActivity::class.java)
            context.startActivity(selectedClubIntent)
        }

        fun bindClub(club: String) {
            this.club = club
            view.itemName.text = club
        }

    }
}