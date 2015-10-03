package com.pes.gkl.gate;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.pes.gkl.gate.Fragments.RandomQuestionFragment;
import com.pes.gkl.gate.Fragments.StatsFragment;
import com.pes.gkl.gate.Fragments.TestFragment;
import com.pes.gkl.gate.Fragments.TopicFragment;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;


public class MainActivity extends MaterialNavigationDrawer {

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    String user;
    String pass;

    MaterialAccount account;
    MaterialSection target;

    @Override
    public void init(Bundle savedInstanceState) {

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        user = prefs.getString("user", "not");//"No name defined" is the default value.
        pass = prefs.getString("pass", "not");

        account = new MaterialAccount(this.getResources(),"Girish",user,R.drawable.giri3, R.drawable.gategarden);
        this.addAccount(account);

        //MaterialAccount account2 = new MaterialAccount(this.getResources(),"Hatsune Miky","hatsune.miku@example.com",R.drawable.photo2,R.drawable.mat2);
        //this.addAccount(account2);

        //MaterialAccount account3 = new MaterialAccount(this.getResources(),"Example","example@example.com",R.drawable.photo,R.drawable.mat3);
        //this.addAccount(account3);

        // create sections
        this.addSection(newSection("Random Test", new RandomQuestionFragment()).setSectionColor(Color.CYAN));
        this.addSection(newSection("Topic-wise Questions",new TopicFragment()).setSectionColor(Color.RED));
        target = newSection("Stats",new StatsFragment()).setSectionColor(Color.parseColor("#9c27b0"));
        this.addSection(target);
        //this.addSection(newSection("Section",R.drawable.ic_arrow_drop_up_white_24dp,new TestFragment()).setSectionColor(Color.parseColor("#03a9f4")));

        enableToolbarElevation();

        thread.start();
    }


    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    removeAccount(account);
//                    notifyAccountDataChanged();
//                    removeSection(target);
                    setSection(target);
                }
            });
        }
    });

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
        else {
            getFragmentManager().popBackStack();
        }
    }
}
