package fauzi.hilmy.app11;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26FaUZeE02 on 4/26/18.
 */

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.MyViewHolder> {

    private Context context;
    private List<Quotee> arrayList;
    private MainActivity mainActivity;

    public QuoteAdapter(MainActivity mainActivity, List<Quotee> arrayList) {
        this.mainActivity = mainActivity;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Quotee quotee = arrayList.get(position);
        holder.txtTitle.setText(Html.fromHtml(quotee.getTitlee()));
        holder.txtContent.setText(Html.fromHtml(quotee.getContent()));
        holder.btnSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(quotee.getLink()));
//                mainActivity.startActivity(intent);
                mainActivity.copyText(holder.txtTitle, holder.txtContent);
            }
        });

        holder.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.loadJson();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtContent;
        Button btnSource, btnNext;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtContent = itemView.findViewById(R.id.txtContent);
            btnSource = itemView.findViewById(R.id.btnSource);
            btnNext = itemView.findViewById(R.id.btnNext);

        }
    }
}
