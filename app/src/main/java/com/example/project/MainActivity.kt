package com.example.project

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import com.example.project.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.edt.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            try {
                startActivityForResult(intent, 1)
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(this, "Error ${a.message}", Toast.LENGTH_SHORT).show()
            }


        }
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {



                if (resultCode === RESULT_OK ) {

                    val result: ArrayList<String> =
                        data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)!!


                    val text = result[0].toString().replace("x", "") + result[0].toString()
                        .filter { it == 'x' }
                    binding.textView.text = text
                    binding.textView.text = text
                }
            }
        }
        }
    }

