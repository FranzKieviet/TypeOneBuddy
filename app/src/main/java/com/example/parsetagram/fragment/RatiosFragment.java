package com.example.parsetagram.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parsetagram.Ratio;
import com.example.parsetagram.R;
import com.example.parsetagram.RatiosAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.List;


public class RatiosFragment extends Fragment {

    public static final String TAG = "RatiosFragment";
    private RecyclerView rvRatios;
    protected RatiosAdapter adapter;
    protected List<Ratio> allRatios;

    public RatiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ratios, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvRatios= view.findViewById(R.id.rvRatios);

        allRatios= new ArrayList<>();
        adapter = new RatiosAdapter(getContext(), allRatios);

        rvRatios.setAdapter(adapter);
        rvRatios.setLayoutManager(new LinearLayoutManager(getContext()));
        queryRatios();

    }
    protected void queryRatios(){
        ParseQuery<Ratio> query = ParseQuery.getQuery(Ratio.class);
        query.setLimit(200);
        query.addAscendingOrder(Ratio.KEY_NAME);
        query.findInBackground(new FindCallback<Ratio>() {
            @Override
            public void done(List<Ratio> ratios, ParseException e) {
                if (e!= null){
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                allRatios.addAll(ratios);
               adapter.notifyDataSetChanged();
            }

        });
    }

}