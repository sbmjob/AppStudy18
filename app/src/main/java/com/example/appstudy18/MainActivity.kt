package com.example.appstudy18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.File
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val str = StringBuilder()
        val txtMemo = findViewById<EditText>(R.id.txtMemo)

        //保管されているmemo.datを読み込む　memo.datが存在しない時はException
        try {
            openFileInput("fileOutput.dat")
                .bufferedReader().forEachLine {
                    str.append(it)
                    str.append(System.getProperty("line.separator"))
                }
            txtMemo.setText(str.toString())

        }catch(e: Exception){
            txtMemo.setText("")
        }

        val btn = findViewById<Button>(R.id.btnSave)
        //保管処理　memo.datが存在してもしなくても例外処理が不要
        btn.setOnClickListener {
//            この方法でも保管可能
//            openFileOutput("fileOutput.dat", MODE_PRIVATE)
//                .bufferedWriter().use {
//                    it.write(txtMemo.text.toString())
//                }

            //import java.io.Fileが必要だがこれでも保管可能
            File(filesDir,"fileOutput.dat")
                .writeText(txtMemo.text.toString())



        }
    }
}