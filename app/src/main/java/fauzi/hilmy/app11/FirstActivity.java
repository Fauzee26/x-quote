package fauzi.hilmy.app11;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    Button button;
    FloatingActionButton fab;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        button = findViewById(R.id.buttonn);
        fab = findViewById(R.id.about);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this, MainActivity.class));
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.about);
                dialog.setTitle("About xQuote");
                CardView cardViewApp = (CardView) dialog.findViewById(R.id.aboutApp);
                CardView cardViewDeveloper = (CardView) dialog.findViewById(R.id.aboutDeveloper);
                cardViewApp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(FirstActivity.this, AboutApp.class));
                    }
                });
                cardViewDeveloper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(FirstActivity.this, AboutDeveloper.class));
                    }
                });
                dialog.show();
            }
        });
    }
}
