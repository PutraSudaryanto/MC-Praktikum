package co.ommu.efibriyani096;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Spinner spinnerSearch;
    Button btnLuas, btnKeliling;
    int selected;
    String[] searching = {"persegi", "perseginpanjang", "segitiga", "lingkaran"};
    String bangun, function; //function: 1=luas, 0=keliling

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerSearch = (Spinner) findViewById(R.id.spinner_bangun);
        btnLuas = (Button) findViewById(R.id.button_luas);
        btnKeliling = (Button) findViewById(R.id.button_keliling);
        btnLuas.setOnClickListener(this);
        btnKeliling.setOnClickListener(this);

        spinnerSearch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3) {
                // TODO Auto-generated method stub
                selected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();

        bangun = searching[selected];
        if (id == R.id.button_luas) {
            startActivity(new Intent(getApplicationContext(), FunctionActivity.class)
                    .putExtra("bangun", bangun)
                    .putExtra("function", "1"));

        } else if (id == R.id.button_keliling) {
            startActivity(new Intent(getApplicationContext(), FunctionActivity.class)
                    .putExtra("bangun", bangun)
                    .putExtra("function", "0"));
        }
    }
}
