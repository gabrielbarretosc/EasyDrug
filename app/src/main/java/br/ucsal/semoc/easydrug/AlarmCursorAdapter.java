package br.ucsal.semoc.easydrug;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class AlarmCursorAdapter extends CursorAdapter {

    public AlarmCursorAdapter(Context context, Cursor c) {
        super(context,c,false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(
                R.layout.activity_lista, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(R.id.editText);
        String remedioNome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
             textView.setText(remedioNome);
}
}
