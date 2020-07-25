package com.example.contactlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactlist.R;
import com.example.contactlist.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        private Context context;
        private List<Contact> ContactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.ContactList = contactList;
    }

    @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_contact,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            Contact contact= ContactList.get(position);
            holder.PhoneNumber.setText(contact.getPhoneNumber());
            holder.contactName.setText(contact.getName());

        }


        @Override
        public int getItemCount() {
            return ContactList.size() ;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView contactName;
            public TextView PhoneNumber;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                contactName= itemView.findViewById(R.id.Name);
                PhoneNumber= itemView.findViewById(R.id.Phone_Number);
            }
        }
    }
