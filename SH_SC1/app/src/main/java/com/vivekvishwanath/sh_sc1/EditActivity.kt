package com.vivekvishwanath.sh_sc1

import android.app.Activity
import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vivekvishwanath.sh_sc1.Movie.Companion.MOVIE_KEY
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        save_button.setOnClickListener {
            val movie = Movie()
            movie.movieTitle = movie_title_text.text.toString()
            movie.isWatched = watched_switch.isChecked
            val intent = Intent()
            intent.putExtra(MOVIE_KEY, movie)
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}

