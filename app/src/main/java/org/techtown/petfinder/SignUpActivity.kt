package org.techtown.petfinder

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.techtown.petfinder.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setValues()
        setupEvents()

        auth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            createAccount(
                binding.edtNewEmail.text.toString(),
                binding.edtNewPassword.text.toString()
            )
        }
    }

    override fun setupEvents() {
    }

    private fun createAccount(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "계정 생성 완료.", Toast.LENGTH_SHORT).show()
                    finish() // 가입창 종료
                } else {
                    Toast.makeText(this, "계정 생성 실패", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun setValues() {
    }
}












