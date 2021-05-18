package hanu.a2_1801040067.MyCart.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hanu.a2_1801040067.MyCart.R;
import hanu.a2_1801040067.MyCart.helper.ImageLoad;
import hanu.a2_1801040067.MyCart.models.Product;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private List<Product> productList;

    public ItemAdapter(List<Product> productList) {
        this.productList = productList;
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        private TextView itemName;
        private ImageView itemThumbnail;
        private TextView itemPrice;
        private ImageButton itemAddBtn;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemThumbnail = itemView.findViewById(R.id.item_thumbnail);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemAddBtn = itemView.findViewById(R.id.item_add_button);
        }

        public void bind(Product item){
            itemName.setText(item.getName());
            ImageLoad helper = new ImageLoad(item.getThumbnail(), itemThumbnail);
            itemPrice.setText(item.getUnitPrice());
        }
    }
    @NonNull
    @Override
    public ItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

