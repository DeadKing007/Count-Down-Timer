package dead.countdowntimer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.WallpaperManager;
import android.content.Intent;
import android.service.wallpaper.WallpaperService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button wall=findViewById(R.id.wall);

        wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WallpaperManager wm=WallpaperManager.getInstance(Main2Activity.this);
                try {
                    wm.setResource(R.raw.images);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        Button alarm=findViewById(R.id.alarm);

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Main2Activity.this,MyService.class);

              /*  PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),1,intent,0);


                AlarmManager am= (AlarmManager) getSystemService(ALARM_SERVICE);

                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+7000,pendingIntent);
*/
                startService(intent);
                Toast.makeText(Main2Activity.this, "Alarm set for 7 sec", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
