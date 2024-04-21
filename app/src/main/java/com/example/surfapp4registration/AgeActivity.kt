package com.example.surfapp4registration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.surfapp4registration.databinding.ActivityAgeBinding

class AgeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_age)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.nextBtn.setOnClickListener {
            val editTextValue = binding.editText.text.toString().toIntOrNull()
            if (editTextValue == null) {
                Toast.makeText(this, "Введите возраст!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val resultIntent = Intent().apply {
                putExtra(Constants.AGE_KEY, editTextValue)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
        binding.prevBtn.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
        binding.cancelBtn.setOnClickListener {
            finishAffinity()
        }
    }
}