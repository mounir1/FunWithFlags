package com.apps.mounir.funwithflags.Helpers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.apps.mounir.funwithflags.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio
 * User: Xaver
 * Date: 24/05/15
 */
public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context c;
    private final LayoutInflater mInflater;
    private final List<Flag> mModels;
    private static String ListType;

    public MyAdapter(Context context, List<Flag> models, String type) {
        mInflater = LayoutInflater.from(context);
        mModels = new ArrayList<>(models);
        this.c = context;
        this.ListType = type;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(R.layout.one_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Flag model = mModels.get(position);
        holder.bind(c, model, position);
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    public void animateTo(List<Flag> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<Flag> newModels) {
        for (int i = mModels.size() - 1; i >= 0; i--) {
            final Flag model = mModels.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Flag> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final Flag model = newModels.get(i);
            if (!mModels.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Flag> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final Flag model = newModels.get(toPosition);
            final int fromPosition = mModels.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public Flag removeItem(int position) {
        final Flag model = mModels.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, Flag model) {
        mModels.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Flag model = mModels.remove(fromPosition);
        mModels.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

}

