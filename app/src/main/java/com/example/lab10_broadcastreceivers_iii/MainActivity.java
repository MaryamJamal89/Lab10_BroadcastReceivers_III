package com.example.lab10_broadcastreceivers_iii;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button broadcat;
    EditText link;
    BroadcastReceiver receiver;
    private IntentFilter intentFilter;
    final MyReceiver myrec = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcat = (Button)findViewById(R.id.broadcat);
        link = (EditText)findViewById(R.id.link);

        broadcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent();
                w.setAction(Intent.ACTION_VIEW);
                w.putExtra("msg",link.getText().toString());
                sendBroadcast(w);
            }
        });
    }

    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_VIEW);
        registerReceiver(myrec, intentFilter);
    }

    public void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

}
