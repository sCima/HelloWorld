package scima.com.github.helloworld

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val etName = findViewById<EditText>(R.id.etName)
        val tvHelloMessage = findViewById<TextView>(R.id.textViewHello)

        etName.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val name = textView.text.toString().trim()

                if (name.isNotEmpty()) {
                    tvHelloMessage.text = "Hello World, $name!"
                } else {
                    tvHelloMessage.text = "Hello World!"
                }
                true
            } else {
                false
            }
        }

        setContentView(R.layout.activity_main)
    }
}