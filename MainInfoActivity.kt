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

        val DecClick = findViewById<ImageView>(R.id.DecInfo)
        // set on-click listener
        DecClick.setOnClickListener {
            val fragment = DecimalFragment()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.NumStore, fragment) // fragment container id in first parameter is the  container(Main layout id) of Activity
            transaction.addToBackStack(null)  // this will manage backstack
            transaction.commit()
        }
        val BinClick = findViewById<ImageView>(R.id.BinInfo)
        // set on-click listener
        BinClick.setOnClickListener {
            val fragment = BinaryFragment()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.NumStore, fragment) // fragment container id in first parameter is the  container(Main layout id) of Activity
            transaction.addToBackStack(null)  // this will manage backstack
            transaction.commit()
        }
        val HexClick = findViewById<ImageView>(R.id.HexInfo)
        // set on-click listener
        HexClick.setOnClickListener {
            val fragment = HexadecimalFragment()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.NumStore, fragment) // fragment container id in first parameter is the  container(Main layout id) of Activity
            transaction.addToBackStack(null)  // this will manage backstack
            transaction.commit()
        }
        val OctClick = findViewById<ImageView>(R.id.OctInfo)
        // set on-click listener
        OctClick.setOnClickListener {
            val fragment = OctalFragment()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.NumStore, fragment) // fragment container id in first parameter is the  container(Main layout id) of Activity
            transaction.addToBackStack(null)  // this will manage backstack
            transaction.commit()
        }

    }




}
