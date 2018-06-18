package ipk404.bisindosdict;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import ipk404.bisindosdict.Dao.DictDao;

public class DetailKataActivity extends AppCompatActivity {
    private static String DICT_DAO = "DICT_DAO";

    public static void startThisActivity(Activity activity, DictDao data) {
        Intent i = new Intent(activity, DetailKataActivity.class);
        Gson gson = new Gson();
        i.putExtra(DICT_DAO, gson.toJson(data));
        activity.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Gson gson = new Gson();
        DictDao data = gson.fromJson(getIntent().getStringExtra(DICT_DAO), DictDao.class);
        WebView webView = findViewById(R.id.webViewYoutubeLoader);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.loadUrl(data.getVideo());
        if (data.getPict() != null && !data.getPict().equalsIgnoreCase("")) {
            Picasso.with(this).load(data.getPict()).into((ImageView) findViewById(R.id.image_instruction));
        }else{
            findViewById(R.id.image_instruction).setVisibility(View.GONE);
        }
        TextView txtArti = findViewById(R.id.txt_desc);
        TextView txtHead = findViewById(R.id.arti_kata);
        txtHead.setText("Arti : "+data.getKata());
        getSupportActionBar().setTitle(data.getKata());
        txtArti.setText(data.getArti());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
