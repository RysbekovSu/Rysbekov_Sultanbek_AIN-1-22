package com.example.rysbekov_sultanbek_ain_1_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView response, asnwer;
    Random ran  = new Random();

    int res, getRes;
    LottieAnimationView lotty_sun, lotty_one, lotty_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.b);
        response = findViewById(R.id.response);
        asnwer = findViewById(R.id.main_answer);
        lotty_sun = findViewById(R.id.lotty_sun);
        lotty_one = findViewById(R.id.lotty_one);
        lotty_two = findViewById(R.id.lotty_two);
        lotty_sun.setAnimation(R.raw.sunshine);
        lotty_one.setAnimation(R.raw.animation_fire);
        lotty_two.setAnimation(R.raw.fun_time);

        lotty_one.setVisibility(View.INVISIBLE);
        lotty_two.setVisibility(View.INVISIBLE);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                res = ran.nextInt(101);
                if(res > 0){
                    printAnswer();
                    response.setText(String.valueOf(res) + "%");
                    b.setVisibility(View.INVISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "Press again", Toast.LENGTH_LONG).show();
                    b.setVisibility(View.VISIBLE);
                }

            }


        });




    }
    private void printAnswer(){

            if(res>80){
                asnwer.setText("Excellent. You buy the beer!");
                lotty_one.setVisibility(View.VISIBLE);
            }
            else if (res >= 50 && res<=80) {
                asnwer.setText("Cool let's have a beer!");
                lotty_two.setVisibility(View.VISIBLE);
            } else {
                asnwer.setText("Nah!!! Only a beer will save us!");
                lotty_two.setVisibility(View.VISIBLE);

            }

    }

}