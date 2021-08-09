package com.inturnsala.mystorysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.Toast;

import com.inturnsala.mystorysaver.databinding.ActivityInstagramAvtivityBinding;
import com.inturnsala.mystorysaver.databinding.ActivityYouTubeBinding;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;

public class YouTubeActivity extends AppCompatActivity {

    private ActivityYouTubeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_you_tube);

        binding.downloadbtn.setOnClickListener(v->ytvideos());
    }

    private void ytvideos()
    {

        if(TextUtils.isEmpty(binding.YoutubeUrl.getText().toString()))
        {
            Toast.makeText(this,"please provide url",Toast.LENGTH_SHORT).show();
        }else
        {

            new YouTubeExtractor(this) {
                @Override
                public void onExtractionComplete(SparseArray<YtFile> ytFiles, VideoMeta vMeta) {
                    if (ytFiles != null) {
                        int itag = 22;
                        String downloadUrl = ytFiles.get(itag).getUrl();

                        Util.download(downloadUrl,Util.RootDirectoryYouTube,YouTubeActivity.this
                        ,"youtube"+System.currentTimeMillis()+".mp4");
                    }
                }
            }.extract(binding.YoutubeUrl.getText().toString());
        }
    }
}