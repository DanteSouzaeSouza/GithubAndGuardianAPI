package com.example.sophie.githubapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Main2Activity extends AppCompatActivity implements OnResultSelectedInterface {


    private final static String TAG = "LogTag";

    @BindView(R.id.main2_name)
    TextView nameTextView;

    @BindView(R.id.main2_description)
    TextView descriptionTextView;

    @BindView(R.id.main2_html)
    Button htmlButton;

    @BindView(R.id.main2_language)
    TextView languageTextView;

    @BindView(R.id.main2_forks)
    TextView forksTextView;

    @BindView(R.id.main2_size)
    TextView sizeTextView;

    @BindView(R.id.main2_createdDate)
    TextView createdDateTextView;

    @BindView(R.id.main2_createdTime)
    TextView createdTimeTextView;

    @BindView(R.id.main2_updatedDate)
    TextView updatedDateTextView;

    @BindView(R.id.main2_updatedTime)
    TextView updatedTimeTextView;

    @BindView(R.id.main2_pushedDate)
    TextView pushedDateTextView;

    @BindView(R.id.main2_pushedTime)
    TextView pushedTimeTextView;

    @BindView(R.id.main2_p)
    TextView pTextView;

    @BindView(R.id.main2_stars)
    TextView starsTextView;

    @BindView(R.id.main2_watchers)
    TextView watchersTextView;

    @BindView(R.id.main2_open)
    TextView openTextView;

    @BindView(R.id.main2_homepage)
    TextView homepageTextView;

    @BindView(R.id.main2_avatar)
    ImageView avatarImageView;

    @BindView(R.id.main2_ownerName)
    TextView ownerNameTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);

        Intent mainIntent = getIntent();
        final GitHubResult result = Parcels.unwrap(mainIntent.getParcelableExtra("SELECTED_RESULT_GITHUB"));

        String created = result.getCreated();
        String dateCreated = created.substring(0,10);
        String timeCreated = created.substring(11,19);
        String updated = result.getUpdated();
        String dateUpdated = updated.substring(0,10);
        String timeUpdated = updated.substring(11,19);
        String pushed = result.getPushed();
        String datePushed = pushed.substring(0,10);
        String timePushed = pushed.substring(11,19);
        nameTextView.setText(result.getName());
        descriptionTextView.setText(result.getDescription());
        ownerNameTextView.setText("Owner Name: "+result.owner.getOwnerName());
        languageTextView.setText("Language: " + result.getLanguage());
        forksTextView.setText("Fork Count: " + result.getForks());
        htmlButton.setText(result.getHtml());
        sizeTextView.setText("Size: "+ result.getSize() +"KB");
        createdDateTextView.setText("Created At Date: "+ dateCreated);
        createdTimeTextView.setText("Created At Time: "+ timeCreated);
        updatedDateTextView.setText("Updated At Date: "+ dateUpdated);
        updatedTimeTextView.setText("Updated At Time: "+ timeUpdated);
        pushedDateTextView.setText("Pushed At Date: "+ datePushed);
        pushedTimeTextView.setText("Pushed At Time: "+ timePushed);
        pTextView.setText("Private: "+ result.getP());
        starsTextView.setText("Stargazers Count: " + result.getStars());
        watchersTextView.setText("Watchers Count: "+ result.getWatchers());
        openTextView.setText("Open Issues Count: "+ result.getOpen());
        homepageTextView.setText("Homepage: "+ result.getHomepage());

        Glide.with(this).load(result.owner.getAvatar()).into(avatarImageView);

//        new DownLoadImageTask(imageView_avatar).execute(avatar);

        htmlButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uriUrl = Uri.parse(result.getHtml());
                Intent intent_button = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent_button);
            }
        });


        }

    @Override
    public void onResultSelected(GitHubResult gitHubResult) {

    }
}

//    class DownLoadImageTask extends AsyncTask<String, Void, Bitmap> {
//
//    ImageView imageView_avatar;
//
//    public DownLoadImageTask (ImageView imageView_avatar){
//        this.imageView_avatar = imageView_avatar;
//    }
//
//    protected Bitmap doInBackground(String...urls){
//        String urlOfImage = urls[0];
//        Bitmap avatar = null;
//        try{
//            InputStream is = new URL(urlOfImage).openStream();
//            avatar = BitmapFactory.decodeStream(is);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return avatar;
//    }
//
//    protected void onPostExecute(Bitmap result){
//        imageView_avatar.setImageBitmap(result);
//    }
//}
