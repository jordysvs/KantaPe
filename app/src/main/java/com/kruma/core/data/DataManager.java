package com.kruma.core.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.kruma.core.configuration.App;
import com.kruma.core.configuration.ConfigurationManager;
import com.kruma.core.data.entity.DataCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enrique on 17/06/2016.
 */
public class DataManager extends SQLiteOpenHelper {

	public static final int DBVERSION = 1;
	private SQLiteDatabase mDatabase;


	public DataManager(String str_pDbName) {

		super(App.getContext(),
				ConfigurationManager.getDefault().getConnectionsManager().getItem(str_pDbName).getPath(),
				null,
				DBVERSION);

        File database = App.getContext().getDatabasePath(str_pDbName);
        if(!database.exists()) {
//            this.getReadableDatabase();
//			copyDatabase();
//            if(copyDatabase()) {
//                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
//                return;
//            }
        }
	}

	public void openDatabase() {
		String dbPath = App.getContext().getDatabasePath(this.getDatabaseName()).getPath();
		if (mDatabase != null && mDatabase.isOpen()) {
			return;
		}
		mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
	}

	public void closeDatabase() {
		if (mDatabase != null) {
			mDatabase.close();
		}
	}

	public long insert(String str_pTable,ContentValues cv_pValues)
	{
		SQLiteDatabase obj_DataBase = this.getWritableDatabase();
		this.openDatabase();
		long lng_Resultado = obj_DataBase.insert(str_pTable, null, cv_pValues);
		this.closeDatabase();
		obj_DataBase.close();
		return lng_Resultado;
	}
	public int update(String str_pTable, ContentValues cv_pValues,String str_pWhereClause,String[] str_pWhereArgs)
	{
		SQLiteDatabase obj_DataBase = this.getWritableDatabase();
		this.getWritableDatabase();
		int int_Resultado =  obj_DataBase.update(str_pTable, cv_pValues, str_pWhereClause,str_pWhereArgs);
		obj_DataBase.close();
		return int_Resultado;
	}

	public int delete(String str_pTable,String str_pWhereClause,String[] str_pWhereArgs)
	{
		SQLiteDatabase obj_DataBase = this.getWritableDatabase();
		int int_Row = obj_DataBase.delete(str_pTable, str_pWhereClause,str_pWhereArgs);
		obj_DataBase.close();
		return int_Row;
	}

	public <T> List<T> getList(String str_pQuery, DataCallback<T> obj_pCallBack)
	{
		List<T> lst_Resultado =  new ArrayList<T>();
		this.openDatabase();
		SQLiteDatabase obj_DataBase = this.getReadableDatabase();
		Cursor cursor = obj_DataBase.rawQuery(str_pQuery, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			lst_Resultado.add(obj_pCallBack.DetailsList(cursor));
			cursor.moveToNext();
		}
		cursor.close();
		this.closeDatabase();
		return lst_Resultado;
	}

	public <T>T getEntity(String str_pQuery, DataCallback<T> obj_pCallBack){
		List<T> lst_Resultado =  this.getList(str_pQuery, obj_pCallBack);
		if(lst_Resultado.isEmpty())
			return null;
		else
			return lst_Resultado.get(0);
	}

	private boolean copyDatabase() {
		try {

            InputStream obj_InputStream = App.getContext().getAssets().open(this.getDatabaseName());
            String str_OutFileName = App.getContext().getDatabasePath(this.getDatabaseName()).getPath();
            OutputStream obj_OutputStream = new FileOutputStream(str_OutFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = obj_InputStream.read(buff)) > 0) {
				obj_OutputStream.write(buff, 0, length);
            }
			obj_OutputStream.flush();
			obj_OutputStream.close();
            //Log.w("MainActivity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}

