package co.ommu.efibriyani096;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity implements View.OnClickListener {

    TextView tvResult;
    Button btnBack;
    String bangun, function, stringFunction,
            valueText;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = (TextView) findViewById(R.id.text_result);
        btnBack = (Button) findViewById(R.id.button_back);
        btnBack.setOnClickListener(this);

        if (getIntent().getExtras() != null) {
            bangun = getIntent().getExtras().getString("bangun");
            function = getIntent().getExtras().getString("function");
            stringFunction = getIntent().getExtras().getString("stringFunction");
            getResult();
        }
    }

    private void getResult() {
        if (function.toString().equals("1"))
            result = FunctionActivity.luas;
        else
            result = FunctionActivity.keliling;

        if (bangun.toString().equals("persegi")) {
            valueText = stringFunction + " persegi dengan sisi " + FunctionActivity.sisi + " : " + result;
        } else if (bangun.toString().equals("perseginpanjang")) {
            valueText = stringFunction + " persegi panjang dengan panjang " + FunctionActivity.panjang + " dan lebar " + FunctionActivity.lebar + " : " + result;
        } else if (bangun.toString().equals("segitiga")) {
            valueText = stringFunction + " segitiga dengan alas " + FunctionActivity.alas + " dan tinggi " + FunctionActivity.tinggi + " : " + result;
        } else if (bangun.toString().equals("lingkaran")) {
            valueText = stringFunction + " lingkaran dengan jari-jari " + FunctionActivity.jarijari + " : " + result;
        }

        tvResult.setText(valueText);

    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();

        if (id == R.id.button_back) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

}
