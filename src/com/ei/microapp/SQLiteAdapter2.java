package com.ei.microapp;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter2 {

	public static final String MYDATABASE_NAME = "micro2";
	public static final String MYDATABASE_TABLE = "data";
	public static final int MYDATABASE_VERSION = 1;
	public static final String KEY_ID = "_id";
		public static final String KEY_EXTRACTEDSAMPLE = "extractedsample";
		public static final String KEY_PRIMERPAIR = "primerpair";
		public static final String KEY_DATEOFINPUT = "dateofinput";
		public static final String KEY_SUCCESSFULL = "successfull";
		public static final String KEY_DATEOFSENDTOSEQUENCING= "dateofsendtosequencing";
	
	private static final String SCRIPT_CREATE_DATABASE =
		"create table " + MYDATABASE_TABLE + " ("
		+ KEY_ID + " integer primary key autoincrement, "
		+ KEY_EXTRACTEDSAMPLE + " text, " + KEY_PRIMERPAIR + " text, " + KEY_DATEOFINPUT + " text, " + KEY_SUCCESSFULL + " text, " + KEY_DATEOFSENDTOSEQUENCING + " text);";
	
	private SQLiteHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;

	private Context context;
	
	public SQLiteAdapter2(Context c){
		context = c;
	}
	
	public SQLiteAdapter2 openToRead() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();
		return this;	
	}
	
	public SQLiteAdapter2 openToWrite() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();
		return this;	
	}
	
	public void close(){
		sqLiteHelper.close();
	}
	
	public long insert(String extactedsample,String primerpair,String dateofinput,String successful,String dateofsendtosequencing){
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_EXTRACTEDSAMPLE, extactedsample);
		contentValues.put(KEY_PRIMERPAIR, primerpair);
		contentValues.put(KEY_DATEOFINPUT, dateofinput);
		contentValues.put(KEY_SUCCESSFULL, successful);
		contentValues.put(KEY_DATEOFSENDTOSEQUENCING, dateofsendtosequencing);
		
		
		return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
	}
	
	public int deleteAll(){
		return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
	}
	

	
	
	 public String queueAll(){
		  String[] columns = new String[]{KEY_EXTRACTEDSAMPLE};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_EXTRACTEDSAMPLE);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }
	 public String queueAll1(){
		  String[] columns = new String[]{KEY_PRIMERPAIR};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_PRIMERPAIR);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }
	 public String queueAll2(){
		  String[] columns = new String[]{KEY_DATEOFINPUT};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_DATEOFINPUT);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }
	 public String queueAll3(){
		  String[] columns = new String[]{KEY_SUCCESSFULL};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_SUCCESSFULL);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }
	 public String queueAll4(){
		  String[] columns = new String[]{KEY_DATEOFSENDTOSEQUENCING};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_DATEOFSENDTOSEQUENCING);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }
	
//	public Cursor queue(String _na){
//		String[] columns = new String[]{KEY_ID,KEY_SPECIMENCODE,KEY_GENUS,KEY_SPECIMENNAME,KEY_AUTHORITY,KEY_BOXNO,KEY_BOXROW,KEY_BOXCOLUMN,KEY_HOSTGENUS,KEY_HOSTSPECIMEN,KEY_LOCALITY,KEY_LATITUDE,KEY_LONGITUDE,KEY_DISTRICT,KEY_PROVINCE,KEY_COUNTRY,KEY_DETERMINEDBY,KEY_COLLECTEDBY,KEY_DATACOLLECTED,KEY_COLLECTIONNOTES,KEY_NOTES,KEY_ABUNDANCE,KEY_COMMENT};
//		String[] col=new String[]{_na+"%",_na+"%"};
//		Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
//				KEY_SNAME  + " LIKE ?" + " or " + KEY_RNAME  + " LIKE ?" ,col, null, null, null);
//		
//		return cursor;
//	}

	
	public class SQLiteHelper extends SQLiteOpenHelper {

		public SQLiteHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(SCRIPT_CREATE_DATABASE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}

	}
	
	public int getRowCount() {
		String countQuery = "SELECT  * FROM " + MYDATABASE_TABLE ;
		Cursor cursor = sqLiteDatabase.rawQuery(countQuery, null);
		int rowCount = cursor.getCount();
		sqLiteDatabase.close();
		cursor.close();
		
		// return row count
		return rowCount;
	}
	
}
