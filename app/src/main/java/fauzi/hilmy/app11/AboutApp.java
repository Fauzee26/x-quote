package fauzi.hilmy.app11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        TextView textView = findViewById(R.id.aqw);
        textView.setSelected(true);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AboutApp.this, FirstActivity.class));
        super.onBackPressed();
    }
}
