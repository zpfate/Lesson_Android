package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager manager;
    Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createToolBar();
    }


    /// toolbar
    public void createToolBar() {
        setContentView(R.layout.tool_bar);
        Toolbar toolBar = findViewById(R.id.tool_bar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("zpfate","toolBar被点击了");
            }
        });
    }

    /// 创建通知
    public void  createNotification() {
        setContentView(R.layout.activity_main);
        /// 创建通知中心管理类
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    "channelId", "测试通知", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(notificationChannel);
        }


        Intent intent = new Intent(this, NotificationActivity.class);
        intent.setPackage(getPackageName());
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        notification = new NotificationCompat.Builder(this, "channelId")
                .setContentTitle("官方通知")
                .setContentText("世界那么大，想去看看")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.test))
                .setSmallIcon(R.drawable.ic_baseline_4k_24)
                .setColor(Color.parseColor("#ff0000"))
                /// 点击事件
                .setContentIntent(pendingIntent)
                /// 点击自动取消
//                .setAutoCancel(true)
                .build();
    }

    public void sendNotification(View view) {
        manager.notify(1, notification);
    }

    public void cancelNotification(View view) {
        manager.cancel(1);
    }
}