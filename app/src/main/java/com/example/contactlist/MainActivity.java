package com.example.contactlist;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contactlist.Data.DatabaseHandler;
import com.example.contactlist.adapter.RecyclerViewAdapter;
import com.example.contactlist.model.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  //  private ListView listView;
      private RecyclerView recyclerView;
      private RecyclerViewAdapter recyclerViewAdapter;
      private ArrayList<Contact> contactArrayList;
  //  private ArrayAdapter<String> arrayAdapter;
    private int count;
    private FloatingActionButton addContact;
    private final int REQUEST_CODE=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  listView = findViewById(R.id.listview);
        addContact=findViewById(R.id.fabAdd);
        recyclerView=findViewById( R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactArrayList = new ArrayList<>();

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, AddContact.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }
    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode== REQUEST_CODE){
            Toast.makeText(MainActivity.this,"Back to MainActivity",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        List<Contact> contactList = db.getAllContacts();
        for (Contact contact : contactList) {
            Log.d("MainActivity", "onCreate: " + contact.getName());
            contactArrayList.add(contact);
        }

        //create array adapter
        recyclerViewAdapter =new RecyclerViewAdapter(MainActivity.this,contactList);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
