package com.trihkfoods.main.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trihkfoods.main.R
import com.trihkfoods.main.databinding.ListItemCartChefBinding

class CartChefListAdapter {

    class ViewHolder(binding:ListItemCartChefBinding): RecyclerView.ViewHolder(binding.root){

        companion object{

            fun from(parent:ViewGroup):ViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemCartChefBinding.inflate(inflater, parent,false)
                return ViewHolder(binding)
            }
        }
    }
}