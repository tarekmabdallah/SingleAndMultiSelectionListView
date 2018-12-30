package com.cubezonline.singleAndMutilSelectionlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView filterList = findViewById(R.id.filter_list);
        String numbers = "1,2,3,4,5,6";
        ArrayList<String> filterTypes = new ArrayList<>(Arrays.asList(numbers.split(",")));
        ArrayAdapter<String> filterListAdapter = new RadioGroupSortAdapter(this, R.layout.filter_radio_btn_item, R.id.text1, filterTypes);
       // filterList.setAdapter(filterListAdapter);

        FilterListAdapter adapter = new FilterListAdapter(this, new ArrayList<FilterItemModel>());
        ArrayList<FilterItemModel> itemModels = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            FilterItemModel filterItemModel = new FilterItemModel(String.valueOf(i), String.valueOf(i));
            itemModels.add(filterItemModel);
        }
        adapter.addAll(itemModels);
        filterList.setAdapter(adapter);

        // for ok btn listener after user choices some values
        ArrayList<String>  itemsSelected = new ArrayList<>();
        for (FilterItemModel filterItemModel : itemModels) {
            if (filterItemModel.isSelected())
                itemsSelected.add(filterItemModel.getTagId());
        }
    }
}
