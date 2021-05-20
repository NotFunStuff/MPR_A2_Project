package hanu.a2_1801040067.MyCart.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.List;

import hanu.a2_1801040067.MyCart.models.Product;

public class ProductManager {
    private static ProductManager instance;

    private static final String INSERT_STMT =
            "INSERT INTO " + DbSchema.ItemsTable.NAME + "(id, thumbnail, name, unitPrice, quantity) VALUES (?, ?, ?, ?, ?)";

    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public static ProductManager getInstance(Context context) {
        if (instance == null) {
            instance = new ProductManager(context);
        }

        return instance;
    }

    private ProductManager(Context context) {
        dbHelper = new DbHelper(context,null,null,0);
        db = dbHelper.getWritableDatabase();
    }

    public List<Product> all() {
        String sql = "SELECT * FROM items";
        Cursor cursor = db.rawQuery(sql, null);
        ProductCursorWrapper cursorWrapper = new ProductCursorWrapper(cursor);

        return cursorWrapper.getProducts();
    }

    public boolean add(Product product) {
        SQLiteStatement statement = db.compileStatement(INSERT_STMT);

        statement.bindLong(1, product.getId());
        statement.bindString(2, product.getThumbnail());
        statement.bindString(3, product.getName());
        statement.bindLong(4, product.getUnitPrice());
        statement.bindLong(5, product.getQuantity());

        long id = statement.executeInsert();
        statement.executeUpdateDelete();
        // a
        if (id > 0) {
            product.setId(id);
            return true;
        }

        return false;
    }

    public boolean delete(long id) {
        int result = db.delete(DbSchema.ItemsTable.NAME, "id = ?", new String[]{ id+"" });

        return result > 0;
    }
}
