package com.example.myframe.bus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myframe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/24.
 */

public class ListDialogAdapter extends RecyclerView.Adapter<ListDialogAdapter.ViewHolder> {
    Context context;
    List<String> dialogList = new ArrayList<>();
    public OnGetAdapterPositionListener onGetAdapterPositionListener;

    public interface OnGetAdapterPositionListener  {
        void getAdapterPosition(int position);
    }
    public void sendOnGetAdapterPositionListener(OnGetAdapterPositionListener onGetAdapterPositionListener){
        this.onGetAdapterPositionListener = onGetAdapterPositionListener;
    }
    public ListDialogAdapter(Context context, List<String> dialogList) {
        this.context = context;
        this.dialogList = dialogList;
    }

    @Override
    public ListDialogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_dialog_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListDialogAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(dialogList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGetAdapterPositionListener.getAdapterPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dialogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
