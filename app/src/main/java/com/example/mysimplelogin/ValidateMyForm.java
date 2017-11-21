package com.example.mysimplelogin;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateMyForm {
    Boolean bool = false;
    //String regex_for_name = "^[A-Za-z]+$";
    //String regex_for_pwd = "^[A-Za-z0-9!@#$%^&*.()_`/~/-/+={}]{8,15}+$";

    public boolean validate(EditText edt,int id)
    {
        Log.d("InValidateMyForm","The value received is:"+edt.getText().toString());
        Log.d("ID", "ID:"+ id);
        switch(id)
        {
            case R.id.FirstName:
                bool = Pattern.compile(Regexes.NAME.getvalue()).matcher(edt.getText().toString()).matches();
                //  Log.d("FIRST CASE","BOOL"+ bool);
                //Log.d("FIRST CASE","ID IS"+ R.id.FirstName);
                break;
            case R.id.LastName:
                bool = Pattern.compile(Regexes.NAME.getvalue()).matcher(edt.getText().toString()).matches();
                //Log.d("SECOND CASE","BOOL"+ bool);
                // Log.d("SECOND CASE","ID IS"+ R.id.LastName);
                break;
            case R.id.password:
                bool = Pattern.compile(Regexes.PASSWORD.getvalue()).matcher(edt.getText().toString()).matches();
                //Log.d("THIRD CASE","BOOL"+ bool);
                //Log.d("THIRD CASE","ID IS"+R.id.password);
                break;
            case R.id.phone_number:
                bool = Pattern.compile(Regexes.PHONE.getvalue()).matcher(edt.getText().toString()).matches();
                break;
        }
        //Log.d("Checking BOOL","BOOL IS:" + bool);
        return bool;

    }
}
