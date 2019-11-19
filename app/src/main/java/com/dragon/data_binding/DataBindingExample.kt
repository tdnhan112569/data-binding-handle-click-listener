package com.dragon.data_binding

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.dragon.data_binding.databinding.ActivityDataBindingExampleBinding

class DataBindingExample : AppCompatActivity() {

    private lateinit var binding : ActivityDataBindingExampleBinding
    private lateinit var eventHandler: EventHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ///setContentView(R.layout.activity_data_binding_example)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_example)
        eventHandler = EventHandler(this)

        binding.student = generateStudent()
        binding.handler = eventHandler
    }

    private fun generateStudent() : Student {
        return Student("Nhân", "trandainhan151296@gmail.com")
    }

    inner class EventHandler {
        lateinit var context : Context
        constructor(context: Context) {
            this.context = context
        }

        fun onPressEnrollButton(view : View) {
            Toast.makeText(context, "Enroll Pressed", Toast.LENGTH_SHORT).show()
        }

        fun onPressCancelButton(view : View) {
            Toast.makeText(context, "Cancel Pressed", Toast.LENGTH_SHORT).show()
        }
    }

    @BindingAdapter("app:text")
    fun setText(view: EditText, string: String) {
        view.setTextColor(if(string.length >5) {
            Color.RED
        } else if(view.text.toString().length > 10) {
            Color.BLUE
        } else Color.GREEN)
    }


}
