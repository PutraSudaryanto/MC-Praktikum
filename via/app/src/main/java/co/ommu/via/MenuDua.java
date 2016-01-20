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

public class MenuDua extends Activity implements OnClickListener {

	SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

	TableLayout tabelBiodata;
	Button btn3;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tinggi);

		tabelBiodata = (TableLayout) findViewById(R.id.tableBiodata);
		btn3 = (Button)findViewById(R.id.btn3);
		
		Button btn3 = (Button) findViewById(R.id.btn3);
		btn3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				setResult(RESULT_OK);
				finish();
			}
		});

		TableRow barisTabel = new TableRow(this);
		barisTabel.setBackgroundColor(Color.LTGRAY);

		TextView viewHeaderId = new TextView(this);
		TextView viewHeaderNama = new TextView(this);
		TextView viewHeaderNilai = new TextView(this);
		
		viewHeaderId.setText("ID");
		viewHeaderNama.setText("Nama");
		viewHeaderNilai.setText("Nilai");
		

		viewHeaderId.setPadding(26, 1, 26, 1);
		viewHeaderNama.setPadding(26, 1, 26, 1);
		viewHeaderNilai.setPadding(26, 1, 26, 1);
		
		barisTabel.addView(viewHeaderId);
		barisTabel.addView(viewHeaderNama);
		barisTabel.addView(viewHeaderNilai);
		

		tabelBiodata.addView(barisTabel, new TableLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

		ArrayList<HashMap<String, String>> arrayListBiodata = sqLiteHelper
				.tampil_rangking();

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
				viewId.setPadding(26, 1, 26, 1);
				barisTabel.addView(viewId);

				TextView viewNama = new TextView(this);
				viewNama.setText(name);
				viewNama.setPadding(26, 1, 26, 1);
				barisTabel.addView(viewNama);

				TextView viewNilai = new TextView(this);
				viewNilai.setText(nilai);
				viewNilai.setPadding(26, 1, 26, 1);
				barisTabel.addView(viewNilai);
				
				


				tabelBiodata.addView(barisTabel, new TableLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

			}
		}

	}

	@Override
	public void onClick(View view) {

				
		
	}

}