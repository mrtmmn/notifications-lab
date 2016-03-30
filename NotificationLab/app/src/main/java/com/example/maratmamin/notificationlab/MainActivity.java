package com.example.maratmamin.notificationlab;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            builder.setSmallIcon(android.R.drawable.presence_offline);
            builder.setContentTitle("No Network Connection");
            builder.setContentText("Press on Notification to Resolve the Issue");

            Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), notificationIntent, 0);
            builder.setContentIntent(pendingIntent);

            NotificationCompat.BigPictureStyle notiStyle = new
                    NotificationCompat.BigPictureStyle();
            notiStyle.setBigContentTitle("Big Picture Expanded");
            notiStyle.setSummaryText("Nice big picture.");

            

    private void networkAvailable() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.common_ic_googleplayservices)).build();
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.common_ic_googleplayservices);
        mBuilder.setContentTitle("Network Not Connected Alert!");
        mBuilder.setContentText("You do not have IT connectivity");
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigPictureStyle);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify("NOTIFICATION_NOT_AVAILABLE", mBuilder.build());
    }

    private void networkNotAvailable() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.common_ic_googleplayservices)).build();
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.common_ic_googleplayservices);
        mBuilder.setContentTitle("Network Connected Alert!");
        mBuilder.setContentText("You have IT connectivity");
        mBuilder.setContentIntent(pIntent);
        mBuilder.setStyle(bigPictureStyle);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify("NOTIFICATION_AVAILABLE", mBuilder.build());
    }
}