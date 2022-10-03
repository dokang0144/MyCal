# MyCal
코틀린으로 만든 간단한 사칙연산+(나누기) 계산기 앱입니다.<br>
![image](https://user-images.githubusercontent.com/88234731/192284497-c2ccca9d-be16-4342-83f4-9eda463dba9e.png)<br><br>
잘못된 숫자를 입력했을때 토스트로 메세지가 뜹니다.<br>
![Screenshot_20221003_215058](https://user-images.githubusercontent.com/88234731/193581202-298b80c3-02c0-424d-8f28-35e65a2cdcb9.png)<br><br>
## 소스코드
### MainActivity.kt
```
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
```
### activity_main.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center_horizontal"
    tools:context=".MainActivity">

    <EditText
        android:layout_marginTop="70dp"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:hint="첫번째 숫자를 입력하세요"
        android:id="@+id/et_number_1"/>
    <EditText
        android:layout_marginTop="30dp"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:hint="두번째 숫자를 입력하세요"
        android:id="@+id/et_number_2"/>
    <LinearLayout
        android:layout_marginTop="50dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <Button
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:id="@+id/btn_plus"
            android:text="+"/>
        <Button
            android:layout_marginStart="20dp"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:id="@+id/btn_minus"
            android:text="-"/>
        <Button
            android:layout_marginStart="20dp"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:id="@+id/btn_multi"
            android:text="x"/>
        <Button
            android:layout_marginStart="20dp"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:id="@+id/btn_divide"
            android:text="/"/>
        <Button
            android:layout_marginStart="20dp"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:id="@+id/btn_rest"
            android:text="%"/>
    </LinearLayout>

    <TextView
        android:layout_marginTop="50dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="결과"
        android:id="@+id/tv_result"
        android:textSize="30sp"/>

    <Button
        android:layout_marginTop="70dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="초기화"
        android:id="@+id/btn_init"/>
</LinearLayout>
```
