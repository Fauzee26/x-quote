package fauzi.hilmy.app11;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutDeveloper extends AppCompatActivity {

    CircleImageView circleImageView;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);
        setinit();

        circleImageView.setImageResource(R.drawable.fauzi);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        GridRecycler gridRecycler = new GridRecycler();
        recyclerView.setAdapter(gridRecycler);
    }

    String[] nama = {"Facebook", "Instagram", "Line", "Wordpress", "Github", "Linkedin"};
    String[] link = {"https://www.facebook.com/hilmy.fauzi26", "https://www.instagram.com/hill.fauzi/", "http://line.me/ti/p/bDTpen3_AJ", "https://hilmyfauzi26.wordpress.com/", "https://github.com/Fauzee26", "https://www.linkedin.com/in/hilmy-fauzi-batam26/"};
    int[] gambar = {R.drawable.facebook, R.drawable.instagram, R.drawable.line, R.drawable.wordpress, R.drawable.github, R.drawable.linkedin};

    private void setinit() {
        recyclerView = findViewById(R.id.recyclerrr);
        circleImageView = findViewById(R.id.profilee);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AboutDeveloper.this, FirstActivity.class));
        super.onBackPressed();
    }

    private class GridRecycler extends RecyclerView.Adapter<GridRecycler.GridHolder> {
        @Override
        public GridRecycler.GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
            return new GridHolder(view);
        }

        @Override
        public void onBindViewHolder(GridRecycler.GridHolder holder, final int position) {
            holder.imageView.setImageResource(gambar[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link[position]));
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return nama.length;
        }

        class GridHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            GridHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.gambarr);
            }
        }
    }
}
