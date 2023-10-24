package com.example.lesson8.ui.cats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson8.R;
import com.example.lesson8.ui.cats.model.Cat;
import com.example.lesson8.ui.utils.GlideProvider;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    private List<Cat> catList = new ArrayList<>();
    private final CatsListener listener;

    public CatAdapter(CatsListener listener) {
        this.listener = listener;
    }


    public void setCats(List<Cat> catList) {
        this.catList = catList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.ViewHolder holder, int position) {
        holder.bind(catList.get(position));
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView catImageView;
        private final TextView catIdTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            catImageView = itemView.findViewById(R.id.iv_cat_holder);
            catIdTextView = itemView.findViewById(R.id.tv_cat_holder);
        }

        public void bind(Cat cat) {
            GlideProvider.loadImage(cat.getImage(), catImageView);
            catIdTextView.setText(cat.getId());
            catImageView.setOnClickListener(v -> {
                listener.onItemClick(cat);
            });

        }
    }
}
