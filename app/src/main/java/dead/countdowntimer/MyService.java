package dead.countdowntimer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      //  Toast.makeText(getApplicationContext(), "Alarm running", Toast.LENGTH_SHORT).show();
        Log.d("help","fhudjkmfl");
        ((Vibrator)getSystemService(Context.VIBRATOR_SERVICE)).vibrate(4000);

        Uri uri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        final Ringtone r=RingtoneManager.getRingtone(getApplicationContext(),uri);
        r.play();
      //  sendNotifiaction(r, context);
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


        return START_NOT_STICKY;
    }
}
