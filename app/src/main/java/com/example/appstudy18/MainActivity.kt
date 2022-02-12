package com.example.appstudy18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val str = StringBuilder()
        openFileInput("memo.dat")
            .bufferedReader().forEachLine {
                str.append(it)
                str.append(System.getProperty("line.separator"))
            }


        val txtMemo = findViewById<EditText>(R.id.txtMemo)
        val btn = findViewById<Button>(R.id.btnSave)

        txtMemo.setText(str.toString())


        btn.setOnClickListener {

            openFileOutput("memo.dat", MODE_PRIVATE)
                .bufferedWriter().use {
                    it.write(txtMemo.text.toString())
                }
        }






    }
}