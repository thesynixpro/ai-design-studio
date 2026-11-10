package com.aprax.aidesignstudio.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.aprax.aidesignstudio.models.AIModel;
import com.aprax.aidesignstudio.R;

import java.util.ArrayList;

public class ModelAdapter extends ArrayAdapter<AIModel> {

    public ModelAdapter() {
        super(null, 0, new ArrayList<AIModel>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;
        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.item_model, parent, false);
            holder = new ViewHolder();
            holder.tvDisplayName = row.findViewById(R.id.tv_display_name);
            holder.tvModelId = row.findViewById(R.id.tv_model_id);
            holder.tvFreeTier = row.findViewById(R.id.tv_free_tier);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        AIModel model = this.getItem(position);
        holder.tvDisplayName.setText(model.displayName);
        holder.tvModelId.setText("ID: " + model.getModelId());
        holder.tvFreeTier.setText("Free: " + model.isFreeTierEligible());
        return row;
    }

    private static class ViewHolder {
        TextView tvDisplayName;
        TextView tvModelId;
        TextView tvFreeTier;
    }
}
