package com.hold1.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hold1.keyboardheightprovider.KeyboardHeightProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), KeyboardHeightProvider.KeyboardListener {
    override fun onHeightChanged(height: Int) {
        sizeText.text = "$height px"
    }

    private var keyboardHeightProvider: KeyboardHeightProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        keyboardHeightProvider = KeyboardHeightProvider(this)
        baseView.post {
            keyboardHeightProvider?.start()
        }
    }


    /**
     * {@inheritDoc}
     */
    public override fun onPause() {
        super.onPause()
        keyboardHeightProvider?.removeKeyboardListener(this)
    }

    /**
     * {@inheritDoc}
     */
    public override fun onResume() {
        super.onResume()
        keyboardHeightProvider?.addKeyboardListener(this)
    }

    /**
     * {@inheritDoc}
     */
    public override fun onDestroy() {
        super.onDestroy()
        keyboardHeightProvider!!.close()
    }

}
