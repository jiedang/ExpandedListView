package com.lin1987www.example.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import com.lin1987www.widget.ExpandedListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/4/5.
 */
public class SelectableListViewFragment extends Fragment {

    ExpandedListView expandedListView;

    ArrayList<String> dataArrayList = new ArrayList<String>();

    ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_selectablelistview, container, false);

        expandedListView = (ExpandedListView) rootView.findViewById(R.id.expandedListView);
        expandedListView.setExpanded(false);
        expandedListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_multiple_choice, dataArrayList);
        expandedListView.setAdapter(adapter);

        expandedListView.post(new Runnable() {
            @Override
            public void run() {
                // Load data from Network or else
                for (int i = 0; i < 100; i++) {
                    dataArrayList.add(String.format("Item %s", i));
                }
                adapter.notifyDataSetChanged();
                //  Restoring data after rotating screen or pressing Home back
                expandedListView.restoreByKeeper();
            }
        });

        return rootView;
    }

}
