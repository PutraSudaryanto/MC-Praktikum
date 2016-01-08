package co.ommu.mcp5soal1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityDua extends Activity implements View.OnClickListener {
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_dua);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_main_activity2, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back) {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivityForResult(i, 0);
        } else {
            Toast.makeText(getBaseContext(), "Salah", Toast.LENGTH_LONG).show();
            back.setText("Salah Le... ~");
        }
    }
}
