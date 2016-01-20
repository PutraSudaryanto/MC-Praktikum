package co.ommu.efibriyani096;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FunctionActivity extends Activity implements View.OnClickListener {

    public boolean validation = false;
    EditText etPanjang, etLebar, etSisi, etAlas, etTinggi, etJarijari;
    LinearLayout layoutPersegiPanjang, layoutPersegi, layoutLingkaran, layoutSegitiga;
    Button btnFunction;
    String stringFunction, bangun, function;                //function: 1=luas, 0=keliling
    public static int panjang, lebar, sisi, alas, tinggi, jarijari;
    public static double luas, keliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        layoutPersegiPanjang = (LinearLayout) findViewById(R.id.boxPersegiPanjang);
        layoutPersegi = (LinearLayout) findViewById(R.id.boxPersegi);
        layoutLingkaran = (LinearLayout) findViewById(R.id.boxLingkaran);
        layoutSegitiga = (LinearLayout) findViewById(R.id.boxSegitiga);
        btnFunction = (Button) findViewById(R.id.button_function);
        layoutPersegiPanjang.setVisibility(View.GONE);
        layoutPersegi.setVisibility(View.GONE);
        layoutLingkaran.setVisibility(View.GONE);
        layoutSegitiga.setVisibility(View.GONE);
        btnFunction.setOnClickListener(this);

        if (getIntent().getExtras() != null) {
            bangun = getIntent().getExtras().getString("bangun");
            function = getIntent().getExtras().getString("function");
            Log.i("bangun", bangun);
            if (function.toString().equals("1"))
                stringFunction = "Luas";
            else
                stringFunction = "Keliling";
            Log.i("stringFunction", stringFunction);
            getResult();
        }

        etPanjang = (EditText) findViewById(R.id.field_panjang);
        etLebar = (EditText) findViewById(R.id.field_lebar);
        etSisi = (EditText) findViewById(R.id.field_sisi);
        etAlas = (EditText) findViewById(R.id.field_alas);
        etTinggi = (EditText) findViewById(R.id.field_tinggi);
        etJarijari = (EditText) findViewById(R.id.field_jari);
    }

    private void getResult() {
        if (bangun.toString().equals("persegi"))
            layoutPersegi.setVisibility(View.VISIBLE);
        else if (bangun.toString().equals("perseginpanjang"))
            layoutPersegiPanjang.setVisibility(View.VISIBLE);
        else if (bangun.toString().equals("segitiga"))
            layoutSegitiga.setVisibility(View.VISIBLE);
        else if (bangun.toString().equals("lingkaran"))
            layoutLingkaran.setVisibility(View.VISIBLE);
        btnFunction.setText(stringFunction);
    }

    public void getValidation() {
        if (bangun.toString().equals("persegi")) {
            if (etSisi.getText().toString().equals(""))
                Toast.makeText(getBaseContext(), "sisi tidak boleh kosong", Toast.LENGTH_LONG).show();
            else {
                validation = true;
                sisi = Integer.parseInt(etSisi.getText().toString());
                luas = sisi * sisi;
                keliling = 4 * sisi;
            }

        } else if (bangun.toString().equals("perseginpanjang")) {
            if (etPanjang.getText().toString().equals("") && etLebar.getText().toString().equals(""))
                Toast.makeText(getBaseContext(), "Panjang dan Lebar tidak boleh kosong", Toast.LENGTH_LONG).show();
            else {
                if (etPanjang.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Panjang tidak boleh kosong", Toast.LENGTH_LONG).show();
                if (etLebar.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Lebar tidak boleh kosong", Toast.LENGTH_LONG).show();
                if (!etPanjang.getText().toString().equals("") && !etLebar.getText().toString().equals("") && (Integer.parseInt(etPanjang.getText().toString()) >= Integer.parseInt(etLebar.getText().toString()))) {
                    validation = true;
                    panjang = Integer.parseInt(etPanjang.getText().toString());
                    lebar = Integer.parseInt(etLebar.getText().toString());
                    luas = panjang * lebar;
                    keliling = 2 * (panjang + lebar);
                }  else
                    Toast.makeText(getBaseContext(), "Panjang harus lebih besar dari Lebar", Toast.LENGTH_LONG).show();
            }

        } else if (bangun.toString().equals("segitiga")) {
            if (etAlas.getText().toString().equals("") && etTinggi.getText().toString().equals(""))
                Toast.makeText(getBaseContext(), "Alas dan Tinggi tidak boleh kosong", Toast.LENGTH_LONG).show();
            else {
                if (etAlas.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Alas tidak boleh kosong", Toast.LENGTH_LONG).show();
                if (etTinggi.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Tinggi tidak boleh kosong", Toast.LENGTH_LONG).show();
                if (!etAlas.getText().toString().equals("") && !etTinggi.getText().toString().equals("") && (Integer.parseInt(etTinggi.getText().toString()) >= Integer.parseInt(etAlas.getText().toString()))) {
                    validation = true;
                    alas = Integer.parseInt(etAlas.getText().toString());
                    tinggi = Integer.parseInt(etTinggi.getText().toString());
                    luas = 2 * ((alas/2) * tinggi);
                    keliling = alas + (2 * tinggi);
                } else
                    Toast.makeText(getBaseContext(), "Tinggi harus lebih besar dari Alas", Toast.LENGTH_LONG).show();
            }

        } else if (bangun.toString().equals("lingkaran")) {
            if (etJarijari.getText().toString().equals(""))
                Toast.makeText(getBaseContext(), "Jari-jari tidak boleh kosong", Toast.LENGTH_LONG).show();
            else {
                validation = true;
                jarijari = Integer.parseInt(etJarijari.getText().toString());
                luas = 3.14 * (jarijari * jarijari);
                keliling = 3.14 * (2 * jarijari);
            }
        }
    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();

        if (id == R.id.button_function) {
            getValidation();
            if (validation) {
                startActivity(new Intent(getApplicationContext(), ResultActivity.class)
                        .putExtra("bangun", bangun)
                        .putExtra("function", function)
                        .putExtra("stringFunction", stringFunction));
            }
        }
    }
}