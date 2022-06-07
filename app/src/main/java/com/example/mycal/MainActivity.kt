package com.example.mycal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // by lazy 초기화 연기를 사용해서
    // XML 코드 선언 및 초기화를 하는 부분입니다.
    private val et_number_1: EditText by lazy {
        findViewById(R.id.et_number_1)
    }
    private val et_number_2: EditText by lazy {
        findViewById(R.id.et_number_2)
    }
    private val btn_plus: Button by lazy {
        findViewById(R.id.btn_plus)
    }
    private val btn_minus: Button by lazy {
        findViewById(R.id.btn_minus)
    }
    private val btn_multi: Button by lazy {
        findViewById(R.id.btn_multi)
    }
    private val btn_divide: Button by lazy {
        findViewById(R.id.btn_divide)
    }
    private val btn_rest: Button by lazy {
        findViewById(R.id.btn_rest)
    }
    private val tv_result: TextView by lazy {
        findViewById(R.id.tv_result)
    }
    private val btn_init: Button by lazy {
        findViewById(R.id.btn_init)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_plus.setOnClickListener{
            //이벤트 핸들러를 구현하는 부분입니다
            //입력한 글자 String 으로 가져와서
            //Int 로 바꾸는 방법입니다.
            setResultView(1)
        }
        btn_minus.setOnClickListener{
            setResultView(2)
        }
        btn_multi.setOnClickListener{
            setResultView(3)
        }
        btn_divide.setOnClickListener{
            setResultView(4)
        }
        btn_rest.setOnClickListener{
            val num1 = et_number_1.text.toString().toInt()
            val num2 = et_number_2.text.toString().toInt()
            val numResult : Int = num1 % num2
            tv_result.text = numResult.toString()
        }
        btn_init.setOnClickListener{
            et_number_1.setText("") // 입력 뷰 초기화
            et_number_2.setText("")
            tv_result.text = "" // 결과 뷰 초기화
        }
    }

    private fun setResultView(o: Int){
        try{
            val num1 = et_number_1.text.toString().toInt()
            val num2 = et_number_2.text.toString().toInt()
            var numResult: Int = -1
            when(o) {
                1 -> numResult = num1 + num2
                2 -> numResult = num1 - num2
                3 -> numResult = num1 * num2
                4 -> numResult = num1 / num2
                5 -> numResult = num1 % num2
            }
            tv_result.text = numResult.toString()
        } catch (e: Exception) {
            Toast.makeText(
                this, "숫자 입력 오류!!", Toast.LENGTH_SHORT
            ).show()
        }
    }
}