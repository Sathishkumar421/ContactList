package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contactlist.Data.DatabaseHandler;
import com.example.contactlist.model.Contact;

public class AddContact extends AppCompatActivity {

    private Button add;
    private Button cancel;
    private EditText name,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        add= findViewById(R.id.add);
        cancel= findViewById(R.id.cancel);
        name= findViewById(R.id.editTexName);
        number= findViewById(R.id.editTextPhone);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String contactName = name.getText().toString().trim();
                String contactNumber = number.getText().toString().trim();

                if ((contactName.isEmpty()) || (contactNumber.isEmpty()))
                {
                    Toast.makeText(AddContact.this, "Enter Name and Phone Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    DatabaseHandler db = new DatabaseHandler(AddContact.this);
                    db.addContact(new Contact((contactName.toString().trim()), contactNumber.toString().trim()));
                    Intent intent = getIntent();
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }
}