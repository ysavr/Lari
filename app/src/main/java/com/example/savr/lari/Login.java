package com.example.savr.lari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.savr.lari.fragment.HomeFragment;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText etData1 = (EditText) findViewById(R.id.username);
        final EditText etData2 = (EditText) findViewById(R.id.email);
        final EditText etData3 = (EditText) findViewById(R.id.password);
        Button signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                intent.putExtra("user",etData1.getText().toString());
                intent.putExtra("email",etData2.getText().toString());
                intent.putExtra("password",etData3.getText().toString());
                startActivity(intent);
            }
        });
    }
}
