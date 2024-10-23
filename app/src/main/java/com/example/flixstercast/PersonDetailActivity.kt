package com.example.flixstercast


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.flixstercast.databinding.ActivityPersonDetailBinding


class PersonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the Person object from the intent
        val person = intent.extras?.getSerializable("person_key") as? Person

        // Display the person's details
        person?.let {
            //binding.personBio = it.name
            binding.personKnownFor.text = it.best_known_work
            binding.personBio.text = it.description
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + it.poster_path)
                .into(binding.personPoster) // Assuming you have an ImageView for poster
        }
    }
}

