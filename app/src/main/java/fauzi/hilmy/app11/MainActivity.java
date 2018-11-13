package fauzi.hilmy.app11;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import fauzi.hilmy.app11.helper.Client;
import fauzi.hilmy.app11.helper.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.wang.avi.AVLoadingIndicatorView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    //    AVLoadingIndicatorView loadingIndicatorView;
    List<Quotee> dataItems = new ArrayList<>();
    RecyclerView recyclerView;
    Context mContext;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
//        loadingIndicatorView = findViewById(R.id.load);
//        loadingIndicatorView.setIndicator("LineSpinFadeLoaderIndicator");

        progressBar = findViewById(R.id.progress);
        loadJson();
    }

    public void loadJson() {
        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadTeamCall = serviceAPI.readQuoteArray();

        loadTeamCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                try {

                    String teamString = response.body().toString();

                    Type listType = new TypeToken<List<Quotee>>() {
                    }.getType();
                    dataItems = getTeamListFromJson(teamString, listType);
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(new QuoteAdapter(MainActivity.this, dataItems));
                    recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

                    // Sorting recipe in alphabetical order which UI test was done upon
                    // Collections.sort(recipes, Recipe.BY_NAME_ALPHABETICAL);


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

                Log.d("onFailure", t.toString());

            }

        });
    }

    public static <T> List<T> getTeamListFromJson(String jsonString, Type type) {
        if (!isValid(jsonString)) {
            return null;
        }
        return new Gson().fromJson(jsonString, type);
    }

    public static boolean isValid(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }

    public void copyText(TextView texttitle, TextView textContent) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        String Copytitle, copycontent;

        Copytitle = texttitle.getText().toString();
        copycontent = textContent.getText().toString();
        if (Copytitle.length() != 0) {
            if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {

                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboard.setText(Copytitle + " Said: '" + copycontent + "'");
                Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();

            } else {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", Copytitle + " Said: '" + copycontent + "'");
                Toast.makeText(getApplicationContext(), "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();
                clipboard.setPrimaryClip(clip);
            }
        } else {
            Toast.makeText(getApplicationContext(), "Nothing to Copy", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this, FirstActivity.class));
        super.onBackPressed();
    }
}
