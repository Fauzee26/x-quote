package fauzi.hilmy.app11;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.wang.avi.AVLoadingIndicatorView;

public class SplashScreen extends Activity {
    private AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator("BallPulseIndicator");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }
}
