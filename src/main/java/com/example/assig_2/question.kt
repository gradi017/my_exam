package com.example.assig_2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class question : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        val songs = intent.getStringArrayExtra("SONGS") ?: arrayOf()
        val artists = intent.getStringArrayExtra("ARTISTS") ?: arrayOf()
        val ratings = intent.getIntArrayExtra("RATINGS") ?: intArrayOf()
        val comments = intent.getStringArrayExtra("COMMENTS") ?: arrayOf()

        val viewBtn = findViewById<Button>(R.id.view_btn)
        val rating_cal = findViewById<Button>(R.id.rat_btn)
        val return_btm = findViewById<Button>(R.id.main_btn)
        val rev_txt = findViewById<TextView>(R.id.rev_txt)
        val avg_txt = findViewById<TextView>(R.id.avg_txt)

        viewBtn.setOnClickListener {
            // Build the display text
            val allSongsText = StringBuilder()
            for (i in songs.indices) {
                allSongsText.append("""
            Song: ${songs[i]}
            Artist: ${artists[i]}
            Rating: ${ratings[i]}
            Comment: ${comments[i]}
            
            """.trimIndent())
            }

            // Display everything
            rev_txt.text = allSongsText.toString()

        }

        rating_cal.setOnClickListener {
            val average = ratings.average()
            avg_txt.text = "Average Rating: ${"%.1f".format(average)}/5"
        }

        return_btm.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}