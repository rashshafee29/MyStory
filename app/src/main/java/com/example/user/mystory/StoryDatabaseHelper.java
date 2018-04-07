package com.example.user.mystory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class StoryDatabaseHelper {

    private static final String TAG = StoryDatabaseHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "storyDB.db";

    //table configuration
    private static final String TABLE_NAME = "story_table";
    private static final String STORY_TABLE_COLUMN_ID = "_id";//Must _id for custom Adapter
    private static final String STORY_TABLE_COLUMN_TITLE = "story_title";
    private static final String STORY_TABLE_COLUMN_ABOUT = "story_about";
    private static final String STORY_TABLE_COLUMN_TIME = "story_time";
    private static final String STORY_TABLE_COLUMN_TEXT = "story_text";

    private DatabaseOpenHelper openHelper;
    private SQLiteDatabase sqLiteDatabase;

    public StoryDatabaseHelper(Context context) {
        openHelper = new DatabaseOpenHelper(context);
        sqLiteDatabase = openHelper.getWritableDatabase();
    }

    private class DatabaseOpenHelper extends SQLiteOpenHelper {
        public DatabaseOpenHelper(Context context) {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String buildSQL = "CREATE TABLE " + TABLE_NAME + "( " + STORY_TABLE_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    STORY_TABLE_COLUMN_TITLE + " TEXT, " + STORY_TABLE_COLUMN_ABOUT + " TEXT, " + STORY_TABLE_COLUMN_TIME +
                    " TEXT, " + STORY_TABLE_COLUMN_TEXT + " TEXT )";
            Log.d(TAG, "On create sql:"+ buildSQL);
            db.execSQL(buildSQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String buildSQL = "DROP TABLE IF EXISTS " + TABLE_NAME;

            Log.d(TAG, "onUpgrade SQL: " + buildSQL);

            db.execSQL(buildSQL);       // drop previous table

            onCreate(db);
        }
    }
}
