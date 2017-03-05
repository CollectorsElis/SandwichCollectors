package com.example.andreavalenziano.sandwichcollectors.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andreavalenziano.sandwichcollectors.R;
import com.example.andreavalenziano.sandwichcollectors.models.Figurina;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by AndreaValenziano on 03/03/17.
 */
public class FigurAdapter extends RecyclerView.Adapter<FigurAdapter.FigurVH> {


    @Override
    public FigurVH onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_figur, parent, false);
        return new FigurVH(view);
    }

    @Override
    public void onBindViewHolder(FigurAdapter.FigurVH holder, int position) {
        holder.numberTV.setText(String.valueOf(dataSet.get(position).getNumFigurina()));
        holder.nameTV.setText(dataSet.get(position).getNome());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private ArrayList<Figurina> dataSet = new ArrayList<>();

    public ArrayList<Figurina> getDataSet() {
        return dataSet;
    }


    public void setDataSet(ArrayList<Figurina> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    class FigurVH extends RecyclerView.ViewHolder {
        TextView numberTV, nameTV;

        FigurVH(View itemView) {
            super(itemView);
            numberTV = (TextView) itemView.findViewById(R.id.number_tv);
            nameTV = (TextView) itemView.findViewById(R.id.name_tv);
            Log.d(TAG, "NAME TV: " + nameTV.getText());
        }
    }
}
