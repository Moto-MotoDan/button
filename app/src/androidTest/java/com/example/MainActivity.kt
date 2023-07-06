package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btTest = findViewById<Button>(R.id.btTest)
        btTest.setOnClickListener(btClickListener())
        var swTest = findViewById<Switch>(R.id.swTest)
        swTest.setOnClickListener(swClickListener())
        var cbTest = findViewById<CheckBox>(R.id.cbTest)
        cbTest.setOnClickListener(cbClickListener())
        var rbTest1 = findViewById<RadioButton>(R.id.rbTest1)
        rbTest1.setOnClickListener(rbClickListener())
        var rbTest2 = findViewById<RadioButton>(R.id.rbTest2)
        rbTest2.setOnClickListener(rbClickListener())
        var tbTest = findViewById<ToggleButton>(R.id.tbTest)
        tbTest.setOnClickListener(tbClickListener())
        var lvTest = findViewById<ListView>(R.id.lvTest)
        lvTest.setOnItemClickListener(lvClickListener())
    }

    private inner class swClickListener : View.OnClickListener{
        override fun onClick(view: View) {
            var tvTest = findViewById<TextView>(R.id.tvTest)
            var swTest = view as Switch
            if(swTest.isChecked) {
                tvTest.setText("スイッチはオン")
            }else {
                tvTest.setText("スイッチはオフ")
            }
        }

    }
    private inner class cbClickListener : View.OnClickListener{
        override fun onClick(view: View) {
            var tvTest = findViewById<TextView>(R.id.tvTest)
            var cbTest = view as CheckBox
            if(cbTest.isChecked) {
                tvTest.setText("チェックボックスはオン")
            }else {
                tvTest.setText("チェックボックスはオフ")
            }
        }

    }
    private inner class tbClickListener : View.OnClickListener{
        override fun onClick(view: View) {
            var tvTest = findViewById<TextView>(R.id.tvTest)
            var tbTest = view as ToggleButton
            if(tbTest.isChecked) {
                tvTest.setText("トグルボタンはオン")
            }else {
                tvTest.setText("トグルボタンはオフ")
            }
        }

    }
    private inner class rbClickListener : View.OnClickListener{
        override fun onClick(view: View) {
            var tvTest = findViewById<TextView>(R.id.tvTest)
            var rbTest = view as RadioButton
            when(view.id){
                R.id.rbTest1 -> {
                    tvTest.setText("1年")
                }
                R.id.rbTest2 -> {
                    tvTest.setText("2年")
                }
            }
        }

    }
    private inner class lvClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
            var tvTest = findViewById<TextView>(R.id.tvTest)
            var tvItem = view as TextView
            tvTest.setText(tvItem.text.toString()+"を選択")
// when(pos){
// 0 -> {
// tvTest.setText("IoT")
// }
// 1 -> {
// tvTest.setText("AI")
// }
// 2 -> {
// tvTest.setText("Robot")
// }
// }
        }
    }
    private inner class btClickListener : View.OnClickListener{
        override fun onClick(view: View) {
            var tvTest = findViewById<TextView>(R.id.tvTest)
            var text=""
            var swTest = findViewById<Switch>(R.id.swTest)
            var etText = findViewById<EditText>(R.id.etText)
            var etNum = findViewById<EditText>(R.id.etNumber)
            var cbTest = findViewById<CheckBox>(R.id.cbTest)
            var rbTest1 = findViewById<RadioButton>(R.id.rbTest1)
            var rbTest2 = findViewById<RadioButton>(R.id.rbTest2)
            var tbTest = findViewById<ToggleButton>(R.id.tbTest)
            if(swTest.isChecked){
                text=text+"sw ON "
            }else {
                text=text+"sw OFF "
            }
            text=text+"¥""+etText.text.toString()+"¥" "
            text=text+"["+etNum.text.toString()+"] "
            if(cbTest.isChecked){
                text=text+"cb ON "
            }else {
                text=text+"cb OFF "
            }
            if(rbTest1.isChecked){
                text=text+"1年 "
            }
            if(rbTest2.isChecked){
                text=text+"2年 "
            }
            if(tbTest.isChecked){
                text=text+"tb ON "
            }else {
                text=text+"tb OFF "
            }
            tvTest.setText(text)
        }
    }
}

private fun Button.setOnClickListener(btClickListener: MainActivity.btClickListener) {
    override fun onClick(view: View) {
        var tvTest = findViewById<TextView>(R.id.tvTest)
        var lvTest = findViewById<ListView>(R.id.lvTest)
        var rbTest = view as RadioButton
        when(view.id){
            R.id.rbTest1 -> {
                tvTest.setText("1年")
                var listarray = resources.getStringArray(R.array.lvTest1)
                lvTest.adapter = ArrayAdapter(applicationContext,
                    android.R.layout.simple_list_item_activated_1,
                    listarray)
            }
            R.id.rbTest2 -> {
                tvTest.setText("2年")
                var listarray = resources.getStringArray(R.array.lvTest)
                lvTest.adapter = ArrayAdapter(applicationContext,
                    android.R.layout.simple_list_item_activated_1,
                    listarray)
            }
        }
    }
}

}
