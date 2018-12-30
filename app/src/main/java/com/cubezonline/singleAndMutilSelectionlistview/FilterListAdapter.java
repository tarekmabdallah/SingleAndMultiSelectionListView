package com.cubezonline.singleAndMutilSelectionlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class FilterListAdapter extends ArrayAdapter<FilterItemModel> {
    private final List<FilterItemModel> listState;

    public FilterListAdapter(Context context, List<FilterItemModel> objects) {
        super(context, 0, objects);
        this.listState = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_checkbox_item, parent, false);
            holder.title = convertView.findViewById(R.id.txt_item_list_title);
            holder.checkBox = convertView.findViewById(R.id.cbSelected);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final FilterItemModel tag = listState.get(position);


        if (tag.isSelected()) {
            //holder.title.setCompoundDrawablesWithIntrinsicBounds (0, 0,R.drawable.check_box_square_off ,0);
            holder.checkBox.setChecked(true);
        } else {
            //holder.title.setCompoundDrawablesWithIntrinsicBounds (0, 0,R.drawable.check_box_square_on ,0);
            holder.checkBox.setChecked(false);
        }


        holder.title.setText(listState.get(position).getTagText());
        holder.title.setTag(position);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getPosition = (Integer) v.getTag();
                tag.setSelected(!listState.get(getPosition).isSelected());
                notifyDataSetChanged();
            }
        });
        return convertView;
    }


    /**
     * clear all items in list
     */
    public void clearList() {
        for (FilterItemModel items : listState) {
            items.setSelected(false);
        }
        notifyDataSetChanged();
    }

    /**
     * select all items in list
     */
    public void fillList() {
        for (FilterItemModel items : listState) {
            items.setSelected(true);
        }
        notifyDataSetChanged();
    }

    /**
     * view holder
     */
    private class ViewHolder {
        private TextView title;
        private CheckBox checkBox;
    }
}