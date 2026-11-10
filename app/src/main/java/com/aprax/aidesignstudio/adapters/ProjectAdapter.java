package com.aprax.aidesignstudio.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.aprax.aidesignstudio.R;
import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    private ArrayList<String> projectNames = new ArrayList<>();
    private ArrayList<String> projectDescriptions = new ArrayList<>();
    private ArrayList<String> projectIcons = new ArrayList<>();
    private OnItemClickListener listener;

    public ProjectAdapter() {
        this.listener = null;
    }

    public ProjectAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_projects, parent, false);
            return new HeaderViewHolder((View) view.findViewById(R.id.header_name));
        } else {
            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_project, parent, false);
            return new ItemViewHolder(view, listener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder header = (HeaderViewHolder) holder;
            header.headerName.setText(getItemCount() > 0 ? "My Projects" : "No Projects");
        } else if (holder instanceof ItemViewHolder) {
            ItemViewHolder item = (ItemViewHolder) holder;
            item.tvName.setText(projectNames.get(position));
            item.tvDescription.setText(projectDescriptions.get(position));
            // Set icon color based on project name hash
            int color = android.graphics.Color.argb(255,
                    Math.abs(projectNames.get(position).hashCode()) & 0xFF,
                    Math.abs(projectNames.get(position).hashCode()) & 0xFF,
                    (Math.abs(projectNames.get(position).hashCode()) & 0xFF) ^ 0xFF);
            item.ivIcon.setBackgroundResource(android.R.color.darker_gray);
        }
    }

    @Override
    public int getItemCount() {
        return projectNames.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    public void setProjects(ArrayList<String> names, ArrayList<String> descriptions) {
        this.projectNames = names;
        this.projectDescriptions = descriptions;
        notifyDataSetChanged();
    }

    public void clearProjects() {
        projectNames.clear();
        projectDescriptions.clear();
        notifyDataSetChanged();
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerName;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerName = itemView.findViewById(R.id.header_name);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvDescription;
        ImageView ivIcon;
        OnItemClickListener itemListener;

        public ItemViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            itemListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemListener != null) {
                itemListener.onItemClick(getAdapterPosition());
            }
        }
    }
}
