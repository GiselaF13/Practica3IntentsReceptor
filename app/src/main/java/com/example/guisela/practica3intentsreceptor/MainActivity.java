package com.example.guisela.practica3intentsreceptor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    String texto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        Intent intent = getIntent();

        String action = intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null)
        {
            if("text/plain".equals(type))
            {
                texto = texto + intent.getStringExtra(Intent.EXTRA_TEXT);
                manipularText(intent);
            }
        }
    }

    private void manipularText(Intent intent)
    {
        if(texto != null)
        {
            mTextMessage.setText("PEDIDO:" + "\n" + "\n" + " - " + texto);
        }
    }
}
