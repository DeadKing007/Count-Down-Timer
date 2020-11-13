package dead.countdowntimer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button Start,Stop;
    CountDownT timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        Start=findViewById(R.id.Start);
        Stop=findViewById(R.id.Stop);

        timer=new CountDownT(1000,1000);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                textView.setText("Start");
            }
        });


    }

    public class CountDownT extends CountDownTimer{

        public CountDownT(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            textView.setText(" "+l/1000);

        }

        @Override
        public void onFinish() {
            textView.setText("Finished");
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);

        }
    }
}
