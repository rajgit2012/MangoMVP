package com.manglolab.mangopost.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manglolab.mangopost.R;
import com.manglolab.mangopost.model.pojo.Comment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CommentsListAdapter extends RecyclerView.Adapter<CommentsListAdapter.ViewHolder> {

    private List<Comment> comments;

    public CommentsListAdapter() {
        this.comments = new ArrayList<>();
    }

    public void addPosts(List<Comment> newPosts) {
        comments.addAll(newPosts);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //System.out.println("Name " + comments.get(position).getName() + " Email " + comments.get(position).getEmail() +
          //      comments.get(position).getBody());
        viewHolder.postName.setText(comments.get(position).getName());
        viewHolder.postEmail.setText(comments.get(position).getEmail());
        viewHolder.postBody.setText(comments.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.name)
        TextView postName;
        @InjectView(R.id.email)
        TextView postEmail;
        @InjectView(R.id.post_body)
        TextView postBody;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }

}
