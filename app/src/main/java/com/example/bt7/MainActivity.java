package com.example.bt7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Contact> ds;
    ArrayAdapter<Contact> adapter;
    Boolean kt=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        showContact();

    }

    private void showContact(){
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        ds.clear();
        while (cursor.moveToNext()){
            String cotName = ContactsContract.Contacts.DISPLAY_NAME;
            String cotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vitriName = cursor.getColumnIndex(cotName);
            int vitriPhone = cursor.getColumnIndex(cotPhone);
            String name = cursor.getString(vitriName);
            String phone = cursor.getString(vitriPhone);
            Contact contact = new Contact(name,phone);
            ds.add(contact);
            adapter.notifyDataSetChanged();

        }
    }

    private void addControls(){
        lv = findViewById(R.id.lv);
        ds = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_list_item_1,ds
        );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(MainActivity.this,Detail.class);
                    intent.putExtra("ten",ds.get(i).getName());
                    intent.putExtra("sdt",ds.get(i).getPhone());
                    if (kt!=true)
                        startActivity(intent);
                    kt=false;
                }
        });
    }
    


}
