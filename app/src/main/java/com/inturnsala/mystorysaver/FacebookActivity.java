package com.inturnsala.mystorysaver;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.inturnsala.mystorysaver.databinding.ActivityFacebookBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class FacebookActivity extends AppCompatActivity
{
    ActivityFacebookBinding binding;
    FacebookActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_facebook);
        activity = this;
        binding.downloadbtn.setOnClickListener(v -> {
            getFaceBookData();
        });
    }

    private void getFaceBookData() {
        try {
            URL url = new URL(binding.fbUrl.getText().toString());
            String host = url.getHost();
            if (host.contains("facebook.com")) {
                new CallGetfbData().execute(binding.fbUrl.getText().toString());
            } else Toast.makeText(activity, "Url is invalid", Toast.LENGTH_SHORT).show();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    class CallGetfbData extends AsyncTask<String, Void, Document> {
        Document fbDocs;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Document doInBackground(String... strings) {
            try {
                fbDocs = Jsoup.connect(strings[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fbDocs;
        }

        @Override
        protected void onPostExecute(Document document) {
            try {


                String videourl = document.select("meta[property=\"og:video\"]").last().attr("content");

                if (!videourl.equals("")) {
                    try {


                        Util.download(videourl, Util.RootDirectoryFacebook, activity, "facebook" + System.currentTimeMillis()+ ".mp4");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                }
            } catch (NullPointerException e)
            {
                Toast.makeText(FacebookActivity.this,"null error",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }


        }


    }
}



















