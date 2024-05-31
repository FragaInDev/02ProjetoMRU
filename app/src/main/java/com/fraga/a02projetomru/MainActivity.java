package com.fraga.a02projetomru;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etSInicial;
    private EditText etVeloc;
    private EditText etTempo;

    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etSInicial = findViewById(R.id.etSinicial);
        etSInicial.setTextAlignment(EditText.TEXT_ALIGNMENT_CENTER);
        etVeloc = findViewById(R.id.etVeloc);
        etVeloc.setTextAlignment(EditText.TEXT_ALIGNMENT_CENTER);
        etTempo = findViewById(R.id.etTempo);
        etTempo.setTextAlignment(EditText.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        float sInicial = Float.parseFloat(etSInicial.getText().toString());
        float veloc = Float.parseFloat(etVeloc.getText().toString());
        float tempo = Float.parseFloat(etTempo.getText().toString());
        float sFinal = sInicial + veloc * tempo;
        String res = getString(R.string.s_final) + " " + sFinal + " m";
        tvRes.setText(res);
    }
}