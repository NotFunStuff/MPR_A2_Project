package hanu.a2_1801040067.MyCart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hanu.a2_1801040067.MyCart.adapter.CartAdapter;
import hanu.a2_1801040067.MyCart.adapter.ItemAdapter;
import hanu.a2_1801040067.MyCart.models.Product;

public class CartList extends AppCompatActivity {
    private List<Product> productList;
    private RecyclerView cartRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        cartRV = findViewById(R.id.cart_RecycleView);

        productList = new ArrayList<>();
        productList.add(new Product(1, "https://cf.shopee.vn/file/beca50e46d2088fc5ad3c74aff5cc112", "[Siêu HOT] Đèn Ngủ Chiếu Sao Tự Xoay 3D",169000,1));
        productList.add(new Product(2, "https://cf.shopee.vn/file/b0c4d1c4443fb7c2d9b97cd8681f444e", "Đèn Ngủ 3D Led Nhiều Mẫu Hình Cực Đẹp - 3 màu (Được chọn hình)",55000,1));
        productList.add(new Product(2, "https://cf.shopee.vn/file/b0c4d1c4443fb7c2d9b97cd8681f444e", "Đèn Ngủ 3D Led Nhiều Mẫu Hình Cực Đẹp - 3 màu (Được chọn hình)",55000,1));
        productList.add(new Product(2, "https://cf.shopee.vn/file/b0c4d1c4443fb7c2d9b97cd8681f444e", "Đèn Ngủ 3D Led Nhiều Mẫu Hình Cực Đẹp - 3 màu (Được chọn hình)",55000,1));
        CartAdapter cartAdapter = new CartAdapter(productList);
        cartRV.setAdapter(cartAdapter);
        cartRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}