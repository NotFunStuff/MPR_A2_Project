package hanu.a2_1801040067.MyCart.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private Context mContext;
    private static final String DATABASE_NAME = "item.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DbSchema.ItemsTable.NAME + "(" +
                DbSchema.ItemsTable.Cols.ID + " LONG, " +
                DbSchema.ItemsTable.Cols.THUMBNAIL + " TEXT, " +
                DbSchema.ItemsTable.Cols.NAME + " TEXT, " +
                DbSchema.ItemsTable.Cols.UNIT_PRICE + " LONG, " +
                DbSchema.ItemsTable.Cols.QUANTITY + " LONG " + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("My Friends", "My Friends: upgrading DB; dropping/recreating tables.");
        db.execSQL("DROP TABLE IF EXISTS " + DbSchema.ItemsTable.NAME);
    }
}
