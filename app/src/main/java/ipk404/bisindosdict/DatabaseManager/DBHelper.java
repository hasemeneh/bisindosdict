package ipk404.bisindosdict.DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Retrieving on 5/24/2016.
 */
public class DBHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "db_bisindo";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade(DATABASE_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
