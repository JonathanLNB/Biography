package com.example.biography;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biography.Modelos.Biografia;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Detalles extends AppCompatActivity {
    @BindView(R.id.iFoto)
    ImageView iFoto;
    @BindView(R.id.vTitulo)
    TextView vTitulo;
    @BindView(R.id.vNombre)
    TextView vNombre;
    @BindView(R.id.vBiografia)
    TextView vBiografia;
    @BindView(R.id.vAutorF)
    TextView vAutorF;
    @BindView(R.id.vCategoria)
    TextView vCategoria;

    private Biografia biografia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        ButterKnife.bind(this);
        biografia = (Biografia) getIntent().getSerializableExtra("detalles");
        vTitulo.setText(biografia.getTitulo());
        if (biografia.getNombre().length() > 0)
            vNombre.setText(biografia.getNombre());
        else
            vNombre.setVisibility(View.GONE);
        vBiografia.setText(biografia.getBiografia());
        vAutorF.setText(biografia.getEscritor() + " - " + biografia.getFecha());
        vCategoria.setText(biografia.getCategorias().getCategoria());
        Picasso.get().load(biografia.getImagen()).into(iFoto);
    }
}
