package co.ommu.mcp5soal1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText a, b, c;
    Button tambah, kurang, kali, bagi, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (EditText)findViewById(R.id.a);
        b = (EditText)findViewById(R.id.b);
        c = (EditText)findViewById(R.id.c);

        tambah = (Button)findViewById(R.id.tambah);
        kurang = (Button)findViewById(R.id.kurang);
        kali = (Button)findViewById(R.id.kali);
        bagi = (Button)findViewById(R.id.bagi);
        next = (Button)findViewById(R.id.next);

        tambah.setOnClickListener(this);
        kurang.setOnClickListener(this);
        kali.setOnClickListener(this);
        bagi.setOnClickListener(this);
        next.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int angka1 = 0, angka2 = 0;
        if (!a.getText().toString().equals(""))
            angka1 = Integer.parseInt(a.getText().toString());
        if (!b.getText().toString().equals(""))
            angka2 = Integer.parseInt(b.getText().toString());

        try {
            if(!a.getText().toString().equals("") && !b.getText().toString().equals("")) {
                if (v.getId() == R.id.tambah) {
                    int hasil = angka1 + angka2;
                    c.setText(Integer.toString(hasil));
                } else if (v.getId() == R.id.kurang) {
                    int hasil2 = angka1 - angka2;
                    c.setText(Integer.toString(hasil2));
                } else if (v.getId() == R.id.kali) {
                    int hasil3 = angka1 * angka2;
                    c.setText(Integer.toString(hasil3));
                } else if (v.getId() == R.id.bagi) {
                    double hasil4 = angka1 / angka2;
                    c.setText(Double.toString(hasil4));
                } else {
                    Intent i = new Intent(getBaseContext(), MainActivityDua.class);
                    //Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult(i, 0);
                }
            } else
                Toast.makeText(getBaseContext(), "Input 1 dan Input 2 tidak boleh kosong", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Salah", Toast.LENGTH_LONG).show();
            c.setText("Tak Terhingga ~");
        }
        // ketiga.settext(string.valueof(hasil)).tostring());

    }
}
