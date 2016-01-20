package co.ommu.via;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class UasActivity extends Activity {

	MenuSatu e=new MenuSatu();
	MenuDua r=new MenuDua();
	MenuTiga k = new MenuTiga();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uas);
		
		TextView a = (TextView) findViewById(R.id.textView2);
		a.setOnClickListener(new View.OnClickListener() {
		public void onClick(View arg0) {
			// here i call new screen;
			Intent i = new Intent(UasActivity.this, MenuSatu.class);
			startActivity(i);
			}
		});
		
		TextView b = (TextView) findViewById(R.id.textView3);
		b.setOnClickListener(new View.OnClickListener() {
		public void onClick(View arg0) {
			// here i call new screen;
			Intent i = new Intent(UasActivity.this, MenuDua.class);
			startActivity(i);
			}
		});
		
		TextView c = (TextView) findViewById(R.id.textView4);
		c.setOnClickListener(new View.OnClickListener() {
		public void onClick(View arg0) {
			// here i call new screen;
			Intent i = new Intent(UasActivity.this, MenuTiga.class);
			startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uas, menu);
		return true;
	}
}
