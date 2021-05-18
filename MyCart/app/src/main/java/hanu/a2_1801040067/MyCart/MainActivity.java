package hanu.a2_1801040067.MyCart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hanu.a2_1801040067.MyCart.adapter.ItemAdapter;
import hanu.a2_1801040067.MyCart.models.Product;

public class MainActivity extends AppCompatActivity {
    private RecyclerView itemList;
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();
        productList.add(new Product(1, "https://cf.shopee.vn/file/beca50e46d2088fc5ad3c74aff5cc112", "[Siêu HOT] Đèn Ngủ Chiếu Sao Tự Xoay 3D",169000));
        productList.add(new Product(2, "https://cf.shopee.vn/file/b0c4d1c4443fb7c2d9b97cd8681f444e", "Đèn Ngủ 3D Led Nhiều Mẫu Hình Cực Đẹp - 3 màu (Được chọn hình)",55000));
        itemList = findViewById(R.id.item_list);

        ItemAdapter ItemAdapter = new ItemAdapter(productList);
        itemList.setAdapter(ItemAdapter);
        itemList.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        itemList.setLayoutManager(gridLayoutManager);
    }
}