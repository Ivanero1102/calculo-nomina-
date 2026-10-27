package com.example.calculonominabsico; // Reemplaza por tu package si es diferente

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtdias, txthoras;
    private Button btnCalcular, btnBorrar;
    private TextView lblPago, lblDescuento;
    private CheckBox ckbPago, ckbDescuento;
    private RadioGroup rdbgroupRound;
    private RadioButton rdbRedondeo, rdbNorendondeo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txthoras = findViewById(R.id.txthoras);
        txtdias = findViewById(R.id.txtdias);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnBorrar = findViewById(R.id.btnBorrar);
        lblPago = findViewById(R.id.lblPago);
        lblDescuento = findViewById(R.id.lblDescuento);
        ckbPago = findViewById(R.id.ckbPago);
        ckbDescuento = findViewById(R.id.ckbDescuento);
        rdbgroupRound = findViewById(R.id.rdbgroupRound);
        rdbRedondeo = findViewById(R.id.rdbRedondeo);
        rdbNorendondeo = findViewById(R.id.rdbNorendondeo);
    }

    public void Calcular(View view) {
        try {
            int dias = Integer.parseInt(txtdias.getText().toString());
            int horas = Integer.parseInt(txthoras.getText().toString());
            int horas_mensuales = horas * dias;
            double pago = horas_mensuales * 13.75;
            double descuento = 0.00;
            double sueldobase = 2200.00;

            if (ckbPago.isChecked()) {
                lblPago.setText(String.valueOf(pago));
            }

            if (ckbDescuento.isChecked() && pago > sueldobase) {
                descuento = pago - (pago * 0.1);
                lblDescuento.setText(String.valueOf(descuento));
            } else if (ckbDescuento.isChecked()) {
                descuento = pago;
                lblDescuento.setText(String.valueOf(descuento));
            }

            if (rdbgroupRound.getCheckedRadioButtonId() == R.id.rdbRedondeo) {
                int pago_redondeo = (int) Math.round(pago);
                lblPago.setText(String.valueOf(pago_redondeo));
                int descuento_redondeo = (int) Math.round(descuento);
                lblDescuento.setText(String.valueOf(descuento_redondeo));
            }
        } catch (NumberFormatException e) {
            lblPago.setText("Error en datos");
        }
    }

    public void Borrar(View view) {
        txtdias.setText("");
        txthoras.setText("");
        ckbPago.setChecked(false);
        ckbDescuento.setChecked(false);
        lblPago.setText("Pago");
        lblDescuento.setText("Con descuento");
        rdbRedondeo.setChecked(false);
        rdbNorendondeo.setChecked(false);
    }
}
