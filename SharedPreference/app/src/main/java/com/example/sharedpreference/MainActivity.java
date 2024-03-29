package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Uedit,eedit;
    Button button;
    SharedPreferences share;

    private static final String SHARED_PREF_NAME="preference";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uedit=findViewById(R.id.Uedit);
        eedit=findViewById(R.id.eedit);
        button=findViewById(R.id.button);

        share=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = share.getString(KEY_NAME,null);
        if(name != null){
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);

            }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = share.edit();
                editor.putString(KEY_NAME,Uedit.getText().toString());
                editor.putString(KEY_EMAIL,eedit.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_SHORT).show();



            }
        });
    }
}