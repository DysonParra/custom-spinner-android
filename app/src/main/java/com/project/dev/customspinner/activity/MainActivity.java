/*
 * @fileoverview {MainActivity} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {MainActivity} fue realizada el 31/07/2022.
 * @Dev - La primera version de {MainActivity} fue escrita por Dyson A. Parra T.
 */
package com.project.dev.customspinner.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.project.dev.customspinner.R;
import com.project.dev.customspinner.adapter.CustomAdapter;
import com.project.dev.customspinner.adapter.DisabledAdapter;

/**
 * TODO: Definición de {@code MainActivity}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class MainActivity extends Activity {

    /*
     * Variables asociadas con elementos la vista.
     */
    private EditText editTextA4;
    private Spinner spnNoteQuantity;
    private Spinner spnNoteType;
    private Spinner spnClef;
    private Spinner spnTranspose;
    private Spinner spnSignature;
    private Spinner spnTempo;
    private EditText editTextTempo;
    private Button btnStart;

    /**
     * Invocado cuando se crea el activity.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Crea instancia del activity y la asocia con la vista.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Asocia variables locales con elementos de la vista.
        editTextA4 = findViewById(R.id.editTextA4);
        spnNoteQuantity = findViewById(R.id.spnNoteQuantity);
        spnNoteType = findViewById(R.id.spnNoteType);
        spnClef = findViewById(R.id.spnClef);
        spnTranspose = findViewById(R.id.spnTranspose);
        spnSignature = findViewById(R.id.spnSignature);
        spnTempo = findViewById(R.id.spnTempo);
        editTextTempo = findViewById(R.id.editTextTempo);
        btnStart = findViewById(R.id.btnStart);

        // Agrega las imágenes al Spinner con la figura del tempo.
        int[] spinnerImages = new int[]{R.drawable.half_note, R.drawable.quarter_note, R.drawable.eighth_note};
        CustomAdapter mCustomAdapter = new CustomAdapter(MainActivity.this, spinnerImages);
        spnTempo.setAdapter(mCustomAdapter);

        DisabledAdapter adapter = DisabledAdapter.createFromResource(this, R.array.clef, android.R.layout.simple_spinner_item);
        spnClef.setAdapter(adapter);

        adapter.disableItem(5);
    }

}
