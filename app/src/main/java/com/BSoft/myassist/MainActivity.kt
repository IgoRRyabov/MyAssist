package com.BSoft.myassist

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val goWindowAuth : TextView = findViewById(R.id.go_window_auth)
        goWindowAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        val userLogin : EditText = findViewById(R.id.user_login)
        val userEmail : EditText = findViewById(R.id.user_email)
        val userPassword : EditText = findViewById(R.id.user_password)

        val buttonReg : Button = findViewById(R.id.button_reg)

        buttonReg.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login == "" || email == "" || password == ""){
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }else{
                val user = User(login, email, password)

                val db = DbHelper(this, null)
                db.addUsers(user)
                Toast.makeText(this, "Пользователь $login добавлен!", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }

        }
    }
}