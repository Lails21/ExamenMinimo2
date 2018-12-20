package dsa.eetac.upc.edu.examenminimo2;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {

    private List<Element> data;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView cityImageView;
        private TextView cityTextView;
        private TextView codipostalTextView;
        public LinearLayout linearLayout;

        public ViewHolder(View v) {
            super(v);
            cityImageView=v.findViewById(R.id.imageView);
            cityTextView=v.findViewById(R.id.citytext);
            codipostalTextView=v.findViewById(R.id.codipostaltext);
            linearLayout = v.findViewById(R.id.linearLayout);
        }
    }

    public void addCities (List<Element> elementList){
        data.addAll(elementList);
        notifyDataSetChanged();
    }

    public Recycler(Context context) {
        this.data = new ArrayList<>();
        this.context=context;
    }
    @Override
    public Recycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Recycler.ViewHolder holder, int position) {
        Element elementdata = ((Element)data.get(position));
        holder.cityTextView.setText(elementdata.getMunicipiNom());
        holder.codipostalTextView.setText(elementdata.getIne());
        //Picasso.with(context).load(elementdata.getMunicipiEscut().into(holder.cityImageView));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
