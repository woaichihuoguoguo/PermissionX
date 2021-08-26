package com.permissionx.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.permissionx.guomenglongdev.PermissionX
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var makeCallBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        makeCallBtn.setOnClickListener {
            PermissionX.request(this,
                    android.Manifest.permission.CALL_PHONE){ allGranted,deniedList->
                if (allGranted){
                    call()
                }else{
                    Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun init() {
        makeCallBtn=findViewById(R.id.makeCallBtn)
    }
    private fun call(){
        try {
            val intent=Intent(Intent.ACTION_CALL)
            intent.data= Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}