package com.inturnsala.mystorysaver;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.inturnsala.mystorysaver.databinding.ActivityFacebookBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class FacebookActivity extends AppCompatActivity
{
  private   ActivityFacebookBinding binding;
  private   FacebookActivity activity;
String text;
int quality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_facebook);
        activity = this;
        binding.downloadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFaceBookData();
            }
        });
        binding.facebookPaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData pasteData = manager.getPrimaryClip();
                ClipData.Item item = pasteData.getItemAt(0);
                String paste = item.getText().toString();

                binding.fbUrl.setText(paste);
            }
        });
    }







    private void getFaceBookData()
    {
        URL url = null;
        try {
            url = new URL(binding.fbUrl.getText().toString());

            String host = url.getHost();
//            if (host.contains("facebook.com"))
//            {
                new callGetFbData().execute(binding.fbUrl.getText().toString());

           // }else
//            {
//                Toast.makeText(activity, "invalid Url!", Toast.LENGTH_SHORT).show();
//            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    class callGetFbData extends AsyncTask<String, Void, Document>
    {
        Document fbDoc;

        @Override
        protected Document doInBackground(String... strings) {
            try {
                fbDoc = Jsoup.connect(strings[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fbDoc;
        }

        @Override
        protected void onPostExecute(Document document) {
            String videoUrl = document.select("meta[property=\"og:video\"]")
                    .last().attr("content");
            if (!videoUrl.equals(""))
                Util.download(videoUrl, Util.RootDirectoryFacebook, activity, "facebook " +System.currentTimeMillis()+".mp4");
        }
    }

//    private void getFaceBookData() {
//        try {
//            URL url = new URL(binding.fbUrl.getText().toString());
//            String host = url.getHost();
//            if (host.contains("facebook.com")) {
//                new CallGetfbData().execute(binding.fbUrl.getText().toString());
//            } else Toast.makeText(activity, "Url is invalid", Toast.LENGTH_SHORT).show();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    class CallGetfbData extends AsyncTask<String, Void, Document> {
//        Document fbDocs;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Document doInBackground(String... strings) {
//            try {
//                fbDocs = Jsoup.connect(strings[0]).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return fbDocs;
//        }
//
//        @Override
//        protected void onPostExecute(Document document) {
//            try {
//
//
//                String videourl = document.select("meta[property=\"og:video\"]").last().attr("content");
//
//                if (!videourl.equals("")) {
//                    try {
//
//
//                        Util.download(videourl, Util.RootDirectoryFacebook, activity, "facebook" + System.currentTimeMillis()+ ".mp4");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } else {
//
//                }
//            } catch (NullPointerException e)
//            {
//                Toast.makeText(FacebookActivity.this,"null error",Toast.LENGTH_SHORT).show();
//                e.printStackTrace();
//            }
//
//
//        }
//
//
//    }
}



















