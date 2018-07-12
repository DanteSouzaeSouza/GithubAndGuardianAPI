package com.example.sophie.githubapi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity implements OnResultSelectedGuardian {

    @BindView(R.id.main3_title)
    TextView nameTextView;

    @BindView(R.id.main3_publicationDate)
    TextView publicationDateTextView;

    @BindView(R.id.main3_publicationTime)
    TextView publicationTimeTextView;

    @BindView(R.id.main3_section)
    TextView sectionTextView;

    @BindView(R.id.main3_web)
    Button buttonWeb;

    @BindView(R.id.main3_type)
    TextView typeTextView;

    @BindView(R.id.main3_pillarName)
    TextView pillarNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);

        Intent mainIntent = getIntent();
        final Result result = Parcels.unwrap(mainIntent.getParcelableExtra("SELECTED_RESULT_GUARDIAN"));

        String published = result.getPublication();
        String datePublished = published.substring(0,10);
        String timePublished = published.substring(11,19);
        nameTextView.setText(result.getTitle());
        publicationDateTextView.setText("Publication Date: " + datePublished);
        publicationTimeTextView.setText("Publication Time: " + timePublished);
        sectionTextView.setText(result.getSection());
        buttonWeb.setText(result.getWeb());
        typeTextView.setText("Type: "+result.getType());
        pillarNameTextView.setText("Pillar Name: "+ result.getPillarName());

        buttonWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uriUrl = Uri.parse(result.getWeb());
                Intent intent_button = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent_button);
            }
        });
    }

    @Override
    public void onResultSelected(Result guardianResult) {

    }
}


