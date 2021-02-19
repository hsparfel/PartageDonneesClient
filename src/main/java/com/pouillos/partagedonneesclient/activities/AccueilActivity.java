package com.pouillos.partagedonneesclient.activities;

import android.app.ActivityManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.pouillos.partagedonneesclient.R;
import com.pouillos.partagedonneesclient.entities.Donnees;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AccueilActivity extends NavDrawerActivity {

    Uri CONTENT_URI = Uri.parse("content://com.pouillos.partagedonneesfournisseur.provider/donnees");

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Stetho.initializeWithDefaults(this);

        this.configureToolBar();

        ButterKnife.bind(this);

        setTitle("Accueil Client");

     //   ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        //  boolean isActivityFound = false;


        //  activityManager.getAppTasks();

        //  List<ActivityManager.RunningAppProcessInfo> procInfos = activityManager.getRunningAppProcesses();
        //  for (int i = 0; i < procInfos.size(); i++) {
        //       if (procInfos.get(i).processName.equals("com.pouillos.partagedonneesfournisseur")) { //ici le nom du package recherché
        //          isActivityFound = true;
        //          continue;
        //     }
        //  }

        //   if (!isActivityFound) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.pouillos.partagedonneesfournisseur");
            if (launchIntent != null) {
                startActivity(launchIntent);//null pointer check in case package name was not found

                     }
                //   }
                   try {
                       Thread.sleep(2000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
            Intent frontIntent = getPackageManager().getLaunchIntentForPackage("com.pouillos.partagedonneesclient");
        frontIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(frontIntent,0);
        //try {
       /* List<Donnees> listAllDonnees = recupererAllDonneesFromFournisseur();

        textView.setText(listAllDonnees.get(0).toString());
        textView2.setText(listAllDonnees.get(1).toString());
        textView3.setText(listAllDonnees.get(2).toString());*/
    //    } catch(Exception e) {
        //    Log.i("exception: ","app fournisseur not started");
       // }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Donnees> listAllDonnees = recupererAllDonneesFromFournisseur();

        textView.setText(listAllDonnees.get(listAllDonnees.size()-1).toString());
        textView2.setText(listAllDonnees.get(listAllDonnees.size()-2).toString());
        textView3.setText(listAllDonnees.get(listAllDonnees.size()-3).toString());


        for (int i = 0;i<listAllDonnees.size();i++){
            if (donneesDao.load(listAllDonnees.get(i).getId()) == null) {
                donneesDao.insert(listAllDonnees.get(i));
            }
        }



    }

    public void majDatas(View view) {
        List<Donnees> listAllDonnees = recupererAllDonneesFromFournisseur();

        textView.setText(listAllDonnees.get(0).toString());
        textView2.setText(listAllDonnees.get(1).toString());
        textView3.setText(listAllDonnees.get(2).toString());
    }

    public List<Donnees> recupererAllDonneesFromFournisseur() {
        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
        List<Donnees> myList = new ArrayList<Donnees>();

        while(cursor.moveToNext()) {
            myList.add(new Donnees((long) cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("nom"))));
        }
        cursor.close();
        return myList;
    }
}
