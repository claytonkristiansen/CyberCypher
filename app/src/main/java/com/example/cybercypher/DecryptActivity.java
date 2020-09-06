package com.example.cybercypher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecryptActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        ((Button)findViewById(R.id.buttonDecrypt)).setOnClickListener(new Decrypt());
    }

    class Decrypt implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            TextView outputText = (TextView)findViewById(R.id.decryptedText);
            outputText.setText(CyberCypher.DecryptClayton(((EditText)findViewById(R.id.editTextDecrypt)).getText().toString(), MainActivity.key));
        }
    }
}