/*
 * @fileoverview    {CustomAdapter}
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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.project.dev.customspinner.R;

/**
 * TODO: Description of {@code CustomAdapter}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class CustomAdapter extends ArrayAdapter<String> {

    private int[] spinnerImages;
    private Context mContext;

    /**
     * TODO: Description of {@code CustomAdapter}.
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
     * TODO: Description of {@code getDropDownView}.
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
     * TODO: Description of {@code getCount}.
     *
     * @return
     */
    @Override
    public int getCount() {
        return spinnerImages.length;
    }

    /**
     * TODO: Description of {@code getView}.
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
     * TODO: Description of {@code ViewHolder}.
     *
     */
    private static class ViewHolder {

        ImageView mFlag;
    }
}
