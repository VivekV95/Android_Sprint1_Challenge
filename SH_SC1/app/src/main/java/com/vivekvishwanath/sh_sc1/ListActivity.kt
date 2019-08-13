package com.vivekvishwanath.sh_sc1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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
        }
    }

    fun createTextview(movie: Movie) {
        val textview = TextView(this)
        textview.height = 20
        textview.textSize = 16f
        textview.text = movie.movieTitle
        if (movie.isWatched)
    }
}
