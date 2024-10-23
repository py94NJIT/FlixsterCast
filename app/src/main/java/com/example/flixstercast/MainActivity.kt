package com.example.flixstercast


import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flixstercast.databinding.ActivityMainBinding
import com.example.flixstercast.PeopleViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: PeopleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.popularPeople.observe(this) { people ->
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = PeopleAdapter(people) { person ->
                val intent = Intent(this, PersonDetailActivity::class.java)
                intent.putExtra("person_key", person) // Pass the entire person object
                startActivity(intent)
            }
        }
    }
}
