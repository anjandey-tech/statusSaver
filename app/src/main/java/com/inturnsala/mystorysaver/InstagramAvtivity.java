package com.inturnsala.mystorysaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.ClipData;

import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.inturnsala.mystorysaver.databinding.ActivityInstagramAvtivityBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InstagramAvtivity extends AppCompatActivity {

    private ActivityInstagramAvtivityBinding binding;
    String videoUrl, video;
    private InstagramAvtivity activity;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_instagram_avtivity);
        activity = this;
        dialog = new ProgressDialog(this);
        dialog.setMessage("please wait...");
        dialog.setCancelable(false);
        binding.downloadbtn.setOnClickListener(v->
        {
            binding.instaUrl.getText().toString();
        });




//        binding.downloadbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.show();
//
//
//                if (binding.instaUrl.getText().toString().contains("instagram")) {
//
//                    if (TextUtils.isEmpty(binding.instaUrl.getText().toString())) {
//                        Toast.makeText(activity, "Enter the url of video", Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    } else {
//                        RequestQueue requestQueue;
//                        requestQueue = Volley.newRequestQueue(InstagramAvtivity.this);
//
//                        if (binding.instaUrl.getText().toString().contains("?utm_source=ig_web_copy_link")) {
//                            String partToRemove = "?utm_source=ig_web_copy_link";
//                            video = binding.instaUrl.getText().toString().replace(partToRemove,"");
//                        } else if (binding.instaUrl.getText().toString().contains("?utm_medium=copy_link")) {
//                            String partToRemove = "?utm_medium=copy_link";
//                            video = binding.instaUrl.getText().toString().replace(partToRemove, "");
//                        } else {
//                            video = binding.instaUrl.getText().toString();
//                        }
//
//
//                        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                                "https://instagram-unofficial-api.herokuapp.com/unofficial/api/video?link=" + video, null, new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//
//
//                                try {
//                                    JSONArray jsonArray = response.getJSONArray("info");
//                                    for (int i = 0; i < jsonArray.length(); i++) {
//                                        JSONObject url = jsonArray.getJSONObject(i);
//                                        Log.d("myapp", "" + url.getString("video_url"));
//                                        videoUrl = url.getString("video_url");
//                                        String shortID = url.getString("shortcode");
//                                        Util.download(videoUrl, Util.RootDirectoryInstagram, activity, "Instagram " + shortID + ".mp4");
//
//                                        binding.instaUrl.setText("");
//
//                                        dialog.dismiss();
//                                    }
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//
//
//                        }, new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                Log.d("myapp", "Something went wrong" + error.getMessage());
//                                Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT).show();
//                                binding.instaUrl.setText("");
//                                dialog.dismiss();
//
//                            }
//                        });
//
//                        requestQueue.add(jsonObjectRequest);
//
//                    }
//                }
//                else {
//                    Toast.makeText(activity, "Please enter only Instagram video URL", Toast.LENGTH_SHORT).show();
//                    binding.instaUrl.setText("");
//                    dialog.dismiss();
//                }
//            }
//        });
//        binding.pastebtn.setOnClickListener(new View.OnClickListener() {
//            ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
//            ClipData pasteData = manager.getPrimaryClip();
//            ClipData.Item item = pasteData.getItemAt(0);
//            String paste = item.getText().toString();
//
//
//            @Override
//            public void onClick(View v) {
//                binding.instaUrl.setText(paste);
//            }
//        });


    }
}



