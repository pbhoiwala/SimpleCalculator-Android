package com.actualcalc.mycalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String total = "";
    String expression = "";
    double v1, v2;
    String sign = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v){
        Button button = (Button)v;
        String str = button.getText().toString();
        total += str;
        EditText edit = (EditText)findViewById(R.id.editText);
        edit.setText(total);

        expression += str;
        EditText edit2 = (EditText)findViewById(R.id.editText2);
        edit2.setText(expression);
    }

    public void OnAdd(View v){
        v1 = Double.parseDouble(total);
        expression = total;
        total = "";
        Button button = (Button)v;
        String str = button.getText().toString();
        sign = str;
        expression += sign;
        EditText edit = (EditText)findViewById(R.id.editText);
        EditText edit2 = (EditText)findViewById(R.id.editText2);
        edit.setText("");
        edit2.setText(expression);

    }

    public void onCalculate(View v){
        EditText edit = (EditText)findViewById(R.id.editText);
        EditText edit2 = (EditText)findViewById(R.id.editText2);

        String str2 = edit.getText().toString();
        v2 = Double.parseDouble(str2);
        double grand_total = 0;
        if (sign.equals("+")){
            grand_total = v1+v2;
        }
        else if (sign.equals("-")){
            grand_total = v1-v2;
        }
        else if (sign.equals("*")){
            grand_total = v1*v2;
        }
        else if (sign.equals("/")){
            grand_total = v1/v2;
        }
        edit.setText(grand_total + "");
        //edit2.setText(expression + " = " + grand_total + "");
        total = grand_total + "";
        expression = grand_total + "";

    }

    public void onClear(View v){

        EditText edit = (EditText)findViewById(R.id.editText);
        EditText edit2 = (EditText)findViewById(R.id.editText2);
        edit.setText("");
        edit2.setText("");
        total= "";
        expression = "";

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
