/*
 * @fileoverview    {DisabledAdapter}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementación realizada.
 * @version 2.0     Documentación agregada.
 */
package com.project.dev.customspinner.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * TODO: Definición de {@code DisabledAdapter}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class DisabledAdapter extends ArrayAdapter<CharSequence> {

    private boolean enabledItems[];

    /**
     * TODO: Definición de {@code DisabledAdapter}.
     *
     * @param context
     * @param strings
     * @param textViewResId
     */
    public DisabledAdapter(Context context, int textViewResId, CharSequence[] strings) {
        super(context, textViewResId, strings);
        this.enabledItems = new boolean[strings.length];

        for (int i = 0; i < enabledItems.length; i++)
            enabledItems[i] = true;
    }

    /**
     * TODO: Definición de {@code createFromResource}.
     *
     * @param context
     * @param textViewResId
     * @param textArrayResId
     * @return
     */
    public static DisabledAdapter createFromResource(Context context, int textArrayResId, int textViewResId) {
        Resources resources = context.getResources();
        CharSequence[] strings = resources.getTextArray(textArrayResId);
        return new DisabledAdapter(context, textViewResId, strings);
    }

    /**
     * TODO: Definición de {@code areAllItemsEnabled}.
     *
     * @return
     */
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    /**
     * TODO: Definición de {@code isEnabled}.
     *
     * @param position
     * @return
     */
    @Override
    public boolean isEnabled(int position) {
        return enabledItems[position];
    }

    /**
     * TODO: Definición de {@code getDropDownView}.
     *
     * @param position
     * @param parent
     * @param convertView
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);

        TextView text = (TextView) view;

        if (isEnabled(position))
            text.setTextColor(Color.BLACK);
        else
            text.setTextColor(Color.GRAY);

        return view;
    }

    /**
     * TODO: Definición de {@code enableItem}.
     *
     * @param position
     */
    public void enableItem(int position) {
        if (position < enabledItems.length)
            enabledItems[position] = true;
    }

    /**
     * TODO: Definición de {@code disableItem}.
     *
     * @param position
     */
    public void disableItem(int position) {
        if (position < enabledItems.length)
            enabledItems[position] = false;
    }

}
