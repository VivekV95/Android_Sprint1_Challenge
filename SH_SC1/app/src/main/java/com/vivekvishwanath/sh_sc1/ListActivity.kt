package com.vivekvishwanath.sh_sc1

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.vivekvishwanath.sh_sc1.Movie.Companion.MOVIE_KEY
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    companion object {
        const val MOVIE_REQUEST_CODE = 123
    }

    val movieList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        add_movie_button.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, MOVIE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == MOVIE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val movie = data?.getSerializableExtra(MOVIE_KEY) as Movie
            movieList.add(movie)
            displayMovies()
        }
    }

    fun createTextview(movie: Movie): TextView {
        val textview = TextView(this)
        textview.textSize = 16f
        textview.text = movie.movieTitle
        if (movie.isWatched) textview.setTextColor(resources.getColor(R.color.colorPrimary))
        else textview.setTextColor(resources.getColor(R.color.colorAccent))

        return textview
    }

    fun displayMovies() {
        movie_list_layout.removeAllViews()
        /* for (movie in movieList) {
            val textview = createTextview(movie)
            movie_list_layout.addView(textview)
        }*/
        movieList.forEach {
            val textview = createTextview(it)
            movie_list_layout.addView(textview)
        }
    }
}
