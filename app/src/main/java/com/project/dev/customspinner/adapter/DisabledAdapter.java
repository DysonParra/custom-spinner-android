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
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
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
 * TODO: Description of {@code DisabledAdapter}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class DisabledAdapter extends ArrayAdapter<CharSequence> {

    private boolean enabledItems[];

    /**
     * TODO: Description of {@code DisabledAdapter}.
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
     * TODO: Description of {@code createFromResource}.
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
     * TODO: Description of {@code areAllItemsEnabled}.
     *
     * @return
     */
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    /**
     * TODO: Description of {@code isEnabled}.
     *
     * @param position
     * @return
     */
    @Override
    public boolean isEnabled(int position) {
        return enabledItems[position];
    }

    /**
     * TODO: Description of {@code getDropDownView}.
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
     * TODO: Description of {@code enableItem}.
     *
     * @param position
     */
    public void enableItem(int position) {
        if (position < enabledItems.length)
            enabledItems[position] = true;
    }

    /**
     * TODO: Description of {@code disableItem}.
     *
     * @param position
     */
    public void disableItem(int position) {
        if (position < enabledItems.length)
            enabledItems[position] = false;
    }

}
