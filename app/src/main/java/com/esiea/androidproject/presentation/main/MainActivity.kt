package com.esiea.androidproject.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.esiea.androidproject.R
import com.esiea.androidproject.presentation.menu.MenuActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    val mainViewModel : MainViewModel by inject()

    fun isValidEmail(str: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Login"

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> startActivity(Intent(this@MainActivity,
                    MenuActivity::class.java))
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Account not found or incorrect credentials")
                        .setPositiveButton("Ok") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        mainViewModel.verifLiveData.observe(this, Observer {
            when(it){
                is VerifSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Account already exists")
                        .setPositiveButton("Ok") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
                VerifError -> {
                    mainViewModel.createdAccount(login_edit.text.toString().trim(), password_edit.text.toString(), this)
                    Toast.makeText(this@MainActivity, "Account created", Toast.LENGTH_LONG).show()
                }
            }
        })

        login_edit.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                var validEmail = isValidEmail(login_edit.text.toString())
                if (validEmail){
                    password_edit.addTextChangedListener(object : TextWatcher{
                        override fun afterTextChanged(s: Editable?) {
                        }

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        }

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                            login_button.isEnabled=true
                            create_account_button.isEnabled=true
                        }

                    })
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }
        create_account_button.setOnClickListener {
            mainViewModel.onClickedCreateAccount(login_edit.text.toString().trim(), password_edit.text.toString())
        }
    }
}
