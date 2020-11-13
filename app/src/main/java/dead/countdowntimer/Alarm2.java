package dead.countdowntimer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Alarm2 extends BroadcastReceiver {

    private static final int REQuest_code =10001 ;

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Alarm running", Toast.LENGTH_SHORT).show();
        ((Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE)).vibrate(4000);

        Uri uri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        final Ringtone r=RingtoneManager.getRingtone(context,uri);
        r.play();
        sendNotifiaction(r, context);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    r.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0);



    }
    private void sendNotifiaction(Ringtone r,Context context) {


        Intent implicitintent=new Intent(context,Main3Activity.class);
        //implicitintent.putExtra();
        PendingIntent intent=PendingIntent.getActivity(context,REQuest_code,implicitintent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);

        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        builder.setContentTitle("Alarm");
        builder.setContentText("Close Alarm");
        builder.setContentIntent(intent);

        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher));

        builder.setAutoCancel(true);//Automaticlly gets cancelled on click

        NotificationManager manager= (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(REQuest_code,builder.build());
    }
}
