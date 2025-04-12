package com.example.inputcontrol

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var txt_nama: EditText
    lateinit var txt_nohp: EditText
    lateinit var txt_email: EditText
    lateinit var txt_alamat: EditText

    lateinit var radio_grup: RadioGroup
    lateinit var btn_daftar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        init()
        btn_daftar.setOnClickListener {
            if (txt_nohp.text.toString().isEmpty()){
                Toast.makeText(this, "No Handphone tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (!txt_email.text.toString().contains("@")){
                Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show()
            }else if (radio_grup.checkedRadioButtonId==-1) {
                Toast.makeText(this, "Harus memilih jenis kelamin", Toast.LENGTH_SHORT).show()
            }else if (txt_alamat.text.toString().isEmpty()){
                Toast.makeText(this, "Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun init(){
        txt_nama = findViewById(R.id.txt_nama)
        txt_nohp = findViewById(R.id.txt_noHp)
        txt_email = findViewById(R.id.txt_email)
        txt_alamat = findViewById(R.id.txt_alamat)

        radio_grup = findViewById(R.id.radio_grup)
        btn_daftar = findViewById(R.id.btn_daftar)
    }
}