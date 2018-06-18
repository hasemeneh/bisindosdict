package ipk404.bisindosdict.DatabaseManager;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ipk404.bisindosdict.Dao.DictDao;

/**
 * Created by Retrieving on 5/24/2016.
 */
public class DBManager {
    private static SQLiteDatabase dataBasex;
    private static SQLiteDatabase dataBase;

    public static void initDB(final Context context) {
        if (dataBasex == null || dataBase == null) {
            final DBHelper DBhelper = new DBHelper(context);
            dataBasex = DBhelper.getReadableDatabase();
            dataBase = DBhelper.getWritableDatabase();
        }
    }

    public static boolean MakeFavorite(Context context, DictDao datas,int isOK) {
        try {
            DBManager.initDB(context);
        } catch (Exception e) {
            Log.d("errorSQLManager", e.getMessage());
        }
        final Gson gson = new Gson();
        try {
            String sql = "";
            dataBase.execSQL(sql);
            return true;
        } catch (SQLException ex) {
            Log.d("errorSQLManager", ex.getMessage());
            return false;
        }

    }

    public static List<DictDao> getDictCommon(Context context) {
        final ArrayList<DictDao> item = new ArrayList();
        try {
            DBManager.initDB(context);
        } catch (Exception e) {
            Log.d("errorSQLManager", e.getMessage());
        }
        String sql = "SELECT * FROM `kamus` WHERE is_common = 1 ORDER BY random(),kata DESC LIMIT 0,8";
        final Gson gson = new Gson();
        try {
            final Cursor cursor = dataBasex.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                item.add(new DictDao(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            }
            cursor.close();
            return item;
        } catch (SQLException ex) {
            Log.d("errorSQLManager", ex.getMessage());
        }
        return item;
    }
    public static List<DictDao> getDictByName(Context context,String keywords) {
        final ArrayList<DictDao> item = new ArrayList();
        try {
            DBManager.initDB(context);
        } catch (Exception e) {
            Log.d("errorSQLManager", e.getMessage());
        }
        String sql = "SELECT * FROM `kamus` WHERE kata LIKE '"+keywords+"%'";
        final Gson gson = new Gson();
        try {
            final Cursor cursor = dataBasex.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                item.add(new DictDao(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            }
            cursor.close();
            return item;
        } catch (SQLException ex) {
            Log.d("errorSQLManager", ex.getMessage());
        }
        return item;
    }

}
