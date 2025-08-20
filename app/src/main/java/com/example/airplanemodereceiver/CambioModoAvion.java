package com.example.airplanemodereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class CambioModoAvion extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean modoAvion = intent.getBooleanExtra("state", true);

            if (modoAvion) {
                Toast.makeText(context, "Modo avión activado", Toast.LENGTH_SHORT).show();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2664553747"));
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);
            }
//            if (modoAvion) {
//                Toast.makeText(context, "Modo avión activado", Toast.LENGTH_SHORT).show();
//                realizarLlamada(context);
//            } else {
//                Toast.makeText(context, "Modo avión desactivado", Toast.LENGTH_SHORT).show();
//            }
        }
    }

    private void realizarLlamada(Context context) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:123456789"));
        context.startActivity(intent);
    }

}
