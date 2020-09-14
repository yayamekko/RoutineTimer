package com.yayame.routinetimer.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yayame.routinetimer.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO ここを押したらルーチン編集画面に遷移する
        findViewById<Button>(R.id.edit_routine_button).setOnClickListener {
            startActivity(Intent(this, AppActivity::class.java))
        }
    }
}
