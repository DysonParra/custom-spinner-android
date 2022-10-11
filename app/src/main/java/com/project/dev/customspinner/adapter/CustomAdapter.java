/*
 * @fileoverview {CustomAdapter} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {CustomAdapter} fue realizada el 31/07/2022.
 * @Dev - La primera version de {CustomAdapter} fue escrita por Dyson A. Parra T.
 */
package com.project.dev.customspinner.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.project.dev.customspinner.R;

/**
 * TODO: Definición de {@code CustomAdapter}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class CustomAdapter extends ArrayAdapter<String> {

    private int[] spinnerImages;
    private Context mContext;

    /**
     * TODO: Definición de {@code CustomAdapter}.
     *
     * @param context
     * @param images
     */
    public CustomAdapter(@NonNull Context context, int[] images) {
        super(context, R.layout.custom_spinner_row);
        this.spinnerImages = images;
        this.mContext = context;
    }

    /**
     * TODO: Definición de {@code getDropDownView}.
     *
     * @param position
     * @param parent
     * @param convertView
     */
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    /**
     * TODO: Definición de {@code getCount}.
     *
     * @return
     */
    @Override
    public int getCount() {
        return spinnerImages.length;
    }

    /**
     * TODO: Definición de {@code getView}.
     *
     * @param position
     * @param parent
     * @param convertView
     */
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_spinner_row, parent, false);

            mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.spinnerImage);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mFlag.setImageResource(spinnerImages[position]);

        return convertView;
    }

    /**
     * TODO: Definición de {@code ViewHolder}.
     *
     */
    private static class ViewHolder {

        ImageView mFlag;
    }
}
