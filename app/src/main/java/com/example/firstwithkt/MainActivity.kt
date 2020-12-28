package com.example.firstwithkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tex : TextView = findViewById(R.id.textView_progress)
        val seek: SeekBar = findViewById(R.id.seekBar)
        val button_reset: Button = findViewById(R.id.button)

        val intialTextViewTranslationY = tex.translationY

        seek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tex.text = progress.toString()

                val translationDistance = (intialTextViewTranslationY +
                        progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                tex.animate().translationY(translationDistance)
                if(!fromUser)
                tex.animate().setDuration(500).rotationBy(360f)
                    .translationY(intialTextViewTranslationY)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        button_reset.setOnClickListener { v ->
            seek.progress = 0

        }

    }
}