package com.example.contactlist;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactlist.Data.DatabaseHandler;
import com.example.contactlist.adapter.RecyclerViewAdapter;
import com.example.contactlist.model.contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  //  private ListView listView;
      private RecyclerView recyclerView;
      private RecyclerViewAdapter recyclerViewAdapter;
      private ArrayList<contact> contactArrayList;
  //  private ArrayAdapter<String> arrayAdapter;
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  listView = findViewById(R.id.listview);
          recyclerView=findViewById( R.id.RecyclerView);
          recyclerView.setHasFixedSize(true);
          recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactArrayList = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        db.addContact(new contact("ABC","6131464332"));
        db.addContact(new contact("LMN","0945458765"));
        db.addContact(new contact("Rajesh","9698639468"));
        db.addContact(new contact("Dinesh","7200232567"));
        db.addContact(new contact("Lokesh","9790415413"));

        List<contact> contactList = db.getAllContacts();

        for (contact contact : contactList) {
            Log.d("MainActivity", "onCreate: " + contact.getName());
            contactArrayList.add(contact);
        }

        //create array adapter
        recyclerViewAdapter =new RecyclerViewAdapter(MainActivity.this,contactList);
         recyclerView.setAdapter(recyclerViewAdapter);

    }

}
