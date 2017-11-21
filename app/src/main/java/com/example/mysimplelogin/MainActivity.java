package com.example.mysimplelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.submit_btn);
        final ValidateMyForm val = new ValidateMyForm();

        final EditText fn = findViewById(R.id.FirstName);
        fn.requestFocus();
        final EditText ln = findViewById(R.id.LastName);
        final EditText pwd = findViewById(R.id.password);
        final EditText ph_no = findViewById(R.id.phone_number);
        Log.d("CHANGING CODE","HELLO");

        //ADD NEW ENUM

        final View.OnFocusChangeListener listener = new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {

                Boolean bool = val.validate((EditText)view, view.getId());
                if (!bool) {
                    Log.d("CHECK VALUES","The value is:"+((EditText)view).getText());
                    ((EditText)view).setError("Please enter valid details!");
                }
            }
        };

        fn.setOnFocusChangeListener(listener);
        ln.setOnFocusChangeListener(listener);
        pwd.setOnFocusChangeListener(listener);
        ph_no.setOnFocusChangeListener(listener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("HELLO","Hello");
                Log.d("CHECKING FN","The string is : "+fn.getText().toString().isEmpty());
                Log.d("CHECKING LN"," HAI: " + ln.getText().toString().isEmpty());

                //PRINT ONLY IF ERROR FREE
                if(!fn.getText().toString().isEmpty() && !ln.getText().toString().isEmpty() && !ph_no.getText().toString().isEmpty() && !pwd.getText().toString().isEmpty())
                {
                    if(fn.getError() == null && ln.getError()== null && pwd.getError()== null && ph_no.getError()== null)
                    {
                        final String first_name = String.valueOf(fn.getText());
                        final String last_name = ln.getText().toString();
                        Toast toast;
                        toast = Toast.makeText(getApplicationContext(), "Please wait while we login", Toast.LENGTH_LONG);
                        toast.show();
                        Intent login_success = new Intent(getApplicationContext(), Welcome.class);
                        //params not sent
                        login_success.putExtra("first_name", first_name);
                        login_success.putExtra("last_name", last_name);
                        startActivity(login_success);
                        //toast = Toast.makeText(getApplicationContext(),first_name + " " +last_name, Toast.LENGTH_LONG);
                    }
                    else
                    {
                        Toast toast;
                        toast = Toast.makeText(getApplicationContext(),"PLEASE CHECK THE DETAILS ENTERED",Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                else
                {
                    Toast toast;
                    toast = Toast.makeText(getApplicationContext(),"PLEASE CHECK THE DETAILS ENTERED",Toast.LENGTH_LONG);
                    toast.show();
                }


            }
        });
    }


}