package com.kruma.kanta.service;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.kruma.kanta.MainActivity;
import com.kruma.kanta.R;

/**
 * Created by JORDY on 28/03/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "KANTAPE";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();

        Log.d(TAG, "Mensaje recibido de : " + from);

        if (remoteMessage.getNotification() != null) {

            Log.d(TAG, "NOTIFICACION RECIBIDA");
            String str_Body = "";
            String str_Title = "";
            String str_IdTipoNotificacion = "";
            if(remoteMessage.getNotification().getBody() != null)
                str_Body = remoteMessage.getNotification().getBody();
            if(remoteMessage.getNotification().getTitle() != null)
                str_Title = remoteMessage.getNotification().getTitle();

            if(remoteMessage.getData().get("IdTipoNotificacion") != null)
                str_IdTipoNotificacion = remoteMessage.getData().get("IdTipoNotificacion");


            Log.d(TAG, str_Body);
            Log.d(TAG, str_Title);
            Log.d(TAG, str_IdTipoNotificacion);

            //Opcional: mostramos la notificación en la barra de estado
            showNotification(str_Title, str_Body, str_IdTipoNotificacion);
        }

    }

    private void showNotification(String title, String body, String str_IdTipoNotificacion) {


        if(str_IdTipoNotificacion.equals("1")){

            //Context context = getApplicationContext();

            //final Service activity = this;

            Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
            intent.putExtra("Logeado",com.kruma.core.security.SecurityManager.getUsuario());
            intent.putExtra("ID_FIREBASE_MESSAGING", "1");

            PendingIntent pendingIntent = PendingIntent.getActivity(this.getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
            Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(this.getApplicationContext())
                    .setSmallIcon(R.drawable.iconomiperfil)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setSound(soundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());



        } else if(str_IdTipoNotificacion.equals("2")){

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("Logueado",com.kruma.core.security.SecurityManager.getUsuario());
            intent.putExtra("ID_FIREBASE_MESSAGING", "2");

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
            Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.iconomesaguion)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setSound(soundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());



        }else if(str_IdTipoNotificacion.equals("3")){

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
            intent.putExtra("Logeado",com.kruma.core.security.SecurityManager.getUsuario());
            intent.putExtra("ID_FIREBASE_MESSAGING", "3");


            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
            Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.iconocanciones)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setSound(soundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());



        }else if(str_IdTipoNotificacion.equals("4")){

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
            intent.putExtra("Logeado",com.kruma.core.security.SecurityManager.getUsuario());
            intent.putExtra("ID_FIREBASE_MESSAGING", "4");

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
            Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.iconomicro)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setSound(soundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());



        }
        else {
            Intent intent = new Intent(this, MainActivity.class);
            //intent.putExtra("Logeado", Constante.TXT_USUARIO_LOGEADO);
            intent.putExtra("Logeado",com.kruma.core.security.SecurityManager.getUsuario());
            intent.putExtra("ID_FIREBASE_MESSAGING", "5");

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

            Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.iconomiperfil)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setSound(soundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());

        }


    }



}