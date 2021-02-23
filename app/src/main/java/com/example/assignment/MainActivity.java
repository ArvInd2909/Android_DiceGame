package com.example.assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView player = findViewById(R.id.Dice_Pl);
        final ImageView computer = findViewById(R.id.Dice_Co);
        final ImageView Result=findViewById(R.id.Dialog);
        Button higher = findViewById(R.id.higher);
        Button lower = findViewById(R.id.lower);
        //-------------------------------------------------------------------

        final int [] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};
        // we want to pick one of the dices in array randomly and replace it with left and right
        // image view inside your app!
        // Click listener look for an event on your view components.
        higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                int userDie = rand.nextInt(6);
                int computerDie = rand.nextInt(6);
                Log.d("user die",String.valueOf(userDie));
                Log.d("computer die",String.valueOf(computerDie));

                player.setImageResource(diceArray[userDie]);
                computer.setImageResource(diceArray[computerDie]);
                // we need to create a random integer for picking the dices randomly!
                if(userDie>computerDie){
                    Result.setVisibility(View.VISIBLE);
                    Result.setImageResource(R.drawable.player);
                }
                else if(userDie==computerDie){
                    Result.setVisibility(View.VISIBLE);
                    Result.setImageResource(R.drawable.tie);
                }
                else {
                    Result.setVisibility(View.VISIBLE);
                    Result.setImageResource(R.drawable.computer);
                }
            }

        });
        lower.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random rand = new Random();
                int userDie = rand.nextInt(6);
                int computerDie = rand.nextInt(6);
                Log.d("user die",String.valueOf(userDie));
                Log.d("computer die",String.valueOf(computerDie));

                player.setImageResource(diceArray[userDie]);
                computer.setImageResource(diceArray[computerDie]);
                if(userDie<computerDie){
                    Result.setVisibility(View.VISIBLE);
                    Result.setImageResource(R.drawable.player);
                }
                else if(userDie==computerDie){
                    Result.setVisibility(View.VISIBLE);
                    Result.setImageResource(R.drawable.tie);
                }
                else {
                    Result.setVisibility(View.VISIBLE);
                    Result.setImageResource(R.drawable.computer);
                }
            }

        });

    }
    private void MessageBox(String message) {
        AlertDialog.Builder al=new AlertDialog.Builder(this);
        al.setTitle("Result");
        al.setMessage(message);
        al.show();
    }
}