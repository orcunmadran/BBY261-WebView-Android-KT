package net.madran.kotlinwebview

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AlertDialog
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isNetworkConnected()) {

            loadWebpage()

        } else {
            AlertDialog.Builder(this).setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again")
                    .setPositiveButton(android.R.string.ok) { dialog, which -> }
                    .setIcon(android.R.drawable.ic_dialog_alert).show()
        }

    }

    fun loadWebpage() {

        // Enable javascript
        webview.settings.javaScriptEnabled = true

        webview.loadUrl("http://www.madran.net/examples/webmobil/")

    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager// 1
        val networkInfo = connectivityManager.activeNetworkInfo // 2
        return networkInfo != null && networkInfo.isConnected // 3
    }

}