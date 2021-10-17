package ru.geekbrains.universe.data.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import ru.geekbrains.universe.domain.entity.Movie
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class MovieListDeserializer : JsonDeserializer<List<Movie>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<Movie> {
        return json?.asJsonObject?.get("results")?.asJsonArray?.map {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            Movie(
                id = it.asJsonObject.get("id").asInt,
                originalTitle = it.asJsonObject.get("original_title").asString,
                overview = it.asJsonObject.get("overview").asString,
                posterPath = it.asJsonObject.get("poster_path").asString,
                releaseDate = format.parse(it.asJsonObject.get("release_date").asString),
            )
        } ?: arrayListOf()
    }
}