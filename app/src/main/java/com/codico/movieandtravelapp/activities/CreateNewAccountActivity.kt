package com.codico.movieandtravelapp.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.codico.movieandtravelapp.R
import kotlinx.android.synthetic.main.activity_create_new_account.*
import java.util.*
import java.util.regex.Pattern

class CreateNewAccountActivity : AppCompatActivity() {
    var selectedYear=0
    val calendar= Calendar.getInstance()
    val current_year=calendar.get(Calendar.YEAR)
    var flagFirst=true
    var flagEmail=true
    var flagAge=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_account)


        setUpActionListener()
    }

    private fun setUpActionListener(){
        //spinner of country code
        spinnerCountryCode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (parent?.getChildAt(0) as TextView).setTextColor(
                    resources.getColor(
                        R.color.colorSecondaryText,
                        theme
                    )
                )

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        //date
        ivDateOfBirth.setOnClickListener {

            val day=calendar.get(Calendar.DAY_OF_MONTH)
            val month=calendar.get(Calendar.MONTH)

            val datePickerDialog= DatePickerDialog(this,
                object:DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
                        selectedYear=year
                        edtDateOfBirth.setText("$day/${month+1}/$year")

                    }


                },current_year,month,day
            )
            datePickerDialog.show()
        }

        //gender
        tvFemale.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_select_gender)
            tvMale.setBackgroundResource(R.drawable.bg_unselect_gender)
        }

        tvMale.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_select_gender)
            tvFemale.setBackgroundResource(R.drawable.bg_unselect_gender)
        }


        //check validation
        btnCreateNewAcctount.setOnClickListener {
            checkValidity()
            //check to go next
            if(flagAge && flagEmail && flagFirst){
                startActivity(Intent(this,MovieListActivity::class.java))
            }
        }

        //go to previous
        ivPrevious.setOnClickListener {
            finish()
        }
    }

    private fun checkValidity() {
        //check first name
        var firstName = edtFirstName.text?.trim().toString()
        if (!firstName.isNullOrEmpty()) {
            if (!isValidName(firstName)) {
                flagFirst = false
                edtFirstName.error = "Name should be char "
            }else{
                flagFirst = true
            }

        } else {
            flagFirst = false
            edtFirstName.error = "Please enter first Name "
        }

        //check email
        var email = edtEmailAddress.text?.trim().toString()
        if (!email.isNullOrEmpty()) {
            if (!isValidEmail(email)) {
                flagEmail = false
                edtEmailAddress.error = "Please enter valid email"
            }else{
                flagEmail = true
            }
        } else {
            flagEmail = false
            edtEmailAddress.error = "Please enter email address "
        }

        //date check
        var dob=edtDateOfBirth.text?.trim().toString()
        if(!dob.isNullOrEmpty() && dob!="DD/MM/YYYY"){
            var age = current_year.minus(selectedYear)
            if (age < 10) {
                flagAge = false
                edtDateOfBirth.error = "You must not be under 10"
            }else{
                flagAge = true
            }
        }else{
            flagAge = false
            edtDateOfBirth.error = "Please enter dob"
        }

    }


    fun isValidEmail(str: String): Boolean{
        val emailAddressRegrex = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        return emailAddressRegrex.matcher(str).matches()
    }

    fun isValidName(str:String):Boolean{
        val userNameRegrex=Pattern.compile("^[a-zA-Z ]+$")
        return userNameRegrex.matcher(str).matches()
    }

}