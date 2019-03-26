package com.hold1.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hold1.keyboardheightprovider.KeyboardHeightProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun getKeyboardListener() = object : KeyboardHeightProvider.KeyboardListener {
        override fun onHeightChanged(height: Int) {
            sizeText.text = "$height"
        }
    }

    private var keyboardHeightProvider: KeyboardHeightProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        keyboardHeightProvider = KeyboardHeightProvider(this)
//        baseView.post {
//            keyboardHeightProvider?.start()
//        }
        keyboardHeightProvider?.addKeyboardListener(getKeyboardListener())
        launchBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        keyboardHeightProvider?.onResume()
    }

    override fun onPause() {
        super.onPause()
        keyboardHeightProvider?.onPause()
    }

}
