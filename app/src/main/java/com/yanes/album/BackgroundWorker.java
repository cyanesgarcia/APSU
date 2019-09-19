package com.yanes.album;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by claud on 5/12/2018.
 */

public class BackgroundWorker extends AsyncTask<String, Void, String> {
    static int entrar=0;
    Context context;
    AlertDialog alertDialog;
    String check1;
    String type=" ";
    public String getCheck1() {
        return check1;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }




    BackgroundWorker(Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String... voids) {
        type = voids[0];
        String login_url = "http://lidiayanesgarcia.000webhostapp.com/login.php";
        String register_url = "http://lidiayanesgarcia.000webhostapp.com/register.php";
        Log.i("eeeee4","e");
        if(type.equals("login")){
            try {
                Log.i("eeeee5","e");
                String user_name = voids[1];
                String password = voids[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8")+"="+ URLEncoder.encode(user_name, "UTF-8")+"&"
                        + URLEncoder.encode("password", "UTF-8")+"="+ URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result ="";
                String line ="";
                while((line = bufferedReader.readLine())!= null){
                    result += line;
                }

                if(result.equals("login not success")){
                    Log.i("1111", "YES");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(type.equals("register")){
            try {
                Log.i("eeeee6","e");
                String name = voids[1];
                String surname = voids[2];
                String age = voids[3];
                String username = voids[4];
                String password = voids[5];

                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();


                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("name", "UTF-8")+"="+ URLEncoder.encode(name, "UTF-8")+"&"
                        + URLEncoder.encode("surname", "UTF-8")+"="+ URLEncoder.encode(surname, "UTF-8")+"&"
                        + URLEncoder.encode("age", "UTF-8")+"="+ URLEncoder.encode(age, "UTF-8")+"&"
                        + URLEncoder.encode("username", "UTF-8")+"="+ URLEncoder.encode(username, "UTF-8")+"&"
                        + URLEncoder.encode("password", "UTF-8")+"="+ URLEncoder.encode(password, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result ="";
                String line ="";
                while((line = bufferedReader.readLine())!= null){
                    result += line;
                }
                Log.i("dddddddd", "entra"+ result);
                    if(result.equals(" Insert Successful")){

                        entrar = 1;
                        Log.i("dddddddd", "entra"+  entrar);

                    }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {

            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Login Status");
            Log.i("probar", "1");

    }
public void post(Activity a2){
        Log.i("hola", "hola");
    if (login_page.check.equals("Yes") && type.equals("login")) {

            a2.startActivity(new Intent(a2, MainActivity.class));
        }else if(type.equals("register")){

        a2.startActivity(new Intent(a2, login_page.class));

    }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i("String1", "s " +result);
        if(type.equals("login")) {
            if (result != null) {
                Log.i("String12", "s " + result);


                    if (!result.equals(" login not success")) {
                        login_page.check = "Yes";
                        setCheck1("Yes");

                    } else {
                        login_page.check = "No";
                        setCheck1("No");
                    }

                    Log.i("resulttttt", " " + result);
                    alertDialog.setMessage(result);

                alertDialog.show();

                post(login_page.a);
            } else {
                alertDialog.setMessage("The server is inactive, it will wake up in less than 1 hour");
                alertDialog.show();
            }


        }else if (type.equals("register")){
            if(entrar == 1) {
                entrar = 0;
                alertDialog.setTitle("Register Status");
                alertDialog.setMessage("Register success");
                alertDialog.show();
                Log.i("Registrado", " ");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        post(login_page.a);
                    }
                }, 800);


            }else{
                alertDialog.setTitle("Register Status");
                alertDialog.setMessage("Register not success");
                alertDialog.show();
            }


        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);

    }


}
