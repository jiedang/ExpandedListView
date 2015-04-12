package com.lin1987www.example.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    FrameLayout mainFragmentContent;
    String[] fragmentNameArray = new String[]{
            "Extended ListView API 8+",
            "Selectable ListView API 11+"
    };
    String[] fragmentClassNameArray = new String[]{
            ExtendedListViewFragment.class.getName(),
            SelectableListViewFragment.class.getName()
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        mainFragmentContent = (FrameLayout) rootView.findViewById(R.id.mainFragmentContent);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, fragmentNameArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String fragmentClassName = fragmentClassNameArray[position];
        FragmentManager fragmentManager = getChildFragmentManager();
        if(null == fragmentManager.findFragmentByTag(fragmentClassName)) {
            Fragment targetFragment = Fragment.instantiate(getActivity(), fragmentClassName);
            fragmentManager.
                    beginTransaction()
                    .replace(R.id.mainFragmentContent, targetFragment, fragmentClassName)
                    .commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
