package com.example.moneymanagement.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanagement.R;

import java.util.List;

public class TransactionRecyclerAdapter extends RecyclerView.Adapter<TransactionRecyclerAdapter.MyViewHolder> {
    List<Expense> list;
    public TransactionRecyclerAdapter(List<Expense> list){
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_single_view,parent,false);
       MyViewHolder myViewHolder = new MyViewHolder(view);
       return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.tvValue.setText(String.valueOf(list.get(position).getValue()));
      holder.tvCategory.setText(list.get(position).getCategory());
      holder.tvDes.setText((list.get(position)).getDescribe());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvCategory, tvValue,tvDes;
                public MyViewHolder(@NonNull View itemView)
                {
                    super(itemView);
                    tvCategory = itemView.findViewById(R.id.transactionCategory);
                    tvValue = itemView.findViewById(R.id.transactionValue);
                    tvDes = itemView.findViewById(R.id.transactionDes);
                }
    }
}
