package com.example.staggeredrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "StaggeredRecyclerViewAd";
    private ArrayList<String> imagenames = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();
    private Context context;

    public StaggeredRecyclerViewAdapter( Context context,ArrayList<String> imagenames, ArrayList<String> imageUrls) {
        this.context = context;
        this.imagenames = imagenames;
        this.imageUrls = imageUrls;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grigitem_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        RequestOptions requestOptions=new RequestOptions().placeholder(R.drawable.ic_launcher_background);
        //it Provides type independent options to customize loads with Glide.

        Glide.with(context).load(imageUrls.get(position)).apply(requestOptions).into(holder.image);
        holder.name.setText(imagenames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + imagenames.get(position));
                Toast.makeText(context, imagenames.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("image_url", imageUrls.get(position));
                intent.putExtra("image_name", imagenames.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imagenames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageview_widget);
            name=itemView.findViewById(R.id.name_widget);
        }
    }
}
