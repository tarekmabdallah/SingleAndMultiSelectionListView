package com.cubezonline.singleAndMutilSelectionlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class RadioGroupSortAdapter extends ArrayAdapter<String> {

    private static int sortKeyId;
    private final int mResourceId;
    private final LayoutInflater mLayoutInflater;
    private RadioButton mSelectedRB;
    private int mSelectedPosition = -1;

    public RadioGroupSortAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
        mResourceId = resource;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static int getSortKeyId() {
        return sortKeyId;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(mResourceId, parent, false);
            holder = new ViewHolder();
            holder.name = view.findViewById(R.id.text1);
            holder.radioBtn = view.findViewById(R.id.radio_btn1);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != mSelectedPosition && mSelectedRB != null) {
                    mSelectedRB.setChecked(false);
                }
                sortKeyId = position;
                mSelectedPosition = position;
                mSelectedRB = (RadioButton) v;
            }
        });
        if (mSelectedPosition != position) {
            holder.radioBtn.setChecked(false);
        } else {
            holder.radioBtn.setChecked(true);
            if (mSelectedRB != null && holder.radioBtn != mSelectedRB) {
                mSelectedRB = holder.radioBtn;
            }
        }
        holder.name.setText(getItem(position));
        return view;
    }

    private class ViewHolder {
        TextView name;
        RadioButton radioBtn;
    }
}