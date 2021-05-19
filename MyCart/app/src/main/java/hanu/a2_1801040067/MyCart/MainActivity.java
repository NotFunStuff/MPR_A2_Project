package hanu.a2_1801040067.MyCart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hanu.a2_1801040067.MyCart.adapter.ItemAdapter;
import hanu.a2_1801040067.MyCart.models.Product;

public class MainActivity extends AppCompatActivity {
    private RecyclerView itemList;
    private List<Product> productList;
    class RestLoad extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            URL url;
            HttpURLConnection urlConnection;
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream is = urlConnection.getInputStream();
                Scanner sc = new Scanner(is);
                StringBuilder result = new StringBuilder();
                String line;
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    result.append(line);
                }
                System.out.println(result.toString());
                return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
//            if (result == null) {
//                Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_LONG).show();
//                return;
//            }
            try {
                productList = new ArrayList<>();
                JSONArray root = new JSONArray(result);
                for (int i = 0; i < root.length(); i++) {
                    JSONObject json = root.getJSONObject(i);
                    Product product = new Product(json.getInt("id"), json.getString("thumbnail"), json.getString("name"), json.getLong("unitPrice"));
                    productList.add(product);
                }
                itemList = findViewById(R.id.item_list);

                ItemAdapter ItemAdapter = new ItemAdapter(productList);
                itemList.setAdapter(ItemAdapter);
                itemList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                itemList.setLayoutManager(gridLayoutManager);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RestLoad restLoad = new RestLoad();
        restLoad.execute("https://mpr-cart-api.herokuapp.com/products");

    }


}