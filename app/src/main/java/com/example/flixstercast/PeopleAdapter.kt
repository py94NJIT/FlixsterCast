package com.example.flixstercast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixstercast.databinding.ItemPersonBinding
import com.example.flixstercast.Person

class PeopleAdapter(private val people: List<Person>, private val onPersonClick: (Person) -> Unit) :
    RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    class PeopleViewHolder(val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val person = people[position]
        holder.binding.personName.text = person.name
        Glide.with(holder.binding.personImage.context)
            .load("https://image.tmdb.org/t/p/w500" + person.profile_path)
            .into(holder.binding.personImage)

        holder.itemView.setOnClickListener {
            onPersonClick(person)
        }
    }

    override fun getItemCount() = people.size
}

