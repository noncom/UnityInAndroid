package com.example.unityinandroid

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.cameracapturenative.CameraPluginActivity
import com.example.unityinandroid.ui.main.MainFragment


class MainActivity : AppCompatActivity() {

    val TAG = "Embedded Unity App"

    lateinit var fragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        Log.d(TAG, "________________________________ $savedInstanceState")
        if (savedInstanceState == null) {
            fragment = MainFragment.newInstance()
            Log.d(TAG, "--------------------- fragment = $fragment, this = ${System.identityHashCode(this)}")
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 10)
        }
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "--------------------- this = ${System.identityHashCode(this)}")
        val button = fragment.view?.findViewById<Button>(R.id.buttonStartUnityApp)
        button?.setOnClickListener {
            startActivity(Intent(baseContext, CameraPluginActivity::class.java))
        }
    }
}