package com.apps.mounir.funwithflags.Helpers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.mounir.funwithflags.Activities.FlagDetails;
import com.apps.mounir.funwithflags.R;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public static final String ImageID = "ID";
    private final TextView tvText;
    private final ImageView img;
    private final TextView number;
    public int IMGID ;
    Context ctx;
    private int Position;

    public ViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        Log.d("Clicked", "Clicked view");

        tvText = (TextView) itemView.findViewById(R.id.txtalgeria);
        img = (ImageView) itemView.findViewById(R.id.country);
        number = (TextView) itemView.findViewById(R.id.number);
    }

    public void bind(Context c, Flag model, int position) {
        ctx = c;
        Position = position;
        tvText.setText(model.getFlagName());
        img.setImageResource(model.getImagId());
        number.setText(String.format("%03d", position + 1));
        IMGID = model.getImagId();
    }


    @Override
    public void onClick(View v) {


        Intent intent;
        intent = new Intent(ctx, FlagDetails.class);
        intent.putExtra(ImageID, String.valueOf(IMGID));
        ctx.startActivity(intent);

    }
}
