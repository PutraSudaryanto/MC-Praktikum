package co.ommu.via;

import java.util.ArrayList;
import java.util.HashMap;

import co.ommu.via.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MenuSatu extends Activity implements OnClickListener {

	SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

	TableLayout tabelBiodata;
	Button buttonTambahBiodata;
	Button btn2;
	ArrayList<Button> buttonEdit = new ArrayList<Button>();
	ArrayList<Button> buttonDelete = new ArrayList<Button>();
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tabelBiodata = (TableLayout) findViewById(R.id.tableBiodata);
		buttonTambahBiodata = (Button) findViewById(R.id.buttonTambahBiodata);
		btn2 = (Button)findViewById(R.id.btn2);
		buttonTambahBiodata.setOnClickListener(this);

		TableRow barisTabel = new TableRow(this);
		barisTabel.setBackgroundColor(Color.LTGRAY);
		
		Button btn2 = (Button) findViewById(R.id.btn2);
		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				setResult(RESULT_OK);
				finish();
			}
		});

		TextView viewHeaderId = new TextView(this);
		TextView viewHeaderNama = new TextView(this);
		TextView viewHeaderNilai = new TextView(this);
		TextView viewHeaderAction = new TextView(this);

		viewHeaderId.setText("ID");
		viewHeaderNama.setText("Nama");
		viewHeaderNilai.setText("Nilai");
		viewHeaderAction.setText("Action");

		viewHeaderId.setPadding(7, 1, 7, 1);
		viewHeaderNama.setPadding(10, 1, 10, 1);
		viewHeaderNilai.setPadding(10, 1, 10, 1);
		viewHeaderAction.setPadding(10, 1, 10, 1);

		barisTabel.addView(viewHeaderId);
		barisTabel.addView(viewHeaderNama);
		barisTabel.addView(viewHeaderNilai);
		barisTabel.addView(viewHeaderAction);

		tabelBiodata.addView(barisTabel, new TableLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		ArrayList<HashMap<String, String>> arrayListBiodata = sqLiteHelper
				.tampil_semua_biodata();

		if (arrayListBiodata.size() > 0) {

			for (int i = 0; i < arrayListBiodata.size(); i++) {

				// ambil masing-masing hasmap dari arrayListBiodata
				HashMap<String, String> hashMapRecordBiodata = arrayListBiodata
						.get(i);

				
				String name = hashMapRecordBiodata.get("nama");
				String nilai = hashMapRecordBiodata.get("nilai");
				String id = hashMapRecordBiodata.get("id_biodata");

				System.out.println("Nama :" + name);
				System.out.println("nilai :" + nilai);
				System.out.println("ID :" + id);

				barisTabel = new TableRow(this);

				TextView viewId = new TextView(this);
				viewId.setText(id);
				viewId.setPadding(10, 1, 10, 1);
				barisTabel.addView(viewId);

				TextView viewNama = new TextView(this);
				viewNama.setText(name);
				viewNama.setPadding(10, 1, 10, 1);
				barisTabel.addView(viewNama);

				TextView viewNilai = new TextView(this);
				viewNilai.setText(nilai);
				viewNilai.setPadding(10, 1, 10, 1);
				barisTabel.addView(viewNilai);

				buttonEdit.add(i, new Button(this));
				buttonEdit.get(i).setId(Integer.parseInt(id));
				buttonEdit.get(i).setTag("Edit");
				buttonEdit.get(i).setText("Edit");
				buttonEdit.get(i).setOnClickListener(this);
				barisTabel.addView(buttonEdit.get(i));

				buttonDelete.add(i, new Button(this));
				buttonDelete.get(i).setId(Integer.parseInt(id));
				buttonDelete.get(i).setTag("Delete");
				buttonDelete.get(i).setText("Delete");
				buttonDelete.get(i).setOnClickListener(this);
				barisTabel.addView(buttonDelete.get(i));

				tabelBiodata.addView(barisTabel, new TableLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

			}
		}

	}

	@Override
	public void onClick(View view) {

		if 		(view.getId() == R.id.buttonTambahBiodata) {
			// Toast.makeText(MainActivity.this, "Button Tambah Data",
			// Toast.LENGTH_SHORT).show();

			tambahBiodata();

			
		}
		
		else 
			
		
		{
			/*
			 * Melakukan pengecekan pada data array, agar sesuai dengan index
			 * masing-masing button
			 */
			for (int i = 0; i < buttonEdit.size(); i++) {

				/* jika yang diklik adalah button edit */
				if (view.getId() == buttonEdit.get(i).getId()
						&& view.getTag().toString().trim().equals("Edit")) {
					// Toast.makeText(MainActivity.this, "Edit : " +
					// buttonEdit.get(i).getId(), Toast.LENGTH_SHORT).show();
					int id = buttonEdit.get(i).getId();
					getDataByID(id);

				} /* jika yang diklik adalah button delete */
				else if (view.getId() == buttonDelete.get(i).getId()
						&& view.getTag().toString().trim().equals("Delete")) {
					// Toast.makeText(MainActivity.this, "Delete : " +
					// buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
					int id = buttonDelete.get(i).getId();
					deleteBiodata(id);

				}
			}
		}
		
	}

	    public void onBackPressed(View v) {
	    	 moveTaskToBack(true);
	         return;
	      
	}

	public void deleteBiodata(int id) {

		sqLiteHelper.hapus_biodata(id);

		/* restart acrtivity */
		finish();
		startActivity(getIntent());

	}

	public void getDataByID(int id) {

		String namaEdit = null, nilaiEdit = null;

		HashMap<String, String> hashMapBiodata = sqLiteHelper
				.tampil_biodata_berdasarkan_id(id);

		for (int i = 0; i < hashMapBiodata.size(); i++) {
			namaEdit = hashMapBiodata.get("nama");
			nilaiEdit = hashMapBiodata.get("nilai");
		}

		LinearLayout layoutInput = new LinearLayout(this);
		layoutInput.setOrientation(LinearLayout.VERTICAL);

		// buat id tersembunyi di alertbuilder
		final TextView viewId = new TextView(this);
		viewId.setText(String.valueOf(id));
		viewId.setTextColor(Color.TRANSPARENT);
		layoutInput.addView(viewId);

		final EditText editNama = new EditText(this);
		editNama.setText(namaEdit);
		layoutInput.addView(editNama);

		final EditText editNilai = new EditText(this);
		editNilai.setText(nilaiEdit);
		layoutInput.addView(editNilai);

		AlertDialog.Builder builderEditBiodata = new AlertDialog.Builder(this);
		builderEditBiodata.setTitle("Edit Nilai");
		builderEditBiodata.setView(layoutInput);
		builderEditBiodata.setPositiveButton("Edit",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String nama = editNama.getText().toString();
						String nilai = editNilai.getText().toString();

						System.out.println("Nama : " + nama + " Nilai : "
								+ nilai);

						sqLiteHelper.update_biodata(Integer.parseInt(viewId
								.getText().toString()), editNama.getText()
								.toString(), Integer.parseInt(editNilai.getText().toString()));
						/* restart acrtivity */
						finish();
						startActivity(getIntent());
					}

				});

		builderEditBiodata.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		builderEditBiodata.show();

	}

	
	
	public void tambahBiodata() {
		/* layout akan ditampilkan pada AlertDialog */
		LinearLayout layoutInput = new LinearLayout(this);
		layoutInput.setOrientation(LinearLayout.VERTICAL);

		final EditText editNama = new EditText(this);
		editNama.setHint("Nama");
		layoutInput.addView(editNama);

		final EditText editNilai = new EditText(this);
		editNilai.setHint("Nilai");
		layoutInput.addView(editNilai);

		AlertDialog.Builder builderInsertBiodata = new AlertDialog.Builder(this);
		builderInsertBiodata.setTitle("Tambah Data Nilai");
		builderInsertBiodata.setView(layoutInput);
		builderInsertBiodata.setPositiveButton("Input",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String nama = editNama.getText().toString();
						String nilai = editNilai.getText().toString();

						System.out.println("Nama : " + nama + " nilai : "
								+ nilai);

						sqLiteHelper.tambah_biodata(nama, Integer.parseInt(nilai));
						/* restart acrtivity */
						finish();
						startActivity(getIntent());
					}

				});

		builderInsertBiodata.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		builderInsertBiodata.show();
	}
}