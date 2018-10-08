package com.design.task

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private fun Activity.showToast(message: String) = runOnUiThread { Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListeners()
    }

    private fun setupListeners() {
        simplRadioButton.isChecked = true
        simplRadioButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                upiRadioButton.isChecked = false
            }
        }

        upiRadioButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                simplRadioButton.isChecked = false
            }
        }
        buttonChangeName.setOnClickListener {
            showToast(getString(R.string.placeHolderOne))
        }
        imageClose.setOnClickListener { finish() }
        payNowButton.setOnClickListener {
            if (etBillAmount.text.toString().isEmpty()) {
                showToast(getString(R.string.placeHolderThree))
            } else {
                showToast(getString(R.string.placeHolderFour))
            }
        }
        showToast(getString(R.string.placeHolderFive))

    }
}
