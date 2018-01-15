package edu.rvc.student.week2app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Context
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        val btnAdd = findViewById<Button>(R.id.btnAdd)


        //button click
        btnAdd.setOnClickListener {
            // your code to perform when the user clicks on the button
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
            val n1: Int = txtNum1.text.toString().toInt()
            val n2: Int = txtNum2.text.toString().toInt()
            txtAnswer.setText(calculate(n1, n2).toString())
            txtNum1.setText("")
            txtNum2.setText("")
            txtNum1.requestFocus()
            hideKeyboard()
        }
    }

    //Math fun
    fun calculate(a: Int, b: Int): Int {
        return a + b
    }

    // function to hide keyboard
    //import android.content.Context
    //import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}
