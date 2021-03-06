package phoenlf.application.com.hexbioctdec


import android.text.TextUtils
import android.text.method.DigitsKeyListener
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.Window

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent.getIntent
import android.widget.GridView
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener



import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputFilter
import android.view.KeyEvent

import android.app.Activity
import android.support.annotation.NonNull
import android.util.Log

import java.util.ArrayList
import java.util.List
import android.R.attr.inputType
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.text.InputType
import android.R.attr.password
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.*
import kotlinx.android.synthetic.main.activity_main_info.*
import java.io.Console
import java.lang.Integer.parseInt
import java.util.regex.Pattern


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var ValueInput: EditText
    lateinit var Binary: TextView
    lateinit var Decimal: TextView
    lateinit var Hexdecimal: TextView
    lateinit var Octal: TextView
    lateinit var Convert: Button
    lateinit var Bin: Button
    lateinit var Hex: Button
    lateinit var Oct: Button
    lateinit var Dec: Button


    private inline fun String.toInt(): Int = java.lang.Integer.parseInt(this)

    private inline fun Int.toUnsignedInt(): Int = this and 0xFF

    private fun hexStringToByteArray(str: String): Array<Byte> {

        val hexStr = str.replace("-", "") // remove '-'

        var result = Array<Byte>(hexStr.length / 2, { 0 })

        for (i in 0 until hexStr.length step 2) {

            var byte = Integer.valueOf(hexStr.substring(i, i + 2), 16).toByte()

            result[i / 2] = byte
        }

        return result
    }


    fun convertByteArrayToHexString() {

        val array = arrayOf<Byte>(25, 100, 20)

        println("Hexadecimal(${byteArrayToHexString(array)})")
    }

    private fun byteArrayToHexString(array: Array<Byte>): String {

        val result = StringBuilder(array.size * 2)

        for (byte in array) {

            val toAppend = String.format("%X", byte) // hexadecimal
            result.append(toAppend).append("")
        }

        return result.toString()
    }


    fun convertDecimalToOctal(decimal: Int): Int {
        var decimal = decimal
        var octalNumber = 0
        var i = 1

        while (decimal != 0) {
            octalNumber += decimal % 8 * i
            decimal /= 8
            i *= 10
        }

        return octalNumber
    }

    private fun convertOctalToDecimal(octal: Int): Int {
        var octal = octal
        var decimalNumber = 0
        var i = 0

        while (octal != 0) {
            decimalNumber += (octal % 10 * Math.pow(8.0, i.toDouble())).toInt()
            ++i
            octal /= 10
        }

        return decimalNumber
    }

    fun toDecimal(binaryNumber: String): Int {
        var sum = 0
        binaryNumber.reversed().forEachIndexed { k, v ->
            sum += v.toString().toInt() * pow(2, k)
        }
        return sum
    }

    fun toBinary(decimalNumber: Long, binaryString: String = ""): String {
        while (decimalNumber > 0) {
            val temp = "$binaryString${decimalNumber % 2}"
            return toBinary(decimalNumber / 2, temp)
        }
        return binaryString.reversed()
    }


    private fun pow(base: Int, exponent: Int) = Math.pow(base.toDouble(), exponent.toDouble()).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Binary = findViewById(R.id.Binary)
        Decimal = findViewById(R.id.Decimal)
        Hexdecimal = findViewById(R.id.Hexdecimal)
        Octal = findViewById(R.id.Octal)
        Convert = findViewById(R.id.Convert)
        ValueInput = findViewById(R.id.ValueInput)
        Bin = findViewById(R.id.Bin)
        Hex = findViewById(R.id.Hex)
        Oct = findViewById(R.id.Oct)
        Dec = findViewById(R.id.Dec)
        ValueInput.inputType = 1

        val thePattern = "[^A-Za-z0-9]+"
        val theInput = ValueInput.text.toString()
        val isFound = Pattern.compile(thePattern).matcher(theInput).find()
        println("Found: $isFound")

        Toast.makeText(applicationContext, "Please choose a numerical system", Toast.LENGTH_LONG).show()

        val AboutMeClick = findViewById(R.id.AboutMe) as ImageView
        // set on-click listener
        AboutMeClick.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            Toast.makeText(this@MainActivity, "You clicked on ImageView.", Toast.LENGTH_SHORT).show()

        }


        val NumSysClick = findViewById(R.id.NumSys) as ImageView
        // set on-click listener
        NumSysClick.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            Toast.makeText(this@MainActivity, "You clicked on ImageView.", Toast.LENGTH_SHORT).show()
            var i = Intent(this@MainActivity, MainInfoActivity::class.java)
            startActivity(i)

        }
        val myClicklistner = object : View.OnClickListener {
            override fun onClick(test: View?) {

                ValueInput.text.clear()

                println("process is at main area")




                when (test?.id) {
                    R.id.Bin -> {

                        Toast.makeText(applicationContext, "You have chosen the binary numerical system", Toast.LENGTH_SHORT).show()
                        Octal.text = null
                        Hexdecimal.text = null
                        Binary.text = null
                        Decimal.text = null

                        ValueInput = findViewById(R.id.ValueInput)

                        ValueInput.keyListener = DigitsKeyListener.getInstance("01")
                        println("process is at bin")

                        val myListener = object : View.OnClickListener {

                            override fun onClick(longtest: View?) {

                                when (longtest?.id) {

                                    R.id.Convert -> {
                                        if (TextUtils.isEmpty(ValueInput.text.toString())) {
                                            ValueInput.error = "This item cannot be empty."
                                            return
                                        }
                                        ValueInput = findViewById(R.id.ValueInput)


                                        val test = ValueInput.text


                                        println("process is at convert")
                                        Binary.text = parseInt(ValueInput.text.toString(), 2).toString()

                                        ValueInput.text.clear()

                                    }

                                }

                            }

                        }
                        Convert.setOnClickListener(myListener)

                    }
                }


                when (test?.id) { R.id.Hex -> {
                    var placeholder = ValueInput.text.toString()

                    ValueInput.inputType = 1


                    Octal.text = null
                    Hexdecimal.text = null
                    Binary.text = null
                    Decimal.text = null





                    Toast.makeText(applicationContext, "You have chosen the hexdecimal numerical system", Toast.LENGTH_SHORT).show()


                    val myListener = object : View.OnClickListener {

                        override fun onClick(longtest: View?) {

                            when (longtest?.id) {

                                R.id.Convert -> {
//
//


                                    val thePattern = "[^A-Fa-f0-9]+"
                                    val theInput = ValueInput.text.toString()
                                    val isFound = Pattern.compile(thePattern).matcher(theInput).find()
                                    println("Found: $isFound")


                                    val view1 = ValueInput.text.toString()

                                    if (isFound == true) {

                                        ValueInput.error = "This item cannot be empty"

                                        return

                                    } else if (ValueInput.text.isNullOrEmpty()) {
                                        ValueInput.error = "This item cannot be empty"


                                    } else {
                                        ValueInput = findViewById(R.id.ValueInput)





                                        Hexdecimal.text = parseInt(ValueInput.text.toString(), 16).toString()



                                        ValueInput.text.clear()

                                        println("process is at convert")
                                    }
                                }

                            }

                        }

                    }
                    Convert.setOnClickListener(myListener)
                }
                }
                when (test?.id) {



                    R.id.Oct -> {

                        Toast.makeText(applicationContext, "You have chosen the octal numerical system", Toast.LENGTH_SHORT).show()

                        ValueInput.keyListener = DigitsKeyListener.getInstance("01234567")

                        Octal.text = null
                        Hexdecimal.text = null
                        Binary.text = null
                        Decimal.text = null


                        val myListener = object : View.OnClickListener {

                            override fun onClick(longtest: View?) {

                                when (longtest?.id) {

                                    R.id.Convert -> {
                                        if (TextUtils.isEmpty(ValueInput.text.toString())) {
                                            ValueInput.error = "This item cannot be empty."
                                            return
                                        } else {

                                            ValueInput = findViewById(R.id.ValueInput)



                                            Octal.text = parseInt(ValueInput.text.toString(), 8).toString()

                                            Decimal.text = parseInt(ValueInput.text.toString(), 10).toString()

                                            val OctDec = Octal.text.toString().toInt()

                                            Binary.text = Integer.toBinaryString(OctDec)


                                            Hexdecimal.text = Integer.toHexString(OctDec)


                                            println("process is at convert")
                                            ValueInput.text.clear()


                                        }
                                    }

                                }

                            }

                        }
                        Convert.setOnClickListener(myListener)


                    }


                    R.id.Dec -> {

                        Toast.makeText(applicationContext, "You have chosen the decimal numerical system", Toast.LENGTH_SHORT).show()

                        ValueInput.keyListener = DigitsKeyListener.getInstance("0123456789")

                        Octal.text = null
                        Hexdecimal.text = null
                        Binary.text = null
                        Decimal.text = null


                        val myListener = View.OnClickListener { longtest ->
                            when (longtest?.id) {

                                R.id.Convert -> {
                                    if (TextUtils.isEmpty(ValueInput.text.toString())) {
                                        ValueInput.error = "This item cannot be empty."
                                        return@OnClickListener
                                    } else {

                                        ValueInput = findViewById(R.id.ValueInput)


                                        //                 var int: Long = "$test".toLong()


                                        //       var Norint: Int = int.toInt()

                                        //              Octal.text = convertOctalToDecimal(Norint).toString()
                                        Decimal.text = parseInt(ValueInput.text.toString(), 10).toString()

                                        val BinDec = Decimal.text.toString().toInt()
                                        Octal.text = Integer.toOctalString(BinDec)

                                        Binary.text = Integer.toBinaryString(BinDec)


                                        Hexdecimal.text = Integer.toHexString(BinDec)

                                        println("process is at convert")
                                        ValueInput.text.clear()


                                    }
                                }

                            }
                        }
                        Convert.setOnClickListener(myListener)


                    }


                }

            }

        }
        Bin.setOnClickListener(myClicklistner)
        Dec.setOnClickListener(myClicklistner)
        Hex.setOnClickListener(myClicklistner)
        Oct.setOnClickListener(myClicklistner)
        Convert.setOnClickListener(myClicklistner)

    }

    override fun onClick(v: View?) {
        //       ValueInput = findViewById(R.id.ValueInput)
        //        Decimal.text = ValueInput.text
        val test = ValueInput.text


        var bit: Byte = "$test".toByte()
        var int: Long = "$test".toLong()

        var Norint: Int = int.toInt()
        Octal.text = convertOctalToDecimal(Norint).toString()

        val decimall = "$test".toInt()

        val octall = convertDecimalToOctal(decimall)

        Decimal.text = toDecimal("$test").toString()

        //      Binary.text = toBinary(int)    // max value 128 and doesnt show negative values


        val array = arrayOf<Byte>(bit)



        Hexdecimal.text = byteArrayToHexString(array)

    }

}

/*
Here are a number of extensions I have written. Hopefully one of them will be useful to you. You should set input type in the XML as well to show proper keyboard if you use numeric only input.

// Limit edit text to numbers only
fun EditText.limitNumberOnly() {
    val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
        val builder = StringBuilder(dest)
        builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
        if (!builder.toString().matches(("^[0-9]*$").toRegex())) {
            return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
        }
        null
    }
    filters = arrayOf(filter)
}

// Limit edit text to numbers only
fun EditText.limitNumberAndLength(maxLength: Int) {
    val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
        val builder = StringBuilder(dest)
        builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
        if (!builder.toString().matches(("^[0-9]*$").toRegex())) {
            return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
        }
        null
    }
    filters = arrayOf(filter, InputFilter.LengthFilter(maxLength))
}

// Limit an EditText to only accept ASCII characters (no funky or emoji)
fun EditText.limitAscii() {
    val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
        val builder = StringBuilder(dest)
        builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
        if (!builder.toString().matches(("^[\\x20-\\x7F]*$").toRegex())) {
            return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
        }
        null
    }
    filters = arrayOf(filter)
}

// Limit length of an EditText
fun EditText.limitLength(maxLength: Int) {
    filters = arrayOf(InputFilter.LengthFilter(maxLength))
}

// Limit to ASCII and a certain length, need two filters here
fun EditText.limitAsciiAndLength(maxLength: Int) {
    val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
        val builder = StringBuilder(dest)
        builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
        if (!builder.toString().matches(("^[\\x20-\\x7F]*$").toRegex())) {
            return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
        }
        null
    }
    filters = arrayOf(filter, InputFilter.LengthFilter(maxLength))
}




input.toLong(2).toStr(10)


 // Limit an EditText to only accept up to X characters before decimal and Y characters after decimal
    fun EditText.limitDecimalPlaces(maxDigitsAfterDecimalPoint: Int = 2, maxDigitsBeforeDecimalPoint: Int = 6) {
        val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
            val builder = StringBuilder(dest)
            builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
            val decSep = DecimalFormatSymbols.getInstance().decimalSeparator
            val matcher = "(([1-9]{1})([0-9]{0,${maxDigitsBeforeDecimalPoint - 1}})?)?(\\$decSep[0-9]{0,$maxDigitsAfterDecimalPoint})?"
            if (!builder.toString().matches((matcher).toRegex())) {
                return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
            }
            null
        }
        filters = arrayOf(filter)
    }

    // Limit edit text to numbers only
    fun EditText.limitNumberOnly() {
        val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
            val builder = StringBuilder(dest)
            builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
            if (!builder.toString().matches(("^[0-9]*$").toRegex())) {
                return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
            }
            null
        }
        filters = arrayOf(filter)
    }

    // Limit edit text to numbers only
    fun EditText.limitNumberAndLength(maxLength: Int) {
        val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
            val builder = StringBuilder(dest)
            builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
            if (!builder.toString().matches(("^[0-9]*$").toRegex())) {
                return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
            }
            null
        }
        filters = arrayOf(filter, InputFilter.LengthFilter(maxLength))
    }

    // Limit an EditText to only accept ASCII characters (no funky or emoji)
    fun EditText.limitAscii() {
        val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
            val builder = StringBuilder(dest)
            builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
            if (!builder.toString().matches(("^[\\x20-\\x7F]*$").toRegex())) {
                return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
            }
            null
        }
        filters = arrayOf(filter)
    }

    // Limit length of an EditText
    //fun EditText.limitLength(maxLength: Int) {
    //    filters = arrayOf(InputFilter.LengthFilter(maxLength))
    //}

    // Limit to ASCII and a certain length, need two filters here
    fun EditText.limitAsciiAndLength(maxLength: Int) {
        val filter = InputFilter { source, start, end, dest, destStart, destEnd ->
            val builder = StringBuilder(dest)
            builder.replace(destStart, destEnd, source.subSequence(start, end).toString())
            if (!builder.toString().matches(("^[\\x20-\\x7F]*$").toRegex())) {
                return@InputFilter if (source.isEmpty()) dest.subSequence(destStart, destEnd) else ""
            }
            null
        }
        filters = arrayOf(filter, InputFilter.LengthFilter(maxLength))
    }

 */