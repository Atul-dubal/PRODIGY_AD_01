package apcoders.in.calculator;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    EditText calculation_data_edittext;
    LinearLayout mainConatiner;
    Button ac_btn, paranthesis_btn_left, paranthesis_btn_right, divide_btn, seven_btn, eight_btn, nine_btn, multiply_btn, four_btn, five_btn, six_btn, minus_btn, one_btn1, two_btn, three_btn, plus_btn, zero_btn, dot_btn, remove_btn, equal_btn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        calculation_data_edittext = findViewById(R.id.calculation_data);

        mainConatiner = findViewById(R.id.mainContainer);
        divide_btn = findViewById(R.id.divide_btn);
        minus_btn = findViewById(R.id.minus_btn);
        plus_btn = findViewById(R.id.plus_btn);
        multiply_btn = findViewById(R.id.multiply_btn);

        one_btn1 = findViewById(R.id.one_btn);
        two_btn = findViewById(R.id.two_btn);
        three_btn = findViewById(R.id.three_btn);
        four_btn = findViewById(R.id.four_btn);
        five_btn = findViewById(R.id.five_btn);
        six_btn = findViewById(R.id.six_btn);
        seven_btn = findViewById(R.id.seven_btn);
        eight_btn = findViewById(R.id.eight_btn);
        nine_btn = findViewById(R.id.nine_btn);
        zero_btn = findViewById(R.id.zero_btn);

        dot_btn = findViewById(R.id.dot_btn);
        remove_btn = findViewById(R.id.remove_btn);
        equal_btn = findViewById(R.id.equal_btn);
        ac_btn = findViewById(R.id.ac_btn);
        paranthesis_btn_left = findViewById(R.id.paranthesis_btn_left);
        paranthesis_btn_right = findViewById(R.id.paranthesis_btn_right);

        colorTheme();
        setKeyboard();

        calculation_data_edittext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inType = calculation_data_edittext.getInputType(); // Backup the input type
                calculation_data_edittext.setInputType(InputType.TYPE_NULL); // Disable the standard keyboard
                calculation_data_edittext.onTouchEvent(event); // Call native handler
                calculation_data_edittext.setInputType(inType); // Restore input type
                return true; // Consume touch event
            }
        });

    }

    private void colorTheme() {
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                // Dark theme is enabled
                mainConatiner.setBackgroundColor(getResources().getColor(R.color.black));

                one_btn1.setTextColor(getResources().getColor(R.color.white));
                two_btn.setTextColor(getResources().getColor(R.color.white));
                three_btn.setTextColor(getResources().getColor(R.color.white));
                four_btn.setTextColor(getResources().getColor(R.color.white));
                five_btn.setTextColor(getResources().getColor(R.color.white));
                six_btn.setTextColor(getResources().getColor(R.color.white));
                seven_btn.setTextColor(getResources().getColor(R.color.white));
                eight_btn.setTextColor(getResources().getColor(R.color.white));
                nine_btn.setTextColor(getResources().getColor(R.color.white));
                zero_btn.setTextColor(getResources().getColor(R.color.white));
                ac_btn.setTextColor(getResources().getColor(R.color.white));
                paranthesis_btn_left.setTextColor(getResources().getColor(R.color.white));
                paranthesis_btn_right.setTextColor(getResources().getColor(R.color.white));
                remove_btn.setTextColor(getResources().getColor(R.color.white));
                plus_btn.setTextColor(getResources().getColor(R.color.white));
                minus_btn.setTextColor(getResources().getColor(R.color.white));
                multiply_btn.setTextColor(getResources().getColor(R.color.white));
                divide_btn.setTextColor(getResources().getColor(R.color.white));
                dot_btn.setTextColor(getResources().getColor(R.color.white));
                equal_btn.setTextColor(getResources().getColor(R.color.white));

                calculation_data_edittext.setBackgroundDrawable(getResources().getDrawable(R.drawable.edittext_layout_dark));
                break;
            case Configuration.UI_MODE_NIGHT_NO:
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                // Light theme is enabled
                mainConatiner.setBackgroundColor(getResources().getColor(R.color.white));

                calculation_data_edittext.setBackgroundDrawable(getResources().getDrawable(R.drawable.edittext_layout_light));
                break;
        }
    }

    private void setKeyboard() {

        View.OnClickListener ButtonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pre_data = calculation_data_edittext.getText().toString();
                if (pre_data.length() >= 18 && pre_data.length() < 36) {
                    calculation_data_edittext.setTextSize(50);
                } else if (pre_data.length() >= 36) {
                    calculation_data_edittext.setTextSize(40);
                } else if (pre_data.length() < 18) {
                    calculation_data_edittext.setTextSize(70);
                }

                int id = v.getId();
                if (id == R.id.one_btn) {
                    calculation_data_edittext.setText(pre_data + "1");
                } else if (id == R.id.two_btn) {
                    calculation_data_edittext.setText(pre_data + "2");
                } else if (id == R.id.three_btn) {
                    calculation_data_edittext.setText(pre_data + "3");
                } else if (id == R.id.four_btn) {
                    calculation_data_edittext.setText(pre_data + "4");
                } else if (id == R.id.five_btn) {
                    calculation_data_edittext.setText(pre_data + "5");
                } else if (id == R.id.six_btn) {
                    calculation_data_edittext.setText(pre_data + "6");
                } else if (id == R.id.seven_btn) {
                    calculation_data_edittext.setText(pre_data + "7");
                } else if (id == R.id.eight_btn) {
                    calculation_data_edittext.setText(pre_data + "8");
                } else if (id == R.id.nine_btn) {
                    calculation_data_edittext.setText(pre_data + "9");
                } else if (id == R.id.zero_btn) {
                    calculation_data_edittext.setText(pre_data + "0");
                } else if (id == R.id.plus_btn) {
                    calculation_data_edittext.setText(pre_data + "+");
                } else if (id == R.id.minus_btn) {
                    calculation_data_edittext.setText(pre_data + "-");
                } else if (id == R.id.divide_btn) {
                    calculation_data_edittext.setText(pre_data + "÷");
                } else if (id == R.id.multiply_btn) {
                    calculation_data_edittext.setText(pre_data + "x");
                } else if (id == R.id.ac_btn) {
                    calculation_data_edittext.setText("");
                } else if (id == R.id.remove_btn) {
                    if (pre_data.length() >= 1) {
                        calculation_data_edittext.setText(pre_data.substring(0, pre_data.length() - 1));
                    }
                } else if (id == R.id.dot_btn) {
                    calculation_data_edittext.setText(pre_data + ".");
                } else if (id == R.id.equal_btn) {
                    calculation_data_edittext.setText(evaluateExpression(pre_data) + "");
                } else if (id == R.id.paranthesis_btn_left) {
                    calculation_data_edittext.setText(pre_data + "(");
                } else if (id == R.id.paranthesis_btn_right) {

                    calculation_data_edittext.setText(pre_data + ")");


                }

            }
        };


        divide_btn.setOnClickListener(ButtonClick);
        minus_btn.setOnClickListener(ButtonClick);
        plus_btn.setOnClickListener(ButtonClick);
        multiply_btn.setOnClickListener(ButtonClick);
        one_btn1.setOnClickListener(ButtonClick);
        two_btn.setOnClickListener(ButtonClick);
        three_btn.setOnClickListener(ButtonClick);
        four_btn.setOnClickListener(ButtonClick);
        five_btn.setOnClickListener(ButtonClick);
        six_btn.setOnClickListener(ButtonClick);
        seven_btn.setOnClickListener(ButtonClick);
        eight_btn.setOnClickListener(ButtonClick);
        nine_btn.setOnClickListener(ButtonClick);
        zero_btn.setOnClickListener(ButtonClick);
        dot_btn.setOnClickListener(ButtonClick);
        remove_btn.setOnClickListener(ButtonClick);
        equal_btn.setOnClickListener(ButtonClick);
        ac_btn.setOnClickListener(ButtonClick);
        paranthesis_btn_left.setOnClickListener(ButtonClick);
        paranthesis_btn_right.setOnClickListener(ButtonClick);


    }

    private double evaluateExpression(String expression) {
        try {
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (Character.isDigit(c)) {
                    StringBuilder num = new StringBuilder();
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        num.append(expression.charAt(i));
                        i++;
                    }
                    numbers.push(Double.parseDouble(num.toString()));
                    i--;
                } else if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (operators.peek() != '(') {
                        double num2 = numbers.pop();
                        double num1 = numbers.pop();
                        char op = operators.pop();
                        numbers.push(applyOperation(num1, num2, op));
                    }
                    operators.pop();
                } else if (c == '+' || c == '-' || c == 'x' || c == '÷') {
                    while (!operators.empty() && precedence(operators.peek()) >= precedence(c)) {
                        double num2 = numbers.pop();
                        double num1 = numbers.pop();
                        char op = operators.pop();
                        numbers.push(applyOperation(num1, num2, op));
                    }
                    operators.push(c);
                }
            }

            while (!operators.empty()) {
                double num2 = numbers.pop();
                double num1 = numbers.pop();
                char op = operators.pop();
                numbers.push(applyOperation(num1, num2, op));
            }

            return numbers.pop();
        } catch (Exception ignored) {
            return 0;
        }
    }

    private double applyOperation(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case '÷':
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    private int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == 'x' || op == '÷') {
            return 2;
        } else {
            return 0;
        }
    }
}
