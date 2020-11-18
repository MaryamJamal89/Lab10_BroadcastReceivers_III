package com.example.lab10_broadcastreceivers_iii;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getStringExtra("msg");
        Toast.makeText(context, "The text: : " + result, Toast.LENGTH_SHORT).show();
    }
}
