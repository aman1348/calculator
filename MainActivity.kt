package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var inputbox:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputbox=findViewById(R.id.inputbox)
    }

    var dot:Boolean=false
    var newop:Boolean=true

    var operator:String = "X"
    var oldNum:String=""

    var show:String=""

    fun getnum(view : View) {

        if (newop) {
            inputbox.text = ""
        }
        newop = false

        var gettext: String = inputbox.text.toString()

        val selectedbtn = view as Button
        when (selectedbtn.id) {
            R.id.bt0 -> {
                gettext += "0"
            }
            R.id.bt1 -> {
                gettext += "1"
            }
            R.id.bt2 -> {
                gettext += "2"
            }
            R.id.bt3 -> {
                gettext += "3"
            }
            R.id.bt4 -> {
                gettext += "4"
            }
            R.id.bt5 -> {
                gettext += "5"
            }
            R.id.bt6 -> {
                gettext += "6"
            }
            R.id.bt7 -> {
                gettext += "7"
            }
            R.id.bt8 -> {
                gettext += "8"
            }
            R.id.bt9 -> {
                gettext += "9"
            }
            R.id.btdot -> {
                if (!dot) {
                    gettext += "."
                }
                dot = true
            }
        }
//        show+=gettext
        inputbox.text =  gettext
//        inputbox.text =show
    }
    fun getOperator(view:View){
        val selectedOp = view as Button
        when(selectedOp.id){
            R.id.btplus->
            {
                operator="+"
            }
            R.id.btminus->{
                operator="-"
            }
            R.id.btmultiply->{
                operator="x"
            }
            R.id.btdivide->{
                operator="/"
            }

            R.id.btpercent->{
                operator="%"
            }
        }
//        show+=operator
        oldNum=inputbox.text.toString()
//        inputbox.text =inputbox.text.toString()+operator
        dot=false
        newop=true

    }

    fun equaloperator(view:View){
        val newNum = inputbox.text.toString()
        var result:Double?=null
        when(operator){
            "x"->{
                result=oldNum.toDouble() * newNum.toDouble()
            }
            "+"->{
                result=oldNum.toDouble() + newNum.toDouble()
            }
            "-"->{
                result=oldNum.toDouble() - newNum.toDouble()
            }
            "/"->{
                result=oldNum.toDouble() / newNum.toDouble()
            }
            "%"->{
                result=(oldNum.toDouble() * newNum.toDouble())/100
            }
        }
        inputbox.text=result.toString()
    }

    fun cleanInput(view:View){
        inputbox.text=""
        newop=true
        dot=false
    }
}
