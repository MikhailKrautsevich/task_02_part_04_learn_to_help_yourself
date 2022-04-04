package com.example.hellotoast

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mCount: Int = 0
    private var mShowCount: TextView? = null
    private var mBtnZero : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)
        mBtnZero = findViewById(R.id.button_zero)
    }

    fun countUp(view: View) {
        mCount++
        showCount()
        updateZeroBtnColor()
        updateCountBtnColor(view)
    }

    fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun changeToZero(view: View) {
        mCount = 0
        showCount()
        updateZeroBtnColor()
    }

    private fun showCount() {
        mShowCount?.text = mCount.toString()
    }

    private fun updateZeroBtnColor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mCount > 0) {
                mBtnZero?.setBackgroundColor(getColor(R.color.purple_200))
            } else mBtnZero?.setBackgroundColor(getColor(R.color.grey))
        }
    }

    private fun updateCountBtnColor(view: View){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mCount % 2 == 0) {
                view.setBackgroundColor(getColor(R.color.green))
            } else view.setBackgroundColor(getColor(R.color.blue))
        }
    }
}