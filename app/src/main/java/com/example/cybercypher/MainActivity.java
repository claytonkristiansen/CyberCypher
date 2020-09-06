package com.example.cybercypher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.cybercypher.EncryptActivity;

public class MainActivity extends AppCompatActivity
{


    Integer i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button)).setOnClickListener(new OpenEncrypt());
        ((Button)findViewById(R.id.button2)).setOnClickListener(new OpenDecrypt());

    }

    class OpenEncrypt implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            StartNewActivity(EncryptActivity.class);
        }
    }

    class OpenDecrypt implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            StartNewActivity(DecryptActivity.class);
        }
    }

    private void StartNewActivity(Class activity)
    {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }


}