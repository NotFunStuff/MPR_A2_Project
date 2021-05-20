package hanu.a2_1801040067.MyCart.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import hanu.a2_1801040067.MyCart.R;
import hanu.a2_1801040067.MyCart.db.ProductManager;
import hanu.a2_1801040067.MyCart.helper.ImageLoad;
import hanu.a2_1801040067.MyCart.models.Product;

import static android.app.Activity.RESULT_OK;

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
        private Context context;
        private List<Product> products;
        private ProductManager productManager;

        public ItemHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            itemName = itemView.findViewById(R.id.item_name);
            itemThumbnail = itemView.findViewById(R.id.item_thumbnail);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemAddBtn = itemView.findViewById(R.id.item_add_button);
            productManager = productManager.getInstance(context);
            products = productManager.all();
        }

        public void bind(Product item){
            itemName.setText(item.getName());
            ImageLoad helper = new ImageLoad(item.getThumbnail(), itemThumbnail);
            helper.execute();
            DecimalFormat dFormat = new DecimalFormat();
            String formattedString = dFormat.format(item.getUnitPrice());
            itemPrice.setText(formattedString + "VND");

            itemAddBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    for ( int i =0; i < products.size();  i++){
                        Product p = products.get(i);
                        if (item.getId() == p.getId()){
                            break;
                        }
                    }
                    productManager.add(item);
                    Toast.makeText(context, "Succesfull Added to Cart", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @NonNull
    @Override
    public ItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_shop, parent,false);
        return new ItemHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemHolder holder, int position) {
        Product item = productList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

