package com.example.android.selfmessages;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Message> messagesArray;
    static int item_position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesArray = new ArrayList<>();

        android.support.v4.app.FragmentTransaction fr =
                getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.messageFrame, new HomeFragment()).commit();
    }

}
