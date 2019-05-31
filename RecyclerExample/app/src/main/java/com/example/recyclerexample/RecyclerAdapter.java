package com.example.recyclerexample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private  int[] images;

    private Context context;

    private List<String> names;

    public RecyclerAdapter(int[] images, List<String> names,Context context){
        this.images=images;
        this.context=context;
        this.names=names;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout, viewGroup, false);
        ImageViewHolder imageViewHolder= new ImageViewHolder(view, context, images);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int i) {

        int image_id= images[i];
        holder.Album.setImageResource(image_id);
        holder.AlbumTitle.setText(names.get(i));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView Album;
        TextView AlbumTitle;
        Context context;
        int[] images;

        public ImageViewHolder(@NonNull View itemView, Context context, int[] images) {
            super(itemView);

            Album=itemView.findViewById(R.id.album);
            AlbumTitle=itemView.findViewById(R.id.album_title);
            itemView.setOnClickListener(this);
            this.context=context;
            this.images=images;
        }

        @Override
        public void onClick(View v) {

            Intent intent=new Intent(context,DisplayActivity.class);
            intent.putExtra("image_id",images[getAdapterPosition()]);
            context.startActivity(intent);

        }
    }
    public void upadateList(List<String> names){

       names=new ArrayList<>();
        names.addAll(names);
        notifyDataSetChanged();
    }

}
