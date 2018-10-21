package com.libertystudio.flickrsearch.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.libertystudio.flickrsearch.R;
import com.libertystudio.flickrsearch.entity.Photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<Photo> photos = new ArrayList<>();
    private Context context;
    private Listener listener;

    public PhotoAdapter(Context context, Listener listener) {
        this.context = context;
        this.listener = listener;
    }

    public interface Listener {
        void onPhotoClicked(String photoURL);
    }

    public void setItems(List<Photo> photos) {
        this.photos.clear();
        this.photos.addAll(photos);
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Photo currentPhoto = photos.get(position);

        holder.photoURL = "https://farm" + currentPhoto.getFarm() + ".staticflickr.com/" +
                currentPhoto.getServer() + "/" + currentPhoto.getId() + "_" + currentPhoto.getSecret() + ".jpg";

        holder.tvTitle.setText(currentPhoto.getTitle());

        Glide
                .with(context)
                .load(holder.photoURL)
                .into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        String photoURL;
        TextView tvTitle;
        ImageView ivPhoto;

        PhotoViewHolder(View itemView) {
            super(itemView);
            tvTitle =  itemView.findViewById(R.id.tvTitle);
            ivPhoto =  itemView.findViewById(R.id.ivPhoto);

            ivPhoto.setOnClickListener(v -> listener.onPhotoClicked(photoURL));
        }
    }
}