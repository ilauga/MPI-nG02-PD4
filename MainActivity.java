package lv.ievalauga.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonEqual, buttonMS, buttonMC, buttonMR;
    EditText enteredValue;

    String savedValue;

    float mValueOne, mValueTwo;

    boolean calcAddition, calcSubtract, calcMultiplication, calcDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        buttonMS = (Button) findViewById(R.id.buttonms);
        buttonMR = (Button) findViewById(R.id.buttonmr);
        buttonMC = (Button) findViewById(R.id.buttonmc);
        enteredValue = (EditText) findViewById(R.id.etValue);
        savedValue = "";

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (enteredValue == null) {
                    enteredValue.setText("");
                } else {
                    mValueOne = Float.parseFloat(enteredValue.getText() + "");
                    calcAddition = true;
                    enteredValue.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(enteredValue.getText() + "");
                calcSubtract = true;
                enteredValue.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(enteredValue.getText() + "");
                calcMultiplication = true;
                enteredValue.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(enteredValue.getText() + "");
                calcDivision = true;
                enteredValue.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(enteredValue.getText() + "");

                if (calcAddition == true) {
                    enteredValue.setText(mValueOne + mValueTwo + "");
                    calcAddition = false;
                }

                if (calcSubtract == true) {
                    enteredValue.setText(mValueOne - mValueTwo + "");
                    calcSubtract = false;
                }

                if (calcMultiplication == true) {
                    enteredValue.setText(mValueOne * mValueTwo + "");
                    calcMultiplication = false;
                }

                if (calcDivision == true) {
                    enteredValue.setText(mValueOne / mValueTwo + "");
                    calcDivision = false;
                }
            }
        });

        buttonMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedValue = "";
                enteredValue.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enteredValue.setText(enteredValue.getText() + ".");
            }
        });

        buttonMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enteredValue.getText().equals("")){
                    Toast.makeText(MainActivity.this, "No Value to save", Toast.LENGTH_SHORT).show();
                } else {
                    savedValue = enteredValue.getText().toString();
                    Toast.makeText(MainActivity.this,"Saved: " + savedValue, Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedValue.equals("")){
                    Toast.makeText(MainActivity.this, "No Value saved", Toast.LENGTH_SHORT).show();
                } else {
                    enteredValue.setText(savedValue);
                }

            }
        });


    }
}