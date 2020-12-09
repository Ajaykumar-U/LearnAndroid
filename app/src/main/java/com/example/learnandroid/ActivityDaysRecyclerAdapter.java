package com.example.learnandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityDaysRecyclerAdapter extends RecyclerView.Adapter {

    public static final int viewHeader = 1;
    public static final int viewFooter = 2;
    public static final int viewData = 3;

    ActivityDaysRecyclerAdapterCallBack callBack;
    ArrayList<String> data;

    ActivityDaysRecyclerAdapter(ArrayList<String> data, ActivityDaysRecyclerAdapterCallBack callBack) {
        this.data = data;
        data.add(0, null);
        this.callBack = callBack;
    }

    /**
     * <h>onCreateViewHolder (ViewGroup parent,int viewType)</h>
     * <p>Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.</p>
     *
     * @param parent:   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType: The view type of the new View.
     * @return: A new ViewHolder that holds a View of the given view type.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == viewHeader) {
            View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_recycler, parent, false);
            return new ViewHolderItem(rowItem);
        } else if (viewType == viewFooter) {
            View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_recycler, parent, false);
            return new ViewHolderItem(rowItem);
        } else {
            View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_recycler_list, parent, false);
            return new ViewHolder(rowItem);
        }
    }

    /**
     * <h>onBindViewHolder (VH holder,int position)</h>
     * <p>Called by RecyclerView to display the data at the specified position.</p>
     *
     * @param holder:   The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position: The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == viewData) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textViewDays.setText(data.get(position));
        }
    }

    /**
     * <h>getItemViewType(int position)</h>
     * <p>Return the view type of the item at position for the purposes of view recycling.</p>
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return viewHeader;
        else if (position == data.size())
            return viewFooter;
        else
            return viewData;
    }

    /**
     * <h>getItemCount()</h>
     * <p>Returns the total number of items in the data set held by the adapter.</p>
     */
    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    /**
     * <h>ViewHolder for Activities</h>
     * <p>A ViewHolder describes an item view and metadata about its place within the RecyclerView.</p>
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewDays;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewDays = itemView.findViewById(R.id.textViewActivities);

        }

        @Override
        public void onClick(View view) {
            if (callBack != null)
                callBack.onClickDays(getAdapterPosition());
        }
    }

    /**
     *<h>ViewHolder for Header and Footer<h>
     * <p>A ViewHolder describes an item view and metadata about its place within the RecyclerView.</p>
     */
    class ViewHolderItem extends RecyclerView.ViewHolder {

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
        }
    }
}
