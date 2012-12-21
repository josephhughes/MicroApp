package com.ei.microapp;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter {

	public static final String MYDATABASE_NAME = "micro";
	public static final String MYDATABASE_TABLE = "data";
	public static final int MYDATABASE_VERSION = 1;
	public static final String KEY_ID = "_id";
		public static final String KEY_SPECIMENCODE = "specimencode";
		public static final String KEY_GENUS = "genus";
		public static final String KEY_SPECIMENNAME = "specimenname";
		public static final String KEY_AUTHORITY = "authority";
		public static final String KEY_BOXNO = "boxno";
		public static final String KEY_BOXROW = "boxrow";
		public static final String KEY_BOXCOLUMN = "boxcolumn";
		public static final String KEY_HOSTGENUS = "hostgenus";
		public static final String KEY_HOSTSPECIMEN = "hostspecimen";
		public static final String KEY_LOCALITY = "locality";
		public static final String KEY_LATITUDE = "latitude";
		public static final String KEY_LONGITUDE = "longitude";
		public static final String KEY_DISTRICT = "district";
		public static final String KEY_PROVINCE = "province";
		public static final String KEY_COUNTRY = "country";
		public static final String KEY_DETERMINEDBY = "determinedby";
		public static final String KEY_COLLECTEDBY = "collectedby";
		public static final String KEY_DATACOLLECTED = "datacollected";
		public static final String KEY_COLLECTIONNOTES = "collectionnotes";
		public static final String KEY_NOTES = "notes";
		public static final String KEY_STAGESEX = "stagesex";
		public static final String KEY_ABUNDANCE = "abundance";
		public static final String KEY_COMMENT = "comment";
		public static final String KEY_Ti = "ti";
	private static final String SCRIPT_CREATE_DATABASE =
		"create table " + MYDATABASE_TABLE + " ("
		+ KEY_ID + " integer primary key autoincrement, "
		+ KEY_SPECIMENCODE + " text, " + KEY_GENUS + " text, " + KEY_SPECIMENNAME + " text, " + KEY_AUTHORITY + " text, " + KEY_BOXNO + " text, " + KEY_BOXROW + " text, " + KEY_BOXCOLUMN + " text, " + KEY_HOSTGENUS + " text, " + KEY_HOSTSPECIMEN + " text, " + KEY_LOCALITY + " text, " + KEY_LATITUDE + " text, " + KEY_LONGITUDE + " text, " + KEY_DISTRICT + " text, " + KEY_PROVINCE + " text, " + KEY_COUNTRY + " text, " + KEY_DETERMINEDBY + " text, " + KEY_COLLECTEDBY + " text, " + KEY_DATACOLLECTED + " text, " + KEY_COLLECTIONNOTES + " text, " + KEY_NOTES + " text, "
		+ KEY_STAGESEX + " text, " + KEY_ABUNDANCE + " text, " + KEY_COMMENT + " text, " + KEY_Ti + " text);";
	
	private SQLiteHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;

	private Context context;
	
	public SQLiteAdapter(Context c){
		context = c;
	}
	
	public SQLiteAdapter openToRead() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();
		return this;	
	}
	
	public SQLiteAdapter openToWrite() throws android.database.SQLException {
		sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();
		return this;	
	}
	
	public void close(){
		sqLiteHelper.close();
	}
	
	public long insert(String specimencode,String genus,String specimenname,String authority,String boxno,String boxrow,String boxcolumn,String hostgenus,String hostspecimen,String locality,String latitude,String longitude,String district,String province,String country,String determinedby,String collectedby,String datacollected,String collectionnotes,String notes,String stagesex,String abundance,String comment,String ti){
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_SPECIMENCODE, specimencode);
		contentValues.put(KEY_GENUS, genus);
		contentValues.put(KEY_SPECIMENNAME, specimenname);
		contentValues.put(KEY_AUTHORITY, authority);
		contentValues.put(KEY_BOXNO, boxno);
		contentValues.put(KEY_BOXROW, boxrow);
		contentValues.put(KEY_BOXCOLUMN, boxcolumn);
		contentValues.put(KEY_HOSTGENUS, hostgenus);
		contentValues.put(KEY_HOSTSPECIMEN, hostspecimen);
		contentValues.put(KEY_LOCALITY, locality);
		contentValues.put(KEY_LATITUDE, latitude);
		contentValues.put(KEY_LONGITUDE, longitude);
		contentValues.put(KEY_DISTRICT, district);
		contentValues.put(KEY_PROVINCE, province);
		contentValues.put(KEY_COUNTRY, country);
		contentValues.put(KEY_DETERMINEDBY, determinedby);
		contentValues.put(KEY_COLLECTEDBY, collectedby);
		contentValues.put(KEY_DATACOLLECTED, datacollected);
		contentValues.put(KEY_COLLECTIONNOTES, collectionnotes);
		contentValues.put(KEY_NOTES, notes);
		contentValues.put(KEY_STAGESEX,stagesex);
		contentValues.put(KEY_ABUNDANCE, abundance);
		contentValues.put(KEY_COMMENT, comment);
		contentValues.put(KEY_Ti, ti);
		
		return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
	}
	
	public int deleteAll(){
		return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
	}
	
	 public String queueAll00(){
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

	 public String queueAll01(){
		  String[] columns = new String[]{KEY_GENUS};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_GENUS);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll02(){
		  String[] columns = new String[]{KEY_SPECIMENNAME};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_SPECIMENNAME);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll03(){
		  String[] columns = new String[]{KEY_AUTHORITY};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_AUTHORITY);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }


	 public String queueAll04(){
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

	 public String queueAll05(){
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

	 public String queueAll06(){
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
	 public String queueAll07(){
		  String[] columns = new String[]{KEY_HOSTGENUS};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_HOSTGENUS);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll08(){
		  String[] columns = new String[]{KEY_HOSTSPECIMEN};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_HOSTSPECIMEN);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll09(){
		  String[] columns = new String[]{KEY_LOCALITY};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_LOCALITY);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll10(){
		  String[] columns = new String[]{KEY_LATITUDE};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_LATITUDE);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll11(){
		  String[] columns = new String[]{KEY_LONGITUDE};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_LONGITUDE);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll12(){
		  String[] columns = new String[]{KEY_DISTRICT};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_DISTRICT);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll13(){
		  String[] columns = new String[]{KEY_PROVINCE};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_PROVINCE);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll14(){
		  String[] columns = new String[]{KEY_COUNTRY};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_COUNTRY);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }
	 public String queueAll15(){
		  String[] columns = new String[]{KEY_DETERMINEDBY};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_DETERMINEDBY);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll16(){
		  String[] columns = new String[]{KEY_COLLECTEDBY};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_COLLECTEDBY);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll17(){
		  String[] columns = new String[]{KEY_DATACOLLECTED};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_DATACOLLECTED);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll18(){
		  String[] columns = new String[]{KEY_COLLECTIONNOTES};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_COLLECTIONNOTES);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll19(){
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

	 public String queueAll20(){
		  String[] columns = new String[]{KEY_ABUNDANCE};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_ABUNDANCE);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }

	 public String queueAll21(){
		  String[] columns = new String[]{KEY_COMMENT};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_COMMENT);
		  for(cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()){
		   result = result + cursor.getString(index_CONTENT) + " ";
		  }
		 
		  return result;
		 }
	 public String queueAll22(){
		  String[] columns = new String[]{KEY_Ti};
		  Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
		    null, null, null, null, null);
		  String result = "";
		  
		  int index_CONTENT = cursor.getColumnIndex(KEY_Ti);
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
