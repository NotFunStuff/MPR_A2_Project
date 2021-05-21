package hanu.a2_1801040067.MyCart;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.BreakIterator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import hanu.a2_1801040067.MyCart.adapter.CartAdapter;
import hanu.a2_1801040067.MyCart.db.ProductManager;
import hanu.a2_1801040067.MyCart.models.Product;

public class CartList extends AppCompatActivity {

    private List<Product> productList;
    private RecyclerView cartRV;
    private ProductManager productManager;
    private CartAdapter cartAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        cartRV = findViewById(R.id.cart_RecycleView);

        productList = new ArrayList<>();
        productManager = ProductManager.getInstance(this);
        productList = productManager.all();

        cartAdapter = new CartAdapter(productList);
        cartRV.setAdapter(cartAdapter);
        cartRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TextView total = findViewById(R.id.cart_total_price);
        total.setText(getTotalPrice());

        cartAdapter.setOnItemClickListener(totalPrice -> {
           total.setText(totalPrice);
        });
    }

    private String getTotalPrice(){
        long total = 0;
        for (int i = 0; i< productList.size(); i++){
            total += productList.get(i).getQuantity() * productList.get(i).getUnitPrice();
        }
        DecimalFormat dFormat = new DecimalFormat();
        String formattedString = dFormat.format(total);
        return formattedString;
    }
}