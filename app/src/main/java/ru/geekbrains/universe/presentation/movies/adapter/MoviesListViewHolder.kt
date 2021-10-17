package ru.geekbrains.universe.presentation.movies.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.geekbrains.universe.R
import ru.geekbrains.universe.presentation.model.MovieModel

class MoviesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var title: TextView = itemView.findViewById(R.id.title)
    private var poster: ImageView = itemView.findViewById(R.id.poster)
    private var glide = Glide.with(itemView.context)

    fun bind(movie: MovieModel) {
        title.text = movie.originalTitle

        glide
            .load(movie.posterPath)
            .error(R.drawable.ic_baseline_image_not_supported_24)
            .apply(
                RequestOptions
                    .circleCropTransform()
            )
            .into(poster)
    }
}