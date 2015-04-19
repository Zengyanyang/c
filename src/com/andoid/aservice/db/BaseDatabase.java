package com.andoid.aservice.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class BaseDatabase {
	protected String TABLE_NAME = null;

	public void Insert(SQLiteDatabase db, ContentValues values) {
		db.insert(TABLE_NAME, null, values);
	}

	public void Delete(SQLiteDatabase db, String whereClause, String[] whereArgs) {
		db.delete(TABLE_NAME, whereClause, whereArgs);
	}

	public void Update(SQLiteDatabase db, ContentValues values,
			String whereClause, String[] whereArgs) {
		db.update(TABLE_NAME, values, whereClause, whereArgs);
	}

	public Cursor Query(SQLiteDatabase db, String sql, String[] selectionArgs) {
		return db.rawQuery(sql, selectionArgs);
	}
}
