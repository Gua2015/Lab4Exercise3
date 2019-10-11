package com.missouristate.guadagnano.shades2;

import android.view.View;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyListFragment extends Fragment {
    private OnItemSelectedListener listener;
    List<String> shadeListing;
    List<String> shadeNameDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        shadeListing = new ArrayList<String>(Arrays.asList(DummyData.shade_name));
        shadeNameDetail = new ArrayList<String>(Arrays.asList(DummyData.shade_detail));

        //create array adapter that takes data from dummy shades to populate the list view
        final ArrayAdapter<String> mShadeAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.list_item_shade, R.id.list_item_shade_textView, shadeListing);

        View rootView = inflater.inflate(R.layout.color_list_fragment, container, false);

        //take reference to listView and attach this adapter
        ListView listView = rootView.findViewById(R.id.listView_shades);
        listView.setAdapter(mShadeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String shadeIndexString = mShadeAdapter.getItem(i);
                String information = shadeIndexString + "\n\n\n" + shadeNameDetail.get(i);
                updateDetail(information);
            }
        });
        return rootView;
    }
    public interface OnItemSelectedListener {
        void onColorItemsSelected(String link);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof AdapterView.OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString() + " must implement MyListFragment.OnItemsSelectedListener");
        }
    }
    public void updateDetail(String information) {
        listener.onColorItemsSelected(information);
    }
}
