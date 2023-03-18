package com.vedant.trufitnetwork;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class PostAdapter extends FirebaseRecyclerAdapter<Post,PostAdapter.PostViewHolder> {

    public PostAdapter(@NonNull FirebaseRecyclerOptions<Post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull Post model) {
        holder.name.setText(model.getFull_name());
        holder.caption.setText(model.getCaption());
        holder.likeBtn.setText(model.getLike_count());
        holder.commentBtn.setText(model.getComment_count());
        holder.captionName.setText(model.getFull_name());
        holder.commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.commentBtn.isChecked()){
                    holder.commentBtn.setText(model.getComment_count());
                    Intent intent= new Intent(view.getContext(),Comments.class);
                    intent.putExtra("userName",model.getFull_name());
                    intent.putExtra("caption",model.getCaption());
                    view.getContext().startActivity(intent);
                }else{
                    holder.commentBtn.setText(model.getComment_count());
                }
            }
        });

        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.likeBtn.isChecked()){
                    int likes = Integer.parseInt(model.getLike_count())+1;
                    holder.likeBtn.setText(""+likes);
                    holder.likeBtn.setTextColor(Color.parseColor("#D70040"));
                    holder.likeBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_favorite_24, 0, 0, 0);
                }else{
                    holder.likeBtn.setText(model.getLike_count());
                    holder.likeBtn.setTextColor(Color.parseColor("#000000"));
                    holder.likeBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.round_favorite_border_24, 0, 0, 0);

                }
            }
        });
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
        TextView name,caption,captionName,captionUsername;
        ToggleButton likeBtn,commentBtn;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            caption = itemView.findViewById(R.id.Caption);
            captionName = itemView.findViewById(R.id.CaptionName);
            captionUsername = itemView.findViewById(R.id.CaptionUsername);
            likeBtn = itemView.findViewById(R.id.likeBtn);
            commentBtn = itemView.findViewById(R.id.commentBtn);
        }
    }
}
