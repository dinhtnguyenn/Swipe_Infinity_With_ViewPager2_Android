package com.dinhnt.scrollinfinity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinhnt.scrollinfinity.R;
import com.dinhnt.scrollinfinity.models.SampleLoadMore;

import java.util.ArrayList;

public class ListLoadMore2Adapter extends RecyclerView.Adapter<ListLoadMore2Adapter.ViewHolder> {

    private Context context;
    private ArrayList<SampleLoadMore> list;

    public ListLoadMore2Adapter(Context context, ArrayList<SampleLoadMore> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recyclerview_loadmore2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNumber.setText(String.valueOf(list.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);
        }
    }
}
