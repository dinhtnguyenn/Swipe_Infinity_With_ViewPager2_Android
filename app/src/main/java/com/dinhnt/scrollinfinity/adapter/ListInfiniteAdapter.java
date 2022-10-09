package com.dinhnt.scrollinfinity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinhnt.scrollinfinity.R;
import com.dinhnt.scrollinfinity.models.Sample;

import java.util.ArrayList;

public class ListInfiniteAdapter extends RecyclerView.Adapter<ListInfiniteAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Sample> newList;


    public ListInfiniteAdapter(Context context, ArrayList<Sample> list) {
        this.context = context;
        newList = new ArrayList<>();
        newList.addAll(list);
        newList.add(0, list.get(list.size() -1));
        newList.add(list.get(0));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recyclerview_infinite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNumber.setText(String.valueOf(newList.get(position).getNumber()));
        holder.linear.setBackgroundColor(newList.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return newList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNumber;
        LinearLayout linear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            linear = itemView.findViewById(R.id.linear);
        }
    }
}
