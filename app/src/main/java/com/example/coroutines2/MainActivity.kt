package com.example.coroutines2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.coroutines2.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
     lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch {
            var string = " "
            var string2 = " "

            val job = launch {
                string = getString1()
            }

            val job2 = launch {
                string2 = getString2()
            }
            Log.i("test", string)
            Log.i("test", string2)
            job.join()
            Log.i("test", string)
            job2.join()
            Log.i("test", string2)
        }
    }

    private fun getString1(): String {
        return "Ahmed"
    }
    private fun getString2(): String {
        return "Ahmed"
    }
}
