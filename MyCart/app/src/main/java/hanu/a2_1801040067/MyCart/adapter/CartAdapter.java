package hanu.a2_1801040067.MyCart.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    public class CartHolder extends RecyclerView.ViewHolder {
        private Context context;
        public CartHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
        }
    }
    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
