package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by claud on 4/29/2018.
 */

public class Game extends Activity implements View.OnClickListener {
    Random rnd = new Random();
    private SoundPool soundPool;
    private Set<Integer> soundLoaded;
    int []bells={0, 0, 0, 0};
    int[] dcolor = {R.drawable.byellow, R.drawable.bblue, R.drawable.bred, R.drawable.bgreen};
    int[] dcoloroff = {R.drawable.byellowoff, R.drawable.bblueoff, R.drawable.bredoff, R.drawable.bgreenoff};
    int[] ids = {R.id.iyellow, R.id.iblue, R.id.ired, R.id.igreen};
    boolean repe = true;
    int start=0;
    ArrayList<Integer> sequence = new ArrayList<>();
    ArrayList<Integer> my_sequence = new ArrayList<>();
    int count;
    int count1=1;
    ImageButton im;
    boolean equal= true;

    int high_score = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        soundLoaded = new HashSet<Integer>();

        Button button = (Button) findViewById(R.id.bfstart);
        button.setOnClickListener(this);

    }
    private UpdateTask updateTask;

    @Override
    protected void onPause() {
        super.onPause();
        if (updateTask != null) {
            updateTask.cancel(true);
            updateTask = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        AudioAttributes.Builder attrBuilder= new AudioAttributes.Builder();
        attrBuilder.setUsage(AudioAttributes.USAGE_GAME);

        SoundPool.Builder spBuilder= new SoundPool.Builder();
        spBuilder.setAudioAttributes(attrBuilder.build());
        spBuilder.setMaxStreams(2);
        soundPool = spBuilder.build();

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if(status==0){
                    soundLoaded.add(sampleId);
                    Log.i("SOUND", "Sound loaded"+ sampleId);
                }else {
                    Log.i("SOUND", "Error cannot load sound status"+ status);

                }
            }
        });
        int bell= soundPool.load(this, R.raw.bell,1);
        int bell1= soundPool.load(this, R.raw.bell1,1);
        int bell2= soundPool.load(this, R.raw.bell2,1);
        int bell3= soundPool.load(this, R.raw.bell3,1);

        bells= new int[]{bell, bell1, bell2, bell3};

        ImageButton imageButton = (ImageButton) findViewById(R.id.iyellow);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.iblue);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.ired);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton) findViewById(R.id.igreen);
        imageButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bfstart && sequence.size()==my_sequence.size() && (start==0)) {
            sequence.clear();
            my_sequence.clear();
            start=1;
            if (updateTask != null && updateTask.getStatus() == AsyncTask.Status.FINISHED) {
                updateTask = null;
            }
            if (updateTask == null ) {
                updateTask = new UpdateTask();
                updateTask.execute();

            } else {
                Log.i("START", "task is already running");
            }
        } else if (view.getId() != R.id.bfstart && my_sequence.size()<sequence.size()&& (start==1) && updateTask.getStatus() == AsyncTask.Status.FINISHED) {
            int ii=0;
            if ((view.getId() == R.id.iyellow)) {
                ii=0;

            } else if ((view.getId() == R.id.iblue)) {
                ii=1;
            } else if ((view.getId() == R.id.ired)) {
                ii=2;
            } else if ((view.getId() == R.id.igreen)) {
                ii=3;
            }
            playSound(bells[ii]);
            final int iii=ii;
            my_sequence.add(iii);

            im= (ImageButton) findViewById(ids[iii]);
            im.setImageResource(dcolor[iii]);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    im= (ImageButton) findViewById(ids[iii]);
                    im.setImageResource(dcoloroff[iii]);
                }
            },500);

            if (my_sequence.size()==sequence.size()){
                compare();
            }
        }

    }
    private void playSound(int soundId){
        if(soundLoaded.contains(soundId)){
            soundPool.play(soundId, 1.0f, 1.0f, 0,0,1.0f);
        }
    }

    public void compare(){
        for (int a = 0; a < sequence.size(); a++) {
            if (!(my_sequence.get(a) == sequence.get(a))) {
                equal = false;
                break;
            }}

        TextView tv = (TextView) findViewById(R.id.text);

        if(equal==true){
            score++;
                high_score+=score;

            my_sequence.clear();

            tv.setText("Earn coins: "+ high_score);
            Toast.makeText(this, "Level "+ score, Toast.LENGTH_SHORT).show();

                count1++;



            updateTask = new UpdateTask();
            updateTask.execute();
        }else {
            Toast.makeText(this, "Lost", Toast.LENGTH_SHORT).show();


                count1 = 1;
            start=0;
            score=0;
            equal=true;
            sequence.clear();
            my_sequence.clear();

        }
    }

    class UpdateTask extends AsyncTask<Void,Integer,Void> {
        int i=0;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                Firstv();

            return null;

        }
        public void Firstv () {
            for (count = 0; count < count1; count++) {
                if (count == sequence.size() && repe == true) {

                    i = rnd.nextInt(4);
                    sequence.add(i);
                } else {
                    i = sequence.get(count);
                }
                publishProgress(i);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            if (repe == true) {
                playSound(bells[values[0]]);
                im= (ImageButton) findViewById(ids[values[0]]);
                im.setImageResource(dcolor[values[0]]);
                repe =false;
                count--;

            } else {
                im = (ImageButton) findViewById(ids[values[0]]);
                im.setImageResource(dcoloroff[values[0]]);
                repe = true;
            }
        }
    }

    @Override
    public void onBackPressed() {

        String str_high = Integer.toString(high_score);
        str_high = str_high.trim();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.Activity_KEY, str_high);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        onBackPressed();
        super.onStop();
    }
}
