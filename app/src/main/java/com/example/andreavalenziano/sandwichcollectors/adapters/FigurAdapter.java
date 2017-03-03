package com.example.andreavalenziano.sandwichcollectors.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by AndreaValenziano on 03/03/17.
 */
public class FigurAdapter extends RecyclerView.Adapter<FigurAdapter.FigurVH> {


    @Override
    public FigurVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(FigurVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class FigurVH extends RecyclerView.ViewHolder {
        public FigurVH(View itemView) {
            super(itemView);
        }
    }
}
