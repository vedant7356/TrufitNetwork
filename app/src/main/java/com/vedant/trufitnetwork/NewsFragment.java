package com.vedant.trufitnetwork;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.vedant.trufitnetwork.Models.NewsApiResponse;
import com.vedant.trufitnetwork.Models.NewsHeadlines;

import java.util.List;


public class NewsFragment extends Fragment implements SelectListener, View.OnClickListener {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    Button b1,b2,b3,b4,b5,b6,b7;
    SearchView searchView;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_news, container, false);

        searchView=view.findViewById(R.id.search_view);
        recyclerView = view.findViewById(R.id.recycler_main);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching news articles of "+ query);
                dialog.show();
                RequestManager manager = new RequestManager(getContext());
                manager.getNewsHeadlines(listener, "general",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        dialog = new ProgressDialog(getContext());
        dialog.setTitle("Fetching news articles...");
        dialog.show();

        b1=view.findViewById(R.id.btn_1);
        b1.setOnClickListener(this);
        b2=view.findViewById(R.id.btn_2);
        b2.setOnClickListener(this);
        b3=view.findViewById(R.id.btn_3);
        b3.setOnClickListener(this);
        b4=view.findViewById(R.id.btn_4);
        b4.setOnClickListener(this);
        b5=view.findViewById(R.id.btn_5);
        b5.setOnClickListener(this);
        b6=view.findViewById(R.id.btn_6);
        b6.setOnClickListener(this);
        b7=view.findViewById(R.id.btn_7);
        b7.setOnClickListener(this);



        RequestManager manager = new RequestManager(getContext());

        manager.getNewsHeadlines(listener, "general",null);

        return view;
    }

    private final OnFetchDataListener<NewsApiResponse> listener= new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {

            if (list.isEmpty()){
                Toast.makeText(getContext(), "No data found!!!", Toast.LENGTH_SHORT).show();
            }
            else{
                showNews(list);
                dialog.dismiss();
            }
        }

        @Override
        public void onError(String message) {

            Toast.makeText(getContext(), "An Error Occurred", Toast.LENGTH_SHORT).show();

            Log.e("er","Error here"+message);
        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        adapter= new CustomAdapter(getContext(),list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category= button.getText().toString();
        dialog.setTitle("Fetching News Articles of "+ category);
        dialog.show();
        RequestManager manager = new RequestManager(getContext());
        manager.getNewsHeadlines(listener, category,null);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {

        startActivity(new Intent(getContext(),DetailsActivity.class)
                .putExtra("data",headlines));
    }
}