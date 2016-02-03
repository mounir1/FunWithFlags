package com.apps.mounir.funwithflags;

import android.support.v7.widget.RecyclerView;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewHolder extends RecyclerView.ViewHolder{

    private final TextView tvText;
    private final ImageView img;
    private final TextView number;

    public ViewHolder(View itemView) {
        super(itemView);
        Log.d("Clicked", "Clicked view");

        tvText = (TextView) itemView.findViewById(R.id.txtalgeria);
        img = (ImageView) itemView.findViewById(R.id.country);
        number = (TextView) itemView.findViewById(R.id.number);
    }

    public void bind(Flag model, int position) {
        tvText.setText(model.getFlagName());
        img.setImageResource(model.getImagId());
        number.setText(String.format("%03d", position + 1));
    }


}

