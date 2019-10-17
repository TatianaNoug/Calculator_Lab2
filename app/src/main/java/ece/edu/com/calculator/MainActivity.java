package ece.edu.com.calculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView operationText;
    TextView resultText;
    Button buttonEquals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);


        Button minus = findViewById(R.id.buttonMinus);
        minus.setOnClickListener(this);
        Button plus = findViewById(R.id.buttonPlus);
        plus.setOnClickListener(this);
        Button times = findViewById(R.id.buttonTimes);
        times.setOnClickListener(this);
        Button divide = findViewById(R.id.buttonDivide);
        divide.setOnClickListener(this);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(this);

        operationText =  findViewById(R.id.operation);
        resultText =  findViewById(R.id.result);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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


    @Override
    public void onClick(View view) {

        buttonEquals.setVisibility(View.VISIBLE);
        String finalResult = (String) resultText.getText();
        if(!finalResult.equals(null)){
            if(finalResult.length()>0){
                resultText.setText("");
                operationText.setText("");
            }
        }

        int operator1 = 0;
        int operator2 = 0;
        double res = 0;

        String operation = "";
        String text = (String) operationText.getText();

        switch (view.getId()){
            case R.id.button0:
                text = text +"0";
                operationText.setText(text);
                break;
            case R.id.button1:
                text = text +"1";
                operationText.setText(text);
                break;
            case R.id.button2:
                text = text +"2";
                operationText.setText(text);
                break;
            case R.id.button3:
                text = text +"3";
                operationText.setText(text);
                break;
            case R.id.button4:
                text = text +"4";
                operationText.setText(text);
                break;
            case R.id.button5:
                text = text +"5";
                operationText.setText(text);
                break;
            case R.id.button6:
                text = text +"6";
                operationText.setText(text);
                break;
            case R.id.button7:
                text = text +"7";
                operationText.setText(text);
                break;
            case R.id.button8:
                text = text +"8";
                operationText.setText(text);
                break;
            case R.id.button9:
                text = text +"9";
                operationText.setText(text);
                break;
            case R.id.buttonEquals:
                if(buttonEquals.getVisibility() == View.VISIBLE){
                    String[] all = text.split(" ");
                    operator1 = Integer.parseInt(all[0]);
                    operation = all[1];
                    operator2 = Integer.parseInt(all[2]);

                    if(operation.contains("+")){
                        res = operator1 + operator2;
                    }

                    if(operation.contains("-")){
                        res = operator1 - operator2;
                    }

                    if(operation.contains("/")){
                        res = operator1/operator2;
                    }

                    if(operation.contains("*")){
                        res = operator1 * operator2;
                    }

                    text = String.valueOf(res);
                    resultText.setText(text);
                }

                break;

            case R.id.buttonMinus:
                text = text +" - ";
                operationText.setText(text);
                break;
            case R.id.buttonPlus:
                text = text +" + ";
                operationText.setText(text);
                break;
            case R.id.buttonDivide:
                text = text +" / ";
                operationText.setText(text);
                break;
            case R.id.buttonTimes:
                text = text +" * ";
                operationText.setText(text);
                break;

                default:
                    break;

        }
    }
}
