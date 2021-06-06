package com.nusrahfarri.calculatoroo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        private var isNewOp = true
        var dot = false

    //First, this function, buttonDisplayEvent allows clicked numbers, dot and plus/minus buttons to display on screen.

    fun buttonDisplayEvent (view: View){
        if (isNewOp) {
            displayScreen.setText("")
        }

        isNewOp=false
        val buttonSelect= view as Button
        var buttonClickValue =displayScreen.text.toString()

        when(buttonSelect.id)
        {
            button0.id->
            {
                buttonClickValue+="0"
            }
            button1.id->
            {
                buttonClickValue+="1"
            }
            button2.id->
            {
                buttonClickValue+="2"
            }
            button3.id->
            {
                buttonClickValue+="3"
            }
            button4.id->
            {
                buttonClickValue+="4"
            }
            button5.id->
            {
                buttonClickValue+="5"
            }
            button6.id->
            {
                buttonClickValue+="6"
            }
            button7.id->
            {
                buttonClickValue+="7"
            }
            button8.id->
            {
                buttonClickValue+="8"
            }
            button9.id->
            {
                buttonClickValue+="9"
            }

            // This allows the dot to not appear more than once when clicked on multiple times
            buttonDot.id->
            {
                if(dot==false)
                {
                    buttonClickValue += "."
                }
                dot=true
            }
            buttonPlusMinus.id->
            {
                buttonClickValue="-" + buttonClickValue
            }
        }

        displayScreen.setText(buttonClickValue)
    }
        //End of function buttonDisplayEvent


    // Second, function buttonOperationEvent makes operations +,-,÷,x do their jobs

     var operation = "x"
     var oldNumber=""

    fun buttonOperationEvent(view: View)
    {
        val buttonSelect= view as Button
        when(buttonSelect.id)
        {
            buttonMultiplication.id->
            {
                operation="x"
            }
            buttonDivision.id->
            {
                operation="÷"
            }
            buttonSubtraction.id->
            {
                operation="-"
            }
            buttonAddition.id->
            {
                operation="+"
            }
        }
        oldNumber=displayScreen.text.toString()
        isNewOp=true
        dot=false
    }

    //Third, buttonEqualEvent function displays the outcome of the operation

    fun buttonEqualEvent(view: View)
    {
        val newNumber=displayScreen.text.toString()
        var finalNumber:Double?=null
        when(operation)
        {
            "x"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "÷"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        displayScreen.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buttonPercentageEvent(view: View)
    {
        val number=(displayScreen.text.toString().toDouble())/100
        displayScreen.setText(number.toString())
        isNewOp=true
    }

    fun buttonClearEvent(view: View)
    {
        displayScreen.setText("")
        isNewOp=true
        dot=false
    }

    //Display what is typed

   fun showTyped(view: View){
       

   }
}
