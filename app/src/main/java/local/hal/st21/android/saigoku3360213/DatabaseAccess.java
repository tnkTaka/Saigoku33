package local.hal.st21.android.saigoku3360213;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class DatabaseAccess {

    public static String findHonzonByPK(SQLiteDatabase db, int id){
        String sql = "SELECT honzon FROM temple WHERE _id = " + id;
        Cursor cursor = db.rawQuery(sql,null);
        String result = "";
        while (cursor.moveToNext()){
            int idxHonzon = cursor.getColumnIndex("honzon");
            result = cursor.getString(idxHonzon);
        }
        return result;
    }

    public static String findShushiByPK(SQLiteDatabase db, int id){
        String sql = "SELECT shushi FROM temple WHERE _id = " + id;
        Cursor cursor = db.rawQuery(sql,null);
        String result = "";
        while (cursor.moveToNext()){
            int idxShushi = cursor.getColumnIndex("shushi");
            result = cursor.getString(idxShushi);
        }
        return result;
    }

    public static String findAddressByPK(SQLiteDatabase db, int id){
        String sql = "SELECT address FROM temple WHERE _id = " + id;
        Cursor cursor = db.rawQuery(sql,null);
        String result = "";
        while (cursor.moveToNext()){
            int idxAddress = cursor.getColumnIndex("address");
            result = cursor.getString(idxAddress);
        }
        return result;
    }

    public static String findUrlByPK(SQLiteDatabase db, int id){
        String sql = "SELECT url FROM temple WHERE _id = " + id;
        Cursor cursor = db.rawQuery(sql,null);
        String result = "";
        while (cursor.moveToNext()){
            int idxUrl = cursor.getColumnIndex("url");
            result = cursor.getString(idxUrl);
        }
        return result;
    }

    public static String findNoteByPK(SQLiteDatabase db, int id){
        String sql = "SELECT note FROM temple WHERE _id = " + id;
        Cursor cursor = db.rawQuery(sql,null);
        String result = "";
        while (cursor.moveToNext()){
            int idxNote = cursor.getColumnIndex("note");
            result = cursor.getString(idxNote);
        }
        return result;
    }

    public static boolean findRowByPK(SQLiteDatabase db,int id){
        String sql = "SELECT COUNT(*) AS count FROM temple WHERE _id =" + id;
        Cursor cursor = db.rawQuery(sql,null);
        boolean result = false;
        if (cursor.moveToFirst()){
            int idxCount = cursor.getColumnIndex("count");
            int count = cursor.getInt(idxCount);
            if (count >= 1){
                result = true;
            }
        }
        return result;
    }

    public static int update(SQLiteDatabase db,int id,String name,String honzon,String shushi,String address,String url,String note){
        String sql = "UPDATE temple SET name = ?, honzon= ?, shushi = ?, address = ?, url = ?, note = ? WHERE _id = ?";
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindString(1,name);
        stmt.bindString(2,honzon);
        stmt.bindString(3,shushi);
        stmt.bindString(4,address);
        stmt.bindString(5,url);
        stmt.bindString(6,note);
        stmt.bindLong(7,id);
        int result = stmt.executeUpdateDelete();
        return result;
    }

    public static long insert(SQLiteDatabase db,int id,String name,String honzon,String shushi,String address,String url,String note) {
        String sql = "INSERT INTO temple (_id, name, honzon, shushi, address, url, note) VALUES (?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindLong(1,id);
        stmt.bindString(2,name);
        stmt.bindString(3,honzon);
        stmt.bindString(4,shushi);
        stmt.bindString(5,address);
        stmt.bindString(6,url);
        stmt.bindString(7,note);
        long insertedId = stmt.executeInsert();
        return insertedId;
    }
}
