package com.example.andriod.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }
    public static final String TAG = MyAdapter.class.getCanonicalName();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder viewHolder, int i) {

        final ListItem listItem = listItems.get(i);
        viewHolder.tvHeader.setText(listItem.getHead());
        viewHolder.tvDesc.setText(listItem.getDesc());
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestActivity.class);
                Log.i(TAG, "onClick: "+ listItem.getDesc());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader,tvDesc;
        CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tvHeading);
            tvDesc = itemView.findViewById(R.id.tvDescrition);
            card = itemView.findViewById(R.id.card);
        }
    }
}
