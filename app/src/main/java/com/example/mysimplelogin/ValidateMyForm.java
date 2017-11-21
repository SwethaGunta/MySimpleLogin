package com.example.mysimplelogin;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateMyForm {
    Boolean bool = false;

    public boolean validate(EditText edt,int id)
    {
        switch(id)
        {
            case R.id.FirstName:
                bool = Pattern.compile(Regexes.NAME.getvalue()).matcher(edt.getText().toString()).matches();
                break;
            case R.id.LastName:
                bool = Pattern.compile(Regexes.NAME.getvalue()).matcher(edt.getText().toString()).matches();
                break;
            case R.id.password:
                bool = Pattern.compile(Regexes.PASSWORD.getvalue()).matcher(edt.getText().toString()).matches();
                break;
            case R.id.phone_number:
                bool = Pattern.compile(Regexes.PHONE.getvalue()).matcher(edt.getText().toString()).matches();
                break;
        }
        return bool;

    }
}
