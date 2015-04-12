package com.lin1987www.example.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.lin1987www.widget.ExpandedListView;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2015/4/5.
 */
public class ExtendedListViewFragment extends Fragment {

    ExpandedListView expandedListView;

    AtomicInteger itemCount = new AtomicInteger(0);

    BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return itemCount.get();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_extendedlistview, parent, false);
            }
            EditText editText = (EditText)convertView.findViewById(R.id.editTextNoIdNoSave);
            editText.setText(String.format("EditText %s",position));
            return convertView;
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_extendedlistview, container, false);
        expandedListView = (ExpandedListView) rootView.findViewById(R.id.expandedListView);
        expandedListView.setExpanded(true);
        expandedListView.setAdapter(adapter);

        expandedListView.post(new Runnable() {
            @Override
            public void run() {
                // Load data from Network or else
                itemCount.set(20);
                adapter.notifyDataSetChanged();
                //  Restoring data after rotating screen or pressing Home back
                expandedListView.restoreByKeeper();
            }
        });

        return rootView;
    }
}
