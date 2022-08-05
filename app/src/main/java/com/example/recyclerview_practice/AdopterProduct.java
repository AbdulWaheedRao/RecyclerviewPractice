package com.example.recyclerview_practice;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdopterProduct extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Product> products;

    public void setOnclick(OnClick onclick) {
        this.onclick = onclick;
    }

    OnClick onclick;

    public AdopterProduct(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootview = null;
        if (viewType == 0) {
            rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_rowview, null);
            return new ProductViewholder(rootview);
        }else{
            rootview=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_rowview_single,null);
            return new ProductViewHolderSingle(rootview);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0)
        return 0;
        return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = products.get(position);
        if (holder instanceof ProductViewholder) {
            ((ProductViewholder) holder).iv.setImageResource(product.getImageResourceId());
            ((ProductViewholder) holder).tvPrice.setText(Double.toString(product.getPrice()));
            ((ProductViewholder) holder).tvTitle.setText(product.getTitle());
        } else if(holder instanceof ProductViewHolderSingle){
            ((ProductViewHolderSingle) holder).v.setImageResource(product.getImageResourceId());
        }
    }
    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewholder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvTitle, tvPrice;

        public ProductViewholder(@NonNull View rootView) {
            super(rootView);
            iv=rootView.findViewById(R.id.iv);
            tvTitle =rootView.findViewById(R.id.tvTitle);
            tvPrice =rootView.findViewById(R.id.tvPrice);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onclick!=null){
                       int position=getAdapterPosition();
                       onclick.onclick(view,position);
                    }
                }
            });

        }
    }
    class ProductViewHolderSingle extends RecyclerView.ViewHolder{
        ImageView v;
        public ProductViewHolderSingle(@NonNull View rootView) {
            super(rootView);
            v=rootView.findViewById(R.id.iv);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onclick!=null){
                        int position=getAdapterPosition();
                        onclick.onclick(view,position);
                    }
                }
            });
        }
    }
    interface OnClick{
        public void onclick(View view,int position);
    }

}


