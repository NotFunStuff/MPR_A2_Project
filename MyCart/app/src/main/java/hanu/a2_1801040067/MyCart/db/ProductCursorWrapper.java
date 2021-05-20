package hanu.a2_1801040067.MyCart.db;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.ArrayList;
import java.util.List;

import hanu.a2_1801040067.MyCart.models.Product;

public class ProductCursorWrapper extends CursorWrapper {
    public ProductCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Product getProduct(){
        long id = getLong(getColumnIndex(DbSchema.ItemsTable.Cols.ID));
        String thumbnail = getString(getColumnIndex(DbSchema.ItemsTable.Cols.THUMBNAIL));
        String name = getString(getColumnIndex(DbSchema.ItemsTable.Cols.NAME));
        long unitPrice = getLong(getColumnIndex(DbSchema.ItemsTable.Cols.UNIT_PRICE));
        long quantity = getLong(getColumnIndex(DbSchema.ItemsTable.Cols.QUANTITY));

        return new Product(id, thumbnail, name, unitPrice, quantity);
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        moveToFirst();
        while (!isAfterLast()) {
            Product product = getProduct();
            products.add(product);
            moveToNext();
        }
        return products;
    }
}
