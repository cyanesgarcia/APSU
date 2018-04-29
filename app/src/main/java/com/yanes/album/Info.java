package com.yanes.album;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.res.*;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claud on 4/27/2018.
 */

public class Info extends ListActivity {
    private DBDataSource dbDataSource;
    private AlertDialog dialog;
    private String card_key="  ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbDataSource = new DBDataSource(getApplicationContext());

    }

    @Override
    protected void onStart() {
        super.onStart();
        dbDataSource.open();
        List<Album> people = dbDataSource.getAll();
        ArrayAdapter<Album> adapter = new ArrayAdapter<Album>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1, people);
        setListAdapter(adapter);
        final ListView listView = getListView();
        listView.setBackgroundColor(Color.parseColor("#4597CD"));

    }

    @Override
    protected void onListItemClick(ListView l, View v, final int position, long id) {
        super.onListItemClick(l, v, position, id);

        dialog = new AlertDialog.Builder(this).create();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ArrayAdapter adapter = (ArrayAdapter<Album>) getListAdapter();
        final Album fin = (Album) adapter.getItem(position);
        final ArrayList<String> check = null;

        dialog.setTitle("Do you want to buy this card?");
        dialog.setButton("Yes", new DialogInterface.OnClickListener(){


                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
for(int ii=0; ii<check.size();ii++){
    if(fin.getName() == check.get(ii)){
        card_key="Have it";
        break;
    }else{
        card_key="  ";
    }
}

                     if(MainActivity.total>=5 || card_key.equals("Have it")){
    if(!card_key.equals("Have it")) {


        check.add(fin.getName());
        MainActivity.total -= 5;
    }else{
        card_key="  ";
    }

                             builder.setMessage(Html.fromHtml("<html>" + "<p><b>Name: </b>" + fin.getName()+"</p>" + "<p><b>State: </b>" + fin.getState()+"</p>" +
                                     "<p><b>Type: </b>" + fin.getType()+"</p>" + "<p><b>Description: </b>" + fin.getDescription() +"</p>" +"</html>"));
                             builder. setTitle("Info");
                             builder.create().show();

                     }else{
                         Toast.makeText(getApplicationContext(),"You do not have enough coins",Toast.LENGTH_LONG).show();
                             builder.setMessage(Html.fromHtml("<html>" + "<p><b>Name: ????</b>" +"</p>" + "<p><b>State: ????</b>" + "</p>" +
                                     "<p><b>Type: ????</b>"+"</p>" + "<p><b>Description: ????</b>" +"</p>" +"</html>"));
                             builder. setTitle("Info");
                             builder.create().show();
                         }
                     }


                });
                dialog.setButton2("No",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                card_key="Cancel";

                            }
                        });
                dialog.show();



    }
    @Override
    protected void onStop() {
        super.onStop();
        dbDataSource.close();
    }



}
