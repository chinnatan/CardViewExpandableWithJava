package com.zkcnt.cardviewexpandable.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.zkcnt.cardviewexpandable.R;

import java.util.HashMap;
import java.util.List;

public class InnerRecyclerViewAdapter extends RecyclerView.Adapter<InnerRecyclerViewAdapter.ViewHolder> {
    private HashMap<String, List<String>> child;
    Context context;
    int groupPosition;
    String groupname;

    public InnerRecyclerViewAdapter(Context context, HashMap<String, List<String>> child, int groupPosition, String groupname) {
        this.child = child;
        this.context = context;
        this.groupPosition = groupPosition;
        this.groupname = groupname;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemTextView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_expand_item, parent, false);
        InnerRecyclerViewAdapter.ViewHolder vh = new InnerRecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String childText = (String) getChild(groupPosition,position);
        holder.name.setText(childText);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked on "+childText, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return child.get(groupname).size();
    }

    public Object getChild(int groupPosition, int childPosititon) {

        // This will return the child
        return this.child.get(groupname).get(childPosititon);
    }

}
