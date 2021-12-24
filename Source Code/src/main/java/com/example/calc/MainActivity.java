package com.example.calc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText input, output;
    Vibrator vibrate;
    Button repor, sub, toquizz;
    Spinner spinnerconvert,spinnerresposta;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cria spinner e o adaptador para demonstrar o array de strings de opções em Strings.xml
        spinnerconvert = findViewById(R.id.spinner_types);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.types, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinnerconvert.setAdapter(adapter);

        spinnerresposta = findViewById(R.id.spinner_answer);
        ArrayAdapter<CharSequence>adapter2 = ArrayAdapter.createFromResource(this, R.array.answers, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinnerresposta.setAdapter(adapter2);


        // Associar variáveis à id em activity_main.xml
        input = findViewById(R.id.input);
        input.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        input.addTextChangedListener(textWatcher);

        output = findViewById(R.id.output);
        //implementar vibração
        vibrate = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        repor = findViewById(R.id.res);
        sub = findViewById(R.id.submeter);
        toquizz = findViewById(R.id.toquiz);

        // Ao clicar, verifica valor do spinner e implementa a função apropriada
        sub.setOnClickListener(v -> {

            //Hide keyboard
            InputMethodManager inputManager = (InputMethodManager)
            getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

            vibrate.vibrate(100);
            String item = spinnerconvert.getSelectedItem().toString();
            String results = spinnerresposta.getSelectedItem().toString();

            String errorcode = "Número Inválido!";
            Boolean IsRight = true;

            switch (item) {
                case "Base 2":
                    switch (results) {
                        case "Base 10":
                            String number = input.getText().toString();
                            Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar = p.matcher(number).find();
                            if(hasSpecialChar){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < number.length(); i++) {
                                if (!(number.charAt(i) >= '0' &&
                                        number.charAt(i) < ('0' + 2))) {
                                    IsRight = false;
                                }
                            }
                            if (IsRight) {
                                // Binario para decimal
                                int i = Integer.parseInt(number, 2);
                                String stored = Integer.toString(i);
                                output.setText(stored);
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        case "Base 8":
                            String number2 = input.getText().toString();
                            Pattern p1 = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar1 = p1.matcher(number2).find();
                            if(hasSpecialChar1){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < number2.length(); i++) {
                                if (!(number2.charAt(i) >= '0' &&
                                        number2.charAt(i) < ('0' + 2))) {
                                    IsRight = false;
                                }
                            }
                            if (IsRight) {
                                // Binario para decimal
                                int i = Integer.parseInt(number2, 2);
                                String stored = Integer.toOctalString(i);
                                output.setText(stored);
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        case "Base 16":
                            String number3 = input.getText().toString();
                            Pattern p2 = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar3 = p2.matcher(number3).find();
                            if(hasSpecialChar3){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < number3.length(); i++) {
                                if (!(number3.charAt(i) >= '0' &&
                                        number3.charAt(i) < ('0' + 2))) {
                                    IsRight = false;
                                }
                            }
                            if (IsRight) {
                                // Binario para decimal
                                int i = Integer.parseInt(number3, 2);
                                String stored = Integer.toHexString(i);
                                output.setText(stored);
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        default:
                            String answerfinal1 = input.getText().toString();
                            output.setText(answerfinal1);
                    }
                    break;
                case "Base 8":
                    switch (results) {
                        case "Base 10":
                            String secondnumber = input.getText().toString();
                            Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar = p.matcher(secondnumber).find();
                            if(hasSpecialChar){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < secondnumber.length(); i++)
                                if (!(secondnumber.charAt(i) >= '0' &&
                                        secondnumber.charAt(i) < ('0' + 8)))
                                    IsRight = false;
                            if (IsRight) {
                                int a = Integer.parseInt(secondnumber, 8);
                                output.setText(String.valueOf(a));
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        case "Base 2":
                            String secondnumber2 = input.getText().toString();
                            Pattern p1 = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar1 = p1.matcher(secondnumber2).find();
                            if(hasSpecialChar1){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < secondnumber2.length(); i++)
                                if (!(secondnumber2.charAt(i) >= '0' &&
                                        secondnumber2.charAt(i) < ('0' + 8)))
                                    IsRight = false;
                            if (IsRight) {
                                int a2 = Integer.parseInt(secondnumber2, 8);
                                String binarystring = Integer.toBinaryString(a2);
                                output.setText(binarystring);
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        case "Base 16":
                            String secondnumber3 = input.getText().toString();
                            Pattern p2 = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar2 = p2.matcher(secondnumber3).find();
                            if(hasSpecialChar2){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < secondnumber3.length(); i++)
                                if (!(secondnumber3.charAt(i) >= '0' &&
                                        secondnumber3.charAt(i) < ('0' + 8)))
                                    IsRight = false;
                            if (IsRight) {
                                int a3 = Integer.parseInt(secondnumber3, 8);
                                String hexstring2 = Integer.toHexString(a3);
                                output.setText(hexstring2);
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        default:
                            String answerfinal1 = input.getText().toString();
                            output.setText(answerfinal1);
                    }
                    break;
                case "Base 10":
                    switch (results) {
                        case "Base 2":
                            String thirdnumber = input.getText().toString();
                            Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar = p.matcher(thirdnumber).find();
                            if(hasSpecialChar){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < thirdnumber.length(); i++) {
                                if (!(thirdnumber.charAt(i) >= '0' &&
                                        thirdnumber.charAt(i) < ('0' + 10))) {
                                    IsRight = false;
                                }
                            }
                            if (IsRight) {
                                int c = Integer.parseInt(thirdnumber);
                                String binarystring = Integer.toBinaryString(c);
                                output.setText(binarystring);
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        case "Base 8":
                            String thirdnumber2 = input.getText().toString();
                            Pattern p1 = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar1 = p1.matcher(thirdnumber2).find();
                            if(hasSpecialChar1){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < thirdnumber2.length(); i++) {
                                if (!(thirdnumber2.charAt(i) >= '0' &&
                                        thirdnumber2.charAt(i) < ('0' + 10))) {
                                    IsRight = false;
                                }
                            }
                            if (IsRight) {
                                int b = Integer.parseInt(thirdnumber2);
                                String octalstring = Integer.toOctalString(b);
                                output.setText(octalstring);
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        case "Base 16":
                            String thirdnumber3 = input.getText().toString();
                            Pattern p2 = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar2 = p2.matcher(thirdnumber3).find();
                            if(hasSpecialChar2){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < thirdnumber3.length(); i++) {
                                if (!(thirdnumber3.charAt(i) >= '0' &&
                                        thirdnumber3.charAt(i) < ('0' + 10))) {
                                    IsRight = false;
                                }
                            }
                            if (IsRight) {
                                int b = Integer.parseInt(thirdnumber3);
                                String hexstring = Integer.toHexString(b);
                                output.setText(hexstring);
                            } else {
                                output.setText(errorcode);
                            }
                            break;
                        default:
                            String answerfinal1 = input.getText().toString();
                            output.setText(answerfinal1);
                    }
                    break;
                case "Base 16":
                    switch (results) {
                        case "Base 2":
                            String fourthnumber = input.getText().toString();
                            Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar = p.matcher(fourthnumber).find();
                            if(hasSpecialChar){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < fourthnumber.length(); i++) {
                                if (!(fourthnumber.charAt(i) >= '0' &&
                                        fourthnumber.charAt(i) < ('0' + 16) ||
                                        (fourthnumber.charAt(i) >= 'A' &&
                                                fourthnumber.charAt(i) < ('A' + 16  - 10))
                                    )) {
                                    IsRight = false;
                                }
                            }
                            if(IsRight) {
                                int c = Integer.parseInt(fourthnumber, 16);
                                String binnum = Integer.toBinaryString(c);
                                output.setText(binnum);
                                break;
                            }
                            else{
                                output.setText(errorcode);
                                break;
                            }
                        case "Base 8":
                            String fourthnumber2 = input.getText().toString();
                            Pattern p2 = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar2 = p2.matcher(fourthnumber2).find();
                            if(hasSpecialChar2){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < fourthnumber2.length(); i++) {
                                if (!(fourthnumber2.charAt(i) >= '0' &&
                                        fourthnumber2.charAt(i) < ('0' + 16) ||
                                        (fourthnumber2.charAt(i) >= 'A' &&
                                                fourthnumber2.charAt(i) < ('A' + 16  - 10))
                                )) {
                                    IsRight = false;
                                }
                            }
                            if(IsRight) {
                                int c = Integer.parseInt(fourthnumber2, 16);
                                String binnum2 = Integer.toOctalString(c);
                                output.setText(binnum2);
                                break;
                            }
                            else{
                                output.setText(errorcode);
                                break;
                            }
                        case "Base 10":
                            String fourthnumber3 = input.getText().toString();
                            Pattern p3 = Pattern.compile("[^a-zA-Z0-9]");
                            boolean hasSpecialChar3 = p3.matcher(fourthnumber3).find();
                            if(hasSpecialChar3){
                                input.setText("");
                                output.setText(errorcode);
                                break;
                            }
                            for (int i = 0; i < fourthnumber3.length(); i++) {
                                if (!(fourthnumber3.charAt(i) >= '0' &&
                                        fourthnumber3.charAt(i) < ('0' + 16) ||
                                        (fourthnumber3.charAt(i) >= 'A' &&
                                                fourthnumber3.charAt(i) < ('A' + 16  - 10))
                                )) {
                                    IsRight = false;
                                }
                            }
                            if(IsRight) {
                                int c = Integer.parseInt(fourthnumber3, 16);
                                String binnum3 = Integer.toString(c);
                                output.setText(binnum3);
                                break;
                            }
                            else{
                                output.setText(errorcode);
                                break;
                            }
                        default:
                            output.setText(errorcode);
                     }
                }
        });
        // Here, we will define a function which
        // will clear the whole text and reset it
        repor.setOnClickListener(v -> {
            vibrate.vibrate(100);
            input.setText("");
            output.setText("");
        });
        toquizz.setOnClickListener(v -> {
            vibrate.vibrate(100);
            Intent i = new Intent  (MainActivity.this, QuizActivity.class);
            startActivity(i);
            finish();
        });
    }
    private final TextWatcher textWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String dadoinput = input.getText().toString().trim();
            sub.setEnabled(!dadoinput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(MainActivity.this, HomeScreen.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}