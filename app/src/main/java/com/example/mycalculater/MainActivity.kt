package com.example.mycalculater
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.objecthunter.exp4j.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //number
        tvOne.setOnClickListener{ appendOnExpresstion("1" , true)}
        tvTwo.setOnClickListener { appendOnExpresstion(  "2",true ) }
        tvThree.setOnClickListener { appendOnExpresstion (  "3", true) }
        tvFour.setOnClickListener { appendOnExpresstion("4", true) }
        tvFive.setOnClickListener{ appendOnExpresstion ( "5", true) }
        tvSix.setOnClickListener{ appendOnExpresstion("6", true) }
        tvSeven.setOnClickListener{ appendOnExpresstion( "7", true) }
        tvEight.setOnClickListener{ appendOnExpresstion("8",true) }
        tvNine.setOnClickListener{ appendOnExpresstion("9", true) }
        tvZero.setOnClickListener { appendOnExpresstion("0", true) }
        tvDot.setOnClickListener { appendOnExpresstion(".", true)}

        //operators
        tvPlus.setOnClickListener{appendOnExpresstion("+",false)}
        tvMinus.setOnClickListener{appendOnExpresstion("-",false)}
        tvDivide.setOnClickListener{appendOnExpresstion("/",false)}
        tvMultiply.setOnClickListener{appendOnExpresstion("*",false)}
        tvOpenP.setOnClickListener{appendOnExpresstion("(",false)}
        tvCloseP.setOnClickListener{appendOnExpresstion(")",false)}


        tvEqual.setOnClickListener{
            try {
                val expression  = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()
                if(result == longresult.toDouble()){
                    tvResult.text =longresult.toString()
                }
                else {
                    tvResult.text =result.toString()
                }
            }catch(e:Exception){
                Log.d( "Exception","message : " + e.message )

            }

        }

        tvClear.setOnClickListener{
            tvResult.text =""
            tvExpression.text =""
        }
        tvBack.setOnClickListener{
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text =""
        }


    }

    private fun appendOnExpresstion (string: String, canClear : Boolean) {
        if (canClear){
            tvResult.text =""
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text =""
        }
    }
}