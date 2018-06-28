package com.yanes.album;

/**
 * Created by Claudia and Lidia Yanes.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class Blackjack_Play extends Activity implements View.OnClickListener {
    Random rnd = new Random();
    int suit = 100;
    int value = 100;
    int my_card_value = 0;
    int cupier_card_value = 0;
    Blackjack_Card card;
    int repe;
    ArrayList<Blackjack_Card> my_used_cards = new ArrayList<>();
    ArrayList<Blackjack_Card> used_cards = new ArrayList<>();
    ArrayList<Blackjack_Card> cupier_used_cards = new ArrayList<>();
    ArrayList<Blackjack_Card> my_ases_cards = new ArrayList<>();
    boolean repetidas = true;
    boolean igual = false;
    boolean AS = false;

    int game_money;
    int total_money;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Intent intent = getIntent();
        game_money = intent.getIntExtra(Game_Blackjack.SGameMoney, 0);
        total_money = intent.getIntExtra(Game_Blackjack.STotalMoney, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_play);

        TextView mycards = (TextView) findViewById(R.id.mycards);
        TextView cupiercards = (TextView) findViewById(R.id.cupiercards);


        Button b1 = (Button) findViewById(R.id.bhit);
        Button b2 = (Button) findViewById(R.id.bdouble);
        Button b3 = (Button) findViewById(R.id.bstand);



        TextView tv = (TextView) findViewById(R.id.totalmoney);
        tv.setText("" + total_money);
        tv = (TextView) findViewById(R.id.gamemoney);
        tv.setText("" + game_money);


        if (total_money < game_money) {
            b2.setVisibility(View.INVISIBLE);

        }

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);


        Integer[] STATES = {R.id.image1, R.id.image2, R.id.image3, R.id.image4};

        for (int i = 0; i < 3; i++) {
            ImageView img = (ImageView) findViewById(STATES[i]);

            if (i == 0 || i == 1) {
                i = my(img, i);
            } else if (i == 2) {
                i = cupier(img, i);

            } else {
                img.setImageResource(R.drawable.back);
                img.bringToFront();
            }


        }
        mycards.setText("" + my_card_value);
        cupiercards.setText("" + cupier_card_value);

        if (my_card_value == 21) {
            Toast.makeText(this, "BlackJack", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = getIntent();
        game_money = intent.getIntExtra(Game_Blackjack.SGameMoney, 0);
        total_money = intent.getIntExtra(Game_Blackjack.STotalMoney, 0);

        Integer[] STATES2 = {R.id.image4, R.id.image8, R.id.image9, R.id.image10, R.id.image32, R.id.image42, R.id.image82, R.id.image92, R.id.image102 };
        TextView mycards = (TextView) findViewById(R.id.mycards);
        TextView cupiercards = (TextView) findViewById(R.id.cupiercards);
        ImageView img = null;



        if (view.getId() == R.id.bhit) {

            for (int b = 0; b < 1; b++) {
                if (repe == 0 ) {
                    img = (ImageView) findViewById(R.id.image5);
                } else if (repe == 1) {
                    img = (ImageView) findViewById(R.id.image6);
                } else if (repe == 2) {
                    img = (ImageView) findViewById(R.id.image7);
                } else if(repe ==3){
                    img =(ImageView) findViewById(R.id.image12);
                } else if(repe==4){
                    img =(ImageView) findViewById(R.id.image22);
                } else if(repe==5){
                    img =(ImageView) findViewById(R.id.image52);
                } else if(repe==6){
                    img =(ImageView) findViewById(R.id.image62);
                } else {
                    img =(ImageView) findViewById(R.id.image72);
                }
                    b = my(img, b);


            }
            repe++;


            Button b2 = (Button) findViewById(R.id.bdouble);
            b2.setVisibility(View.INVISIBLE);



            if (my_card_value > 21) {


                igual = false;
                AS = false;

                for (int a = 0; a < my_used_cards.size(); a++) {
                    if (my_used_cards.get(a).setmoney() == 11) {
                        AS=true;
                 for (int b = 0; b < my_ases_cards.size(); b++) {

                         if (my_used_cards.get(a).setImage().equals(my_ases_cards.get(b).setImage())) {

                             igual=true;
                             AS=false;

                         }
                     }
                     if(igual ==false){
                        my_ases_cards.add(my_used_cards.get(a));
                     }else{
                         igual=false;
                     }
                 }
                }
                if (AS == false) {
                    Button b3= (Button) findViewById(R.id.bstand);
                    b3.setVisibility(View.INVISIBLE);
                    Button b1= (Button) findViewById(R.id.bhit);
                    b1.setVisibility(View.INVISIBLE);
                    Toast.makeText(this, "LOST", Toast.LENGTH_SHORT).show();
                    back();

                } else {
                    for(int i=0; i<my_ases_cards.size(); i++) {
                        if (my_card_value > 21) {
                            my_card_value -= 10;
                        }
                    }
                }

            }

            mycards.setText("" + my_card_value);
            cupiercards.setText("" + cupier_card_value);



        } else if (view.getId() == R.id.bstand) {
            Button b1 = (Button) findViewById(R.id.bhit);
            b1.setVisibility(View.INVISIBLE);
            Button b2 = (Button) findViewById(R.id.bdouble);
            b2.setVisibility(View.INVISIBLE);

        for (int i = 0; i < 9; i++) {
                if (cupier_card_value <= 16) {
                    ImageView imgc = (ImageView) findViewById(STATES2[i]);
                    i = cupier(imgc, i);
                }

            }


            if ((cupier_card_value > my_card_value) && (cupier_card_value <= 21)) {
                Toast.makeText(this, "LOST", Toast.LENGTH_SHORT).show();
            } else if (cupier_card_value == my_card_value) {
                    total_money += game_money;
                Toast.makeText(this, "Tie", Toast.LENGTH_SHORT).show();
            } else {
                    total_money += game_money * 2;
                Toast.makeText(this, "Win", Toast.LENGTH_SHORT).show();
            }

            back();


        } else if (view.getId() == R.id.bdouble) {

            ImageView img1 = (ImageView) findViewById(R.id.image5);
            for (int bb = 0; bb < 1; bb++) {
                bb = my(img1, bb);
            }


            for (int i = 0; i < 9; i++) {
                if (cupier_card_value <= 16) {
                    ImageView imgc = (ImageView) findViewById(STATES2[i]);
                    i = cupier(imgc, i);


                }
            }


            if (my_card_value > 21) {

                igual = false;
                AS = false;

                for (int a = 0; a < my_used_cards.size(); a++) {
                    for (int b = 0; b < my_ases_cards.size(); b++) {

                        if (my_used_cards.get(a).setImage().equals(my_ases_cards.get(b).setImage())) {

                            igual = true;
                        }
                    }

                    if (my_used_cards.get(a).setmoney() == 11 && igual == false) {
                        my_ases_cards.add(my_used_cards.get(a));
                        AS = true;
                    }
                }
                if (AS==true){

                    for(int i=0; i<my_ases_cards.size(); i++)
                        if(my_card_value> 21) {
                            my_card_value -= 10;
                        }
                }
            }

            if (cupier_card_value == my_card_value || cupier_card_value >21 && my_card_value >21) {

                    total_money += game_money;

                Toast.makeText(this, "Tie" , Toast.LENGTH_SHORT).show();
            } else if(my_card_value>21){
                    Toast.makeText(this, "LOST", Toast.LENGTH_SHORT).show();
                    total_money -= game_money;

                back();


            } else if ((cupier_card_value > my_card_value) && (cupier_card_value <= 21)) {
                    total_money -= game_money;
                Toast.makeText(this, "LOST", Toast.LENGTH_SHORT).show();

            } else if ((cupier_card_value < my_card_value && my_card_value<= 21) ||(my_card_value<= 21 && cupier_card_value>21 )){
                    total_money += game_money * 3;
                Toast.makeText(this, "Win", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();
            }
            back();

        }

    }

    public void back(){
        TextView mycards = (TextView) findViewById(R.id.mycards);
        TextView cupiercards = (TextView) findViewById(R.id.cupiercards);

        String str_total = Integer.toString(total_money);
        str_total = str_total.trim();
        Game_Blackjack.STotalMoney = str_total;

       Intent intent1 = new Intent(this, MainActivity.class);
       intent1.putExtra(Game_Blackjack.STotalMoney, str_total);
        game_money = 0;
        String game = Integer.toString(game_money);
        Game_Blackjack.SGameMoney = game;
        intent1.putExtra(Game_Blackjack.SGameMoney, game);


        mycards.setText("" + my_card_value);
        cupiercards.setText("" + cupier_card_value);

        setResult(RESULT_OK, intent1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Blackjack_Play.this.finish();
            }
        }, 3000);

    }

    public void azar() {
        suit = rnd.nextInt(4);
        value = rnd.nextInt(13);

        card = new Blackjack_Card(suit, value);


    }

    public int my(ImageView img, int b) {
        azar();
        for (int a = 0; a < used_cards.size(); a++) {

            if (card.setImage().equals(used_cards.get(a).setImage())) {

                repetidas = false;
            }
        }
        if (repetidas == true) {
            my_card_value += card.setmoney();
            my_used_cards.add(card);
            used_cards.add(card);
            img.setImageResource(card.setImage());
            img.bringToFront();
        } else {
            repetidas = true;
            b--;
        }
        return b;
    }

    public int cupier(ImageView img, int b) {

       azar();
        for (int a = 0; a < used_cards.size(); a++) {

            if (card.setImage().equals(used_cards.get(a).setImage())) {

                repetidas = false;
            }
        }

        if (repetidas == true) {
            cupier_card_value += card.setmoney();
            cupier_used_cards.add(card);
            used_cards.add(card);
            img.setImageResource(card.setImage());
        } else {
            repetidas = true;
            b--;
        }
        return b;
    }




    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You cannot leave this page until the game is over!", Toast.LENGTH_SHORT).show();

    }
}

