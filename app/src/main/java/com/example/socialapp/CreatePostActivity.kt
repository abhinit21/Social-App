package com.example.socialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socialapp.daos.PostDao
import kotlinx.android.synthetic.main.activity_create_post.*
import android.text.format.DateFormat
import java.util.*

class CreatePostActivity : AppCompatActivity() {

    private lateinit var postDao: PostDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        postDao = PostDao()

        postButton.setOnClickListener {
            val input = postInput.text.toString().trim()
            val date: Date = Date(dateOfBirthInput.date)

            val selectedDay = DateFormat.format("dd", date) as String // 05
            val selectedMonthString = DateFormat.format("MMM", date) as String // Jul
            val selectedYear = DateFormat.format("yyyy", date) as String // 2021

            val stringDate = "$selectedDay $selectedMonthString $selectedYear"

            if (input.isNotEmpty()) {
                postDao.addPost(input, stringDate)
                finish()
            }
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

    }
}