package com.ei.microapp;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter1 {

	public static final String MYDATABASE_NAME = "micro1";
	public static final String MYDATABASE_TABLE = "data";
	public static final int MYDATABASE_VERSION = 1;
	public static final String KEY_ID = "_id";
		public static final String KEY_SPECIMENCODE = "specimencode";
		public static final String KEY_EXTRACTIONCODE = "extractioncode";
		public static final String KEY_NOTES = "notes";
		public static final String KEY_DATEEXTRACTED = "dateextracted";
		public static final String KEY_USER= "user";
		public static final String KEY_BOXNO = "boxno";
		public static final String KEY_BOXROW = "boxrow";
		public static final String KEY_BOXCOLUMN = "boxcolumn";
		
	
	private static final String SCRIPT_CREATE_DATABASE =
		"create table " + MYDATABASE_TABLE + " ("
		+ KEY_ID + " integer primary key autoincrement, "
		+ KEY_SPECIMENCODE + " text, " + KEY_EXTRACTIONCODE + " text, " + KEY_NOTES + " text, " + KEY_DATEEXTRACTED + " text, " + KEY_USER + " text, " + KEY_BOXNO + " text, " + KEY_BOXROW + " text, " + KEY_BOXCOLUMN + " text);";
	
	private SQLiteHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;

	private Context context;
	
	public SQLiteAdapter1(Context c){
		context = c;
	}
	
	public SQLiteAdapter1 openToRead() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();
		return this;	
	}
	
	public SQLiteAdapter1 openToWrite() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();
		return this;	
	}
	
	public void close(){
		sqLiteHelper.close();
	}
	
	public long insert(String specimencode,String extractioncode,String notes,String dateextracted,String User,String boxno,String boxrow,String boxcolumn){
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_SPECIMENCODE, specimencode);
		contentValues.put(KEY_EXTRACTIONCODE, extractioncode);
		contentValues.put(KEY_NOTES, notes);
		contentValues.put(KEY_DATEEXTRACTED, dateextracted);
		contentValues.put(KEY_USER, User);
		contentValues.put(KEY_BOXNO, boxno);
		contentValues.put(KEY_BOXROW, boxrow);
		contentValues.put(KEY_BOXCOLUMN, boxcolumn);
		
	
		
		
		return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
	}
	
	public int deleteAll(){
		return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
	}
	
	 public String queueAll(){
		  String[] columns = new String[]{KEY_SPECIMENCODE};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_SPECIMENCODE);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll1(){
		  String[] columns = new String[]{KEY_EXTRACTIONCODE};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_EXTRACTIONCODE);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll2(){
		  String[] columns = new String[]{KEY_NOTES};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_NOTES);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll3(){
		  String[] columns = new String[]{KEY_DATEEXTRACTED};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_DATEEXTRACTED);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll4(){
		  String[] columns = new String[]{KEY_USER};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_USER);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll5(){
		  String[] columns = new String[]{KEY_BOXNO};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_BOXNO);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll6(){
		  String[] columns = new String[]{KEY_BOXROW};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_BOXROW);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll7(){
		  String[] columns = new String[]{KEY_BOXCOLUMN};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_BOXCOLUMN);
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
