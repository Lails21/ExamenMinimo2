package dsa.eetac.upc.edu.examenminimo2;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }
    @Override
    public Recycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Recycler.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
