package com.example.andriod.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GetJsonArrayAapter extends RecyclerView.Adapter<GetJsonArrayAapter.MyViewHolder> {



    private List<User> userList;
    private Context context;

    public GetJsonArrayAapter(List<User> userList,Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.getarray_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final User user = userList.get(i);
        myViewHolder.id.setText(user.getId());
        myViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("id",user.getId());
                intent.putExtra("name",user.getName());
                intent.putExtra("email", user.getEmail());
                intent.putExtra("gender",user.getGender());
                intent.putExtra("home",user.getHome());
                intent.putExtra("mobile",user.getMobile());
                intent.putExtra("office",user.getOffice());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        CardView card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cv);
            id = itemView.findViewById(R.id.id);
        }
    }
}
