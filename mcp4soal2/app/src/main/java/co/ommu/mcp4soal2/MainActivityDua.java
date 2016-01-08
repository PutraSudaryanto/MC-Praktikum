package co.ommu.mcp4soal2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityDua extends Activity implements View.OnClickListener {
    Button hasil, back, exit;
    EditText berat, tinggi;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dua);

        berat = (EditText) findViewById(R.id.berat);
        tinggi = (EditText) findViewById(R.id.tinggi);
        output = (TextView) findViewById(R.id.output);
        hasil = (Button) findViewById(R.id.hasil);
        back = (Button) findViewById(R.id.back);
        exit = (Button) findViewById(R.id.exit);
        hasil.setOnClickListener(this);
        back.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        int angka = 110; //angka ideal
        int angka1 = 0, angka2 = 0;
        if (!berat.getText().toString().equals(""))
            angka1 = Integer.parseInt(berat.getText().toString());

        //merubah dari string edittext ke integer
        if (!tinggi.getText().toString().equals(""))
            angka2 = Integer.parseInt(tinggi.getText().toString());
        int ideal = angka2 - angka1; //berat badan ideal
        int ideal2 = angka2 - angka; //berat badan yang disarankan

        try {
            if (v.getId() == R.id.hasil) { //button hasil
                if (ideal == 110) {
                    output.setText("Berat Badan Anda Ideal");
                } else if (ideal > 110) {
                    output.setText("Anda Kurus");
                } else {

                    output.setText("Anda Gemuk, berat Anda" + angka1 + " Tinggi Anda " + angka2 + " Seharusnya Berat badan anda " + ideal2);
                }
            } else if (v.getId() == R.id.exit) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Apakah Anda Ingin Keluar?").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivityDua.this.finish();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            } else if (v.getId() == R.id.back) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivityForResult(i, 0);
            } else {
                Toast.makeText(getBaseContext(), "Masukkan Berat dan Tinggi Badan Anda", Toast.LENGTH_SHORT).show();
                output.setText("Masukkan Angka Dulu");
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Hahaha", Toast.LENGTH_SHORT).show();
        }
    }
}
