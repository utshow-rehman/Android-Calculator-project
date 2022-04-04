package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;





public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListener();


    }



        public String evaluate(String expression)
        {
            String rt="";
            char[] tokens = expression.toCharArray();


            Stack<Double> values = new
                    Stack<Double>();

            // Stack for Operators: 'ops'
            Stack<Character> ops = new
                    Stack<Character>();

            for (int i = 0; i < tokens.length; i++)
            {


                if (tokens[i] == ' ')
                    continue;

                // Current token is a number,
                // push it to stack for numbers
                if (tokens[i] >= '0' &&
                        tokens[i] <= '9')
                {
                    StringBuffer sbuf = new
                            StringBuffer();

                    // There may be more than one
                    // digits in number
                    while (i < tokens.length &&
                            tokens[i] >= '0' &&
                            tokens[i] <= '9')
                        sbuf.append(tokens[i++]);
                    values.push(Double.parseDouble(sbuf.
                            toString()));


                    i--;
                }


                else if (tokens[i] == '(')
                    ops.push(tokens[i]);


                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));
                    ops.pop();
                }

                // Current token is an operator.
                else if (tokens[i] == '+' ||
                        tokens[i] == '-' ||
                        tokens[i] == '*' ||
                        tokens[i] == '/')
                {

                    while (!ops.empty() &&
                            hasPrecedence(tokens[i],
                                    ops.peek()))
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));

                    // Push current token to 'ops'.
                    ops.push(tokens[i]);
                }
            }

            // Entire expression has been
            // parsed at this point, apply remaining
            // ops to remaining values
            while (!ops.empty())
                values.push(applyOp(ops.pop(),
                        values.pop(),
                        values.pop()));

            // Top of 'values' contains
            // result, return it
            rt=Double.toString(values.pop());
            return rt;
        }

        // Returns true if 'op2' has higher
        // or same precedence as 'op1',
        // otherwise returns false.
        public boolean hasPrecedence(
                char op1, char op2)
        {
            if (op2 == '(' || op2 == ')')
                return false;
            if ((op1 == '*' || op1 == '/') &&
                    (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }


        public Double applyOp(char op,
                                  Double b, Double a)
        {
            switch (op)
            {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    return a / b;
            }
            return 0.0;
        }



    //-----------------------------------------



    private String st = "";


    //Error checking--------------------------------
    public boolean checkError(String st){
        Stack<Character> br = new
                Stack<Character>();


       if(st.charAt(0)=='(')
           br.push('(');
        if(st.charAt(0)==')')
          return false;


        for (int i = 1; i < st.length(); i++) {
            if (st.charAt(i) == '+' && st.charAt(i - 1) == '+') {
                return false;
            }
            if (st.charAt(i) == '-' && st.charAt(i - 1) == '-') {
                return false;
            }
            if (st.charAt(i) == '*' && st.charAt(i - 1) == '*') {
                return false;
            }
            if (st.charAt(i) == '/' && st.charAt(i - 1) == '/') {
                return false;
            }
            if (st.charAt(i) == '.' && st.charAt(i - 1) == '.') {
                return false;
            }
            if (st.charAt(i) == '0' && st.charAt(i - 1) == '/') {
                return false;
            }

            if (st.charAt(i) == '(') {
                br.push('(');

            }

            if (st.charAt(i) == ')') {

                if (br.empty() || br.peek() != '(') {
                   return false;
                } else
                    br.pop();

            }

        }


        if (!br.empty())
           return false;


        return true;
    }
 //

    public void addListener() {
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button zero = (Button) findViewById(R.id.zero);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button gun = (Button) findViewById(R.id.gun);
        Button vag = (Button) findViewById(R.id.vag);
        Button equal = (Button) findViewById(R.id.equal);
        Button c = (Button) findViewById(R.id.c);
        Button fbracket=(Button) findViewById(R.id.fbracket);
        Button sbracket=(Button) findViewById(R.id.sbracket);
        Button del=(Button) findViewById(R.id.del);
        TextView txt=(TextView) findViewById(R.id.txt);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '1';
                txt.setText(st);
            }

        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '2';
                txt.setText(st);
            }

        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '3';
                txt.setText(st);
            }

        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '4';
                txt.setText(st);
            }

        }); five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '5';
                txt.setText(st);
            }

        }); six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '6';
                txt.setText(st);
            }

        }); seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '7';
                txt.setText(st);
            }

        }); eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '8';
                txt.setText(st);
            }

        }); nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '9';
                txt.setText(st);
            }


        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '0';
                txt.setText(st);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   st+="+";
                txt.setText(st);

            }

        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st += '-';
                txt.setText(st);
            }

        });
        gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  st += '*';
                txt.setText(st);
            }

        });
        vag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 st += '/';
                txt.setText(st);
            }

        });
        fbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st+="(";
                txt.setText(st);
            }

        });
        sbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st+=")";
                txt.setText(st);
            }

        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(st.length()>0){
                     st=st.substring(0, st.length() - 1);

                 }
                txt.setText(st);
            }

        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st="";
                 txt.setText("");
            }

        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                 if(!st.isEmpty()) {

                     if (checkError(st)) {
                         String ans;
                         ans = evaluate(st);


                         txt.setText(ans);
                         st = "";

                     } else {
                         st = "Error";
                         txt.setText(st);
                         st = "";
                     }
                 }




            }
        });




    }
}

