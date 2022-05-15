package sv.edu.udb.guia12app.content.guia12app.content.provider;

import androidx.loader.content.CursorLoader;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

public class MainActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {


private StudentsAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adaptador = new StudentsAdapter(this);
        setListAdapter(adaptador);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new android.content.CursorLoader(
                this,
                StudentsContract.CONTENT_URI,
                null, null, null, null);
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        adaptador.swapCursor(data);
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        adaptador.swapCursor(null);
    }

}