package com.zkcnt.cardviewexpandable;

import android.os.Bundle;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zkcnt.cardviewexpandable.adapter.InnerRecyclerViewAdapter;
import com.zkcnt.cardviewexpandable.databinding.FragmentCardViewBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardViewFragment extends Fragment {

    private static String TAG = "CARD_VIEW_FRAGMENT";
    private FragmentCardViewBinding fragmentCardViewBinding;

    private InnerRecyclerViewAdapter innerRecyclerViewAdapter;

    public CardViewFragment() {
        // Required empty public constructor
    }

    public static CardViewFragment newInstance() {
        CardViewFragment fragment = new CardViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(fragmentCardViewBinding == null) {
            fragmentCardViewBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_card_view);
        }
        return inflater.inflate(R.layout.fragment_card_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setItems();

        fragmentCardViewBinding.cardviewHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(View.VISIBLE == fragmentCardViewBinding.cardviewHidden.getVisibility()) {
                    fragmentCardViewBinding.cardviewHidden.setVisibility(View.GONE);
                } else {
                    fragmentCardViewBinding.cardviewHidden.setVisibility(View.VISIBLE);
                    fragmentCardViewBinding.scrollviewMain.fullScroll(View.FOCUS_DOWN);
                }
            }
        });
    }

    // Setting headers and childs to expandable listview
    private void setItems() {

        // Array list for header
        ArrayList<String> header = new ArrayList<String>();

        // Array list for child items
        List<String> child1 = new ArrayList<String>();
        List<String> child2 = new ArrayList<String>();
        List<String> child3 = new ArrayList<String>();
        List<String> child4 = new ArrayList<String>();

        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // Adding headers to list
        for (int i = 1; i < 2; i++) {
            header.add("Group " + i);

        }
        // Adding child data
        for (int i = 1; i < 5; i++) {
            child1.add("Group 1  - " + " : Child" + i);

        }
        // Adding child data
        for (int i = 1; i < 5; i++) {
            child2.add("Group 2  - " + " : Child" + i);

        }
        // Adding child data
        for (int i = 1; i < 6; i++) {
            child3.add("Group 3  - " + " : Child" + i);

        }
        // Adding child data
        for (int i = 1; i < 7; i++) {
            child4.add("Group 4  - " + " : Child" + i);

        }

        // Adding header and childs to hash map
        hashMap.put(header.get(0), child1);
//        hashMap.put(header.get(1), child2);
//        hashMap.put(header.get(2), child3);
//        hashMap.put(header.get(3), child4);

//        adapter = new ExpandableListAdapter(MainActivity.this, header, hashMap);

        // Setting adpater over expandablelistview
//        expandableListView.setAdapter(adapter);

        innerRecyclerViewAdapter = new InnerRecyclerViewAdapter(getContext(), hashMap, 0, "Group 1");
        fragmentCardViewBinding.expandRecyclerview.setLayoutManager(new GridLayoutManager(getContext(), 3));
        fragmentCardViewBinding.expandRecyclerview.setAdapter(innerRecyclerViewAdapter);
    }
}