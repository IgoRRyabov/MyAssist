package com.BSoft.myassist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)

        val goWindowReg : TextView = findViewById(R.id.go_window_reg)
        goWindowReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val userLogin : EditText = findViewById(R.id.user_login_auth)
        val userPassword : EditText = findViewById(R.id.user_password_auth)

        val buttonReg : Button = findViewById(R.id.button_reg_auth)

        buttonReg.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login == "" || password == ""){
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }else{
                val db = DbHelper(this, null)
                if(db.GetUser(login, password)){
                    Toast.makeText(this, "Пользователь $login авторизирован!", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Неверный логин или пароль!", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}