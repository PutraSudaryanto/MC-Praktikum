package co.ommu.mcp5soal2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener, TextWatcher, RadioGroup.OnCheckedChangeListener {
    EditText nama, nim;
    TextView seleksi;
    AutoCompleteTextView provinsi;
    RadioGroup jk;
    CheckBox ya;

    String item[] = {"Jawa Tengah", "Jawa Timur", "Jawa  Barat", "Sumatera Selatan", "Sumatera Utara"};
    ImageButton create;
    String user = "yuni", pass = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seleksi = (TextView)findViewById(R.id.seleksi);
        provinsi = (AutoCompleteTextView)findViewById(R.id.provinsi);
        provinsi.addTextChangedListener(this);
        provinsi.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item));
        nama = (EditText)findViewById(R.id.nama);
        nim = (EditText)findViewById(R.id.nim);
        create = (ImageButton)findViewById(R.id.create);
        create.setOnClickListener(this);
        ya = (CheckBox)findViewById(R.id.ya);
        jk = (RadioGroup)findViewById(R.id.jk);
        jk.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View arg0) {
        try{
            if(arg0.getId() == R.id.create){
                Intent i = new Intent(getBaseContext(),	MainActivityDua.class);
                startActivityForResult(i, 0);
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Anda Tidak Berhak Masuk", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        seleksi.setText(provinsi.getText());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    }


}
