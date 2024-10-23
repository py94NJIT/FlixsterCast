package com.example.flixstercast
import java.io.Serializable
data class PopularPeopleResponse(
    val results: List<Person>
)

data class Person(
    val id: Int,
    val name: String,
    val profile_path: String,
    val best_known_work: String?, // Add this field
    val poster_path: String?, // Add this field for the poster
    val description: String? // Add this field for description
):Serializable

data class PersonDetails(
    val biography: String,
    val known_for: List<KnownFor>
)

data class KnownFor(
    val title: String,
    val poster_path: String
)
