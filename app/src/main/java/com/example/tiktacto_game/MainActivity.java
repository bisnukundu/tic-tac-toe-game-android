package com.example.tiktacto_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
 private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn_reset;
 private int check = 0;
 public Button[] allBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn_reset = findViewById(R.id.btn_reset);

        allBtn = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};


// X and O print on screen
        for (Button btn : allBtn){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button current_btn = (Button) view;
                    if(current_btn.getText() == "") {

                        if (check == 0) {
                            current_btn.setText("X");
                            check = 1;
                        } else {
                            current_btn.setText("O");
                            check = 0;
                        }

                    }else {
                        Toast.makeText(getApplicationContext(), "Already Clicked", Toast.LENGTH_SHORT).show();
                    }
                    checkWinner();
                }
            });
        }

    //Reset Button Click Listerner
       btn_reset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               resetFun();
               Toast.makeText(getApplicationContext(), "Game Reset", Toast.LENGTH_SHORT).show();
           }
       });



    }

    //Reset Function
    public void resetFun(){
        for(Button btn : allBtn){
            btn.setText(null);
        }
    }


    //Check winner
    public void checkWinner(){
        String b1 = btn1.getText().toString();
        String b2 = btn2.getText().toString();
        String b3 = btn3.getText().toString();
        String b4 = btn4.getText().toString();
        String b5 = btn5.getText().toString();
        String b6 = btn6.getText().toString();
        String b7 = btn7.getText().toString();
        String b8 = btn8.getText().toString();
        String b9 = btn9.getText().toString();

        if(b1.equals(b2) && b2.equals(b3) && !b1.isEmpty()){
            Toast.makeText(getApplicationContext(), btn1.getText()+" Winner", Toast.LENGTH_SHORT).show();
            resetFun();
        }else if(b1.equals(b4) && b4.equals(b7) && !b1.isEmpty()){
            Toast.makeText(getApplicationContext(), btn1.getText()+" Winner", Toast.LENGTH_SHORT).show();
            resetFun();
        }else if(b2.equals(b5) && b5.equals(b8) && !b2.isEmpty()){
            Toast.makeText(getApplicationContext(), btn2.getText()+" Winner", Toast.LENGTH_SHORT).show();
            resetFun();
        }else if(b3.equals(b6) && b6.equals(b9) && !b3.isEmpty()){
            Toast.makeText(getApplicationContext(), btn3.getText()+" Winner", Toast.LENGTH_SHORT).show();
            resetFun();
        }else if(b4.equals(b5) && b5.equals(b6) && !b4.isEmpty()){
            Toast.makeText(getApplicationContext(), btn4.getText()+" Winner", Toast.LENGTH_SHORT).show();
            resetFun();
        }else if(b7.equals(b8) && b8.equals(b9) && !b7.isEmpty()){
            Toast.makeText(getApplicationContext(), btn7.getText()+" Winner", Toast.LENGTH_SHORT).show();
            resetFun();
        }else if(b1.equals(b5) && b5.equals(b9) && !b1.isEmpty()){
            Toast.makeText(getApplicationContext(), btn1.getText()+" Winner", Toast.LENGTH_SHORT).show();
            resetFun();
        }else if(b3.equals(b5) && b5.equals(b7) && !b3.isEmpty()){
            Toast.makeText(getApplicationContext(), btn3.getText()+" Winner", Toast.LENGTH_SHORT).show();
            resetFun();
        }
    }

}