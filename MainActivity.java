package lv.lauris.pd4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView screen, testScreen;
    private String screenValue = "", firstValue = "", secondValue = "", actionValue = "", cachedSecond = "", memory = "";
    private Double sum, first, second;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testScreen = findViewById(R.id.textView);
        screen = findViewById(R.id.textView2);
        Button dot = findViewById(R.id.dot);
        Button add = findViewById(R.id.add);
        Button subtract = findViewById(R.id.subtract);
        Button multiply = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button zero = findViewById(R.id.zero);
        Button clear = findViewById(R.id.button1);
        Button back = findViewById(R.id.back);
        Button equals = findViewById(R.id.equals);
        Button ms = findViewById(R.id.ms);
        Button mr = findViewById(R.id.mr);
        Button mc = findViewById(R.id.mc);

        clear.setOnClickListener(view -> {
            screenValue = "";
            secondValue = "";
            actionValue = "";
            firstValue = "";
            screen.setText(screenValue);
        });

        back.setOnClickListener(view ->{
            if (!secondValue.isEmpty()){
                secondValue = secondValue.substring(0, secondValue.length()-1);
                screenValue = firstValue + actionValue + secondValue;
            } else if (secondValue.isEmpty() && !actionValue.isEmpty()){
                actionValue = "";
                screenValue = firstValue;
            } else if (!firstValue.isEmpty()){
                firstValue = firstValue.substring(0, firstValue.length()-1);
                screenValue = firstValue;
            }
            screen.setText(screenValue);
        });

        ms.setOnClickListener(view -> {
            if (!secondValue.isEmpty()){
                memory = secondValue;
            } else {
                memory = firstValue;
            }
            testScreen.setText(memory);
        });

        mr.setOnClickListener(view -> {
            if (firstValue.isEmpty()){
                firstValue = memory;
            } else if (secondValue.isEmpty()) {
                secondValue = memory;
                screenValue = screenValue + secondValue;
            }
            screen.setText(screenValue);
        });

        mc.setOnClickListener(view -> {
            memory = "";
            testScreen.setText(memory);
        });

        one.setOnClickListener(view -> setValue("1"));
        two.setOnClickListener(view -> setValue("2"));
        three.setOnClickListener(view -> setValue("3"));
        four.setOnClickListener(view -> setValue("4"));
        five.setOnClickListener(view -> setValue("5"));
        six.setOnClickListener(view -> setValue("6"));
        seven.setOnClickListener(view -> setValue("7"));
        eight.setOnClickListener(view -> setValue("8"));
        nine.setOnClickListener(view -> setValue("9"));
        zero.setOnClickListener(view -> setValue("0"));
        dot.setOnClickListener(view -> addDot());

        equals.setOnClickListener(view -> action("="));
        add.setOnClickListener(view -> action("+"));
        subtract.setOnClickListener(view -> action("-"));
        multiply.setOnClickListener(view -> action("*"));
        divide.setOnClickListener(view -> action("/"));
    }

    public void setValue(String id){
        if (actionValue.isEmpty()){
            screenValue = screenValue + id;
            firstValue = screenValue;
            screen.setText(screenValue);
        } else if (actionValue.equals("-")){
            screenValue = screenValue + id;
            secondValue = secondValue + id;
            screen.setText(screenValue);
        } else if (!actionValue.isEmpty()){
            secondValue = secondValue + id;
            screenValue = screenValue + id;
            screen.setText(screenValue);
        }
    }

    public void action(String id){

        if (firstValue.isEmpty() && id.equals("-")){
            screenValue = "-";
            firstValue = "0";
            actionValue = id;
            screen.setText(screenValue);
        } else if (firstValue.isEmpty() && actionValue.isEmpty()){
        } else if (!firstValue.isEmpty() && actionValue.isEmpty()){
            actionValue = id;
            screenValue = screenValue + id;
            screen.setText(screenValue);
        } else if (!firstValue.isEmpty() && !id.equals("=") && secondValue.isEmpty()){
            actionValue = id;
            screenValue = firstValue + id;
            screen.setText(screenValue);
        }

        if (!secondValue.isEmpty() || !cachedSecond.isEmpty() && id.equals("=")){
            if (id.equals("=") && secondValue.isEmpty()){
                first = Double.parseDouble(firstValue);
                second = Double.parseDouble(cachedSecond);
                secondValue = cachedSecond;
                actionSwitch();
                updateEqualsValues();
            } else {
                first = Double.parseDouble(firstValue);
                second = Double.parseDouble(secondValue);
                if (id.equals("=")){
                    actionSwitch();
                    updateEqualsValues();
                } else if (id.equals("+")) {
                    actionSwitch();
                    updateValues(id);
                } else if (id.equals("-")) {
                    actionSwitch();
                    updateValues(id);
                } else if (id.equals("*")) {
                    actionSwitch();
                    updateValues(id);
                } else if (id.equals("/")) {
                    actionSwitch();
                    updateValues(id);
                }
            }
        }
    }

    public void actionSwitch(){
        switch (actionValue) {
            case "+":
                sum = first + second;
                break;
            case "-":
                sum = first - second;
                break;
            case "*":
                sum = first * second;
                break;
            case "/":
                sum = first / second;
                break;
        }
    }

    public void updateEqualsValues(){
        String b;
        if (Math.ceil(sum) == Math.floor(sum)) {
            int a = sum.intValue();
            b = Integer.toString(a);
        } else {
            //sum = Math.floor(sum*100000000) / 100000000;
            b = Double.toString(sum);
        }
        firstValue = b;
        screenValue = b + actionValue;
        cachedSecond = secondValue;
        secondValue = "";
        screen.setText(screenValue);
    }

    public void updateValues(String id){
        secondValue = "";
        screenValue = Double.toString(sum);
        if (Math.ceil(sum) == Math.floor(sum)) {
            int a = sum.intValue();
            screenValue = Integer.toString(a);
        }
        firstValue = screenValue;
        actionValue = id;
        screenValue = screenValue + id;
    }

    public void addDot(){
        if (!secondValue.isEmpty()){
            if (!secondValue.contains(".")) {
                secondValue = secondValue + ".";
                screenValue = screenValue + ".";
            } else if (secondValue.contains(".")) {
            }
        } else if (!firstValue.isEmpty() && !actionValue.isEmpty() && secondValue.isEmpty()){
            secondValue = "0.";
            screenValue = screenValue + "0.";
        } else if (!firstValue.isEmpty() && actionValue.isEmpty()){
            if (!firstValue.contains(".")) {
                firstValue = firstValue + ".";
                screenValue = screenValue + ".";
            } else if (firstValue.contains(".")) {
            }
        } else if (firstValue.isEmpty()) {
            firstValue = "0.";
            screenValue = screenValue + "0.";
        }
        screen.setText(screenValue);
    }
}