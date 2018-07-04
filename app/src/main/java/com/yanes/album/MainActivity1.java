package com.yanes.album;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

public class MainActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity1.this);
        View mView = getLayoutInflater().inflate(R.layout.customdialog, null);


        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

    }
    public void onCardClick(View view)
    {

        flipCard();


    }

    private void flipCard()
    {
        View rootLayout = (View) findViewById(R.id.main_activity_root);
        View cardFace = (View) findViewById(R.id.main_activity_card_face);
        View cardBack = (View) findViewById(R.id.main_activity_card_back);

        FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

        if (cardFace.getVisibility() == View.GONE)
        {
            flipAnimation.reverse();
        }
        rootLayout.startAnimation(flipAnimation);
    }
}
