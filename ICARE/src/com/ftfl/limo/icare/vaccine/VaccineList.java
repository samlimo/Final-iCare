package com.ftfl.limo.icare.vaccine;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.ftfl.limo.icare.R;
import com.ftfl.limo.icare.diet.DietList;
import com.ftfl.limo.icare.doctor.DoctorList;
import com.ftfl.limo.icare.emergency.ShakeActivity;
import com.ftfl.limo.icare.notes.NoteList;

public class VaccineList extends ListActivity {

	private static final int ACTIVITY_CREATE = 0;
	private static final int ACTIVITY_EDIT = 1;

	private static final int DELETE_ID = Menu.FIRST;
	private int mNoteNumber = 1;

	private VaccineDbAdapter mDbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vaccinelist);
		mDbHelper = new VaccineDbAdapter(this);
		mDbHelper.open();
		fillData();
		registerForContextMenu(getListView());
		Button addnote = (Button) findViewById(R.id.addnotebutton);
		addnote.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				createNote();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.notes:

			Intent intent = new Intent(this, NoteList.class);
			startActivity(intent);

			return true;
		case R.id.diet:

			Intent intentDt = new Intent(this, DietList.class);
			startActivity(intentDt);

			return true;
		case R.id.vaccination:

			Intent intentDr = new Intent(this, VaccineList.class);
			startActivity(intentDr);

			return true;
		case R.id.doctor:

			Intent intentMh = new Intent(this, DoctorList.class);
			startActivity(intentMh);

			return true;
		case R.id.emergency:

			Intent intentSh = new Intent(this, ShakeActivity.class);
			startActivity(intentSh);

			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void createNote() {
		Intent i = new Intent(this, VaccineEdit.class);
		startActivityForResult(i, ACTIVITY_CREATE);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent i = new Intent(this, VaccineEdit.class);
		i.putExtra(VaccineDbAdapter.KEY_ROWID, id);
		startActivityForResult(i, ACTIVITY_EDIT);
	}

	private void fillData() {
		// Get all of the notes from the database and create the item list
		Cursor notesCursor = mDbHelper.fetchAllNotes();
		startManagingCursor(notesCursor);

		String[] from = new String[] { VaccineDbAdapter.KEY_TITLE,
				VaccineDbAdapter.KEY_DATE };
		int[] to = new int[] { R.id.text1, R.id.date_row };

		// Now create an array adapter and set it to display using our row
		SimpleCursorAdapter notes = new SimpleCursorAdapter(this,
				R.layout.notes_row, notesCursor, from, to);
		setListAdapter(notes);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, DELETE_ID, 0, R.string.menu_delete);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case DELETE_ID:
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			mDbHelper.deleteNote(info.id);
			fillData();
			return true;
		}
		return super.onContextItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		fillData();
	}

}
