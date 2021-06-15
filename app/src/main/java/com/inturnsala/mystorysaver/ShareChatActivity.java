package com.inturnsala.mystorysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.AsyncTask;
import android.os.Bundle;

import com.inturnsala.mystorysaver.databinding.ActivityShareChatBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ShareChatActivity extends AppCompatActivity {
private ActivityShareChatBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_share_chat);

       binding.downloadbtn.setOnClickListener(v->{
           getShareChatData();
       });
    }

    private void getShareChatData()
    {
        URL url = null;
        try {
            url = new URL(binding.sharexhatUrl.getText().toString());
            String host = url.getHost();
            if(host.contains("sharechat"))
                new CallGetShareChatData().execute(binding.sharexhatUrl.getText().toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
    class CallGetShareChatData extends AsyncTask<String,Void, Document>{
    Document scDocuments;
        @Override
        protected Document doInBackground(String... strings) {
            try {
                scDocuments = Jsoup.connect(strings[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  scDocuments;
        }

        @Override
        protected void onPostExecute(Document document) {
           String videoUrl = document.select("meta[property=\"og:video:secure_url\"]")
                   .last().attr("content");
           if(!videoUrl.equals(""))
           {
               Util.download(videoUrl,Util.RootDirectoryShareChat,ShareChatActivity.this,
                       "sharechat "+System.currentTimeMillis() + ".mp4"
                       );


           }
        }
    }
}