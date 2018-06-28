package com.yanes.album;

/**
 * Created by Claudia and Lidia Yanes.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game_Blackjack extends Activity implements View.OnClickListener {

    private static final int REQUEST_CODE_ADD = 100;
    public static String SGameMoney = "smoney";
    public static String STotalMoney = "tmoney";

    private int total_money=200;
    private int game_money=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);


        ImageButton button1 = (ImageButton) findViewById(R.id.ballin);
        button1.setOnClickListener(this);
        ImageButton button2 = (ImageButton) findViewById(R.id.bdeal);
        button2.setOnClickListener(this);
        ImageButton button3 = (ImageButton) findViewById(R.id.breset);
        button3.setOnClickListener(this);
        ImageButton button4 = (ImageButton) findViewById(R.id.b5);
        button4.setOnClickListener(this);
        ImageButton button5 = (ImageButton) findViewById(R.id.b50);
        button5.setOnClickListener(this);
        ImageButton button6 = (ImageButton) findViewById(R.id.b10);
        button6.setOnClickListener(this);
        ImageButton button7 = (ImageButton) findViewById(R.id.b1);
        button7.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        TextView totalmoney= (TextView) findViewById(R.id.totalmoney);
        TextView gamemoney= (TextView) findViewById(R.id.gamemoney);
        ImageView image = (ImageView) findViewById(R.id.bmycoin);

        if (view.getId() == R.id.ballin ) {
            total_money+= game_money;
            game_money=0;
            if(total_money>0) {
                game_money = total_money;
                total_money = 0;
                image.setImageResource(0);
                Intent intent = new Intent(this, Blackjack_Play.class);
                intent.putExtra(SGameMoney, game_money);
                intent.putExtra(STotalMoney, total_money);
                startActivityForResult(intent, REQUEST_CODE_ADD);

            } else {
                Toast.makeText(this,"You do not have enough money!", Toast.LENGTH_SHORT). show();}

        } else if (view.getId() == R.id.bdeal) {
            if ((game_money!=0)){
                image.setImageResource(0);
                Intent intent = new Intent(this, Blackjack_Play.class);
                intent.putExtra(SGameMoney, game_money);
                intent.putExtra(STotalMoney,total_money);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }else {
                Toast.makeText(this,"You need to bet!", Toast.LENGTH_SHORT). show();}

        } else if (view.getId() == R.id.breset) {
            total_money+= game_money;
            game_money=0;
            image.setImageResource(0);

        } else if (view.getId() == R.id.b5 && total_money>=5) {

            image.setImageResource(R.drawable.five);
            total_money=total_money-5;
            game_money=game_money+5;
        } else if (view.getId() == R.id.b50 && total_money>=50) {
            image.setImageResource(R.drawable.fifty);
            total_money=total_money-50;
            game_money=game_money+50;
        } else if (view.getId() == R.id.b10 && total_money>=10) {
            image.setImageResource(R.drawable.ten);
            total_money=total_money-10;
            game_money=game_money+10;
        } else if (view.getId() == R.id.b1&& total_money>=1) {
            image.setImageResource(R.drawable.one);
            total_money=total_money-1;
            game_money=game_money+1;
        }
        else {
            Toast.makeText(this,"You do not have enough money!", Toast.LENGTH_SHORT). show();}

        if (game_money!=0){
            gamemoney.setText("" + game_money);
        }else{
            gamemoney.setText(null);
        }
        totalmoney.setText("" + total_money);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ADD) {


            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled ", Toast.LENGTH_SHORT).show();
                return;
            } else if (resultCode == RESULT_OK) {

                String t_money = data.getStringExtra(STotalMoney);
                String g_money = data.getStringExtra(SGameMoney);
                TextView totalmoney= (TextView) findViewById(R.id.totalmoney);
                TextView gamemoney= (TextView) findViewById(R.id.gamemoney);

                totalmoney.setText("" + t_money);
                gamemoney.setText(""+ g_money);



                total_money= Integer.parseInt(t_money);
                game_money= Integer.parseInt(g_money);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
