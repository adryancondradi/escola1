package com.example.escola;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtN1, edtN2;
    TextView txtM, txtSit;
    ImageView imgSit;
    LinearLayout layResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtN1 = findViewById(R.id.edtN1);
        edtN2 = findViewById(R.id.edtN2);
        txtM = findViewById(R.id.txtm);
        txtSit = findViewById(R.id.txtSit);
        imgSit = findViewById(R.id.imgSit);
        layResult = findViewById(R.id.layresultado);
    }

    public void calcular(View view) {
        boolean ok = true;
        if(edtN1.getText().toString().trim().isEmpty()){
            ok = false;
            edtN1.setError(getString(R.string.msgErro));
        }
        if(edtN2.getText().toString().trim().isEmpty()) {
            ok = false;
            edtN2.setError(getString(R.string.msgErro));
        }
        if (ok) {

            float n1 = Float.parseFloat(edtN1.getText().toString());
            float n2 = Float.parseFloat(edtN2.getText().toString());
            float m = (n1 = n2) / 2;

            txtM.setText(String.format("%.1f", m));

            if (m < 5) {
                txtSit.setText(getString(R.string.strSRp));
                txtSit.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(), getString(R.string.msgRp), Toast.LENGTH_LONG).show();
            } else if (m < 7) {
                txtSit.setText(getString(R.string.strSRe));
                txtSit.setTextColor(Color.YELLOW);
                Toast.makeText(getApplicationContext(), getString(R.string.msgRe), Toast.LENGTH_LONG).show();
            } else {
                txtSit.setText(getString(R.string.strSAp));
                txtSit.setTextColor(Color.BLUE);
                Toast.makeText(getApplicationContext(), getString(R.string.msgAp), Toast.LENGTH_LONG).show();
            }
        }
    }
}