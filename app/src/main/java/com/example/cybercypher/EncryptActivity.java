package com.example.cybercypher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cybercypher.CyberCypher;

public class EncryptActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecrypt);
        ((Button)findViewById(R.id.buttonEncrypt)).setOnClickListener(new Encrypt());
    }

    class Encrypt implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            TextView outputText = (TextView)findViewById(R.id.encryptedText);
            try
            {
                outputText.setText(CyberCypher.EncryptClayton(((EditText) findViewById(R.id.editTextEncrypt)).getText().toString(), MainActivity.key));
            }
            catch(IllegalArgumentException e)
            {
                Context context = getApplicationContext();
                CharSequence text = "Key is formatted incorrectly";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 200);
                toast.show();
            }
        }
    }

}