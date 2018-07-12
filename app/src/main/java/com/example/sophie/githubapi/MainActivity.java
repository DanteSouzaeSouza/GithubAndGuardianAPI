package com.example.sophie.githubapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.parceler.Parcels;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Results, OnResultSelectedInterface, OnResultSelectedGuardian {

    private final static String TAG = "LogTag";

    private EditText name;
    private TextView title;
    private ArrayList<GitHubResult> gitHubResults = new ArrayList<>();
    private ArrayList<Result> guardianResults = new ArrayList<>();
    private RecyclerView.Adapter mAdapterGithub;
    private RecyclerView.Adapter mAdapterGuardian;
    private HttpGetRequest getRequest;
    private Gson gson= new Gson();
    private String url;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = getString(R.string.base_url);

        RecyclerView rv = findViewById(R.id.rv_name);
        rv.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        mAdapterGithub = new MyAdapter(gitHubResults, this);
        mAdapterGuardian = new MyAdapterGuardian(guardianResults, this);
        if (BuildConfig.FLAVOR.contains("github")){
            rv.setAdapter(mAdapterGithub);
        }else {
            rv.setAdapter(mAdapterGuardian);
        }

        DividerItemDecoration id = new DividerItemDecoration(this, mLayoutManager.getOrientation());
        rv.addItemDecoration(id);

        name = findViewById(R.id.main_input);
        title = findViewById(R.id.main_name);
        Button buttonSearch = findViewById(R.id.btn_search);
        if (BuildConfig.FLAVOR.contains("github")) {
            buttonSearch.setText("Search Github");
            title.setText("Name of Repository to be Searched: ");
        }else{
            buttonSearch.setText("Search Guardian");
            title.setText("Name of Article to be Searched: ");
        }
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                search(name.getText().toString());
            }
        });



        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 2) {
                    search(name.getText().toString().toLowerCase());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void search(CharSequence s) {

        if (getRequest != null && !getRequest.isCancelled()) {
            getRequest.cancel(true);
        }

        if (gitHubResults.size() != 0) {
            gitHubResults.clear();
        }

        if(guardianResults.size() != 0){
            guardianResults.clear();
        }

        String myUrl = url + s;

        if(BuildConfig.FLAVOR.contains("github")) {
            getRequest = new HttpGetRequest(this, HttpGetRequest.TYPE_GITHUB_REQUEST);
        }else{
            getRequest = new HttpGetRequest(this, HttpGetRequest.TYPE_GUARDIAN_REQUEST);
        }

        getRequest.execute(myUrl);
    }


    @Override
    public void handleResult(String result, int type) {
        switch (type) {
            case HttpGetRequest.TYPE_GITHUB_REQUEST:
                GitHubResponse responseGithub = gson.fromJson(result, GitHubResponse.class);
                gitHubResults.addAll(responseGithub.getItems());
                mAdapterGithub.notifyDataSetChanged();
                break;
            case HttpGetRequest.TYPE_GUARDIAN_REQUEST:
                GuardianResponse responseGuardian = gson.fromJson(result,GuardianResponse.class);
                guardianResults.addAll(responseGuardian.getResponse().getResults());
                mAdapterGuardian.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onResultSelected(GitHubResult gitHubResult) {
        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
        intent.putExtra("TYPE",  HttpGetRequest.TYPE_GITHUB_REQUEST);
        intent.putExtra("SELECTED_RESULT_GITHUB", Parcels.wrap(gitHubResult));
        startActivity(intent);
    }

    @Override
    public void onResultSelected(Result guardianResult) {
        Intent intent = new Intent(getBaseContext(), Main3Activity.class);
        intent.putExtra("TYPE",  HttpGetRequest.TYPE_GITHUB_REQUEST);
        intent.putExtra("SELECTED_RESULT_GUARDIAN", Parcels.wrap(guardianResult));
        startActivity(intent);
    }
}
