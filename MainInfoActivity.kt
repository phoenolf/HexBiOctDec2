package phoenlf.application.com.hexbioctdec

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_info.*

class MainInfoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_info)

        val DecClick = findViewById<ImageView>(R.id.imageView8)
        // set on-click listener
        DecClick.setOnClickListener {
            val fragment = DecimalFragment()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.NumStore, fragment) // fragment container id in first parameter is the  container(Main layout id) of Activity
            transaction.addToBackStack(null)  // this will manage backstack
            transaction.commit()
        }



    }


    fun loadDecimalFrag()

    {



    }


}
