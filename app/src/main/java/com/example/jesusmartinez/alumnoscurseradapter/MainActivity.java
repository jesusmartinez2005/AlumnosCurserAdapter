package com.example.jesusmartinez.alumnoscurseradapter;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity implements LoaderManager.LoaderCallbacks{


    private SimpleCursorAdapter cursorAdapter;
    AlumnosDatabase database = new AlumnosDatabase(this);

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        // return new CursorLoader(this,"alumnos",null, null ,null, null);    }
        return null;
    }
    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }

    @Override
    public void onLoaderReset(Loader loader) {

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.ok);
        final EditText nombre=(EditText)findViewById(R.id.nombre);
        final EditText grupo=(EditText)findViewById(R.id.grupo);

        final SQLiteDatabase db=database.getReadableDatabase();
        final Cursor cursor=db.query("alumnos", null, null, null, null, null, null);

        final String[] from = new String[] {"nombre","grupo"};
        final int[] to = new int[] {android.R.id.text1,android.R.id.text2};
        cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_2, cursor, from, to, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        setListAdapter(cursorAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.nuevoalumno(database.getWritableDatabase(),nombre.getText().toString(),grupo.getText().toString());
            //    cursorAdapter.changeCursor(cursor);
              //  cursorAdapter.changeCursorAndColumns(cursor,from,to);
                setListAdapter(cursorAdapter);



            }
        });

    }


}
