package hanu.a2_1801040067.MyCart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

import hanu.a2_1801040067.MyCart.R;
import hanu.a2_1801040067.MyCart.helper.ImageLoad;
import hanu.a2_1801040067.MyCart.models.Product;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {

    private List<Product> productList;

    public CartAdapter(List<Product> productList) {
        this.productList = productList;
    }

    public class CartHolder extends RecyclerView.ViewHolder {
        private Context context;
        private ImageView cartThumbnail;
        private TextView cartPrePrice;
        private TextView cartName;
        private TextView cartQuantity;
        private ImageView cartPlus;
        private ImageView cartMinus;
        private TextView cartSum;

        public CartHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            cartThumbnail  = itemView.findViewById(R.id.cart_thumbnail);
            cartName = itemView.findViewById(R.id.cart_name);
            cartPrePrice = itemView.findViewById(R.id.cart_pre_price);
            cartQuantity = itemView.findViewById(R.id.cart_quantity);
            cartPlus = itemView.findViewById(R.id.cart_plus);
            cartMinus = itemView.findViewById(R.id.cart_minus);
            cartSum = itemView.findViewById(R.id.cart_sum_price);
        }

        public void bind(Product item){
            ImageLoad helper = new ImageLoad(item.getThumbnail(), cartThumbnail);
            helper.execute();
            DecimalFormat dFormat = new DecimalFormat();
            String formattedString = dFormat.format(item.getUnitPrice());
            cartPrePrice.setText(formattedString + "đ");
            cartQuantity.setText(String.valueOf(item.getQuantity()));
            String sumFormat = dFormat.format(item.getUnitPrice()*item.getQuantity());
            cartSum.setText(sumFormat + "đ");
            cartName.setText(item.getName());
            cartPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            cartMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_cart, parent,false);
        return new CartAdapter.CartHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        Product item = productList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


}
