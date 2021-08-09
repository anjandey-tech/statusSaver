package com.inturnsala.mystorysaver.fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inturnsala.mystorysaver.R;
import com.inturnsala.mystorysaver.adapter.WhatsAppAdapter;
import com.inturnsala.mystorysaver.databinding.FragmentImageBinding;
import com.inturnsala.mystorysaver.models.WhatsAppStatusModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class VideoFragment extends Fragment {

    private FragmentImageBinding binding;
    private ArrayList<WhatsAppStatusModel> list;
    private WhatsAppAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_image,container,false);
        list = new ArrayList<>();
        getData();
        binding.refresh.setOnRefreshListener(()->{

            list = new ArrayList<>();
            getData();
            binding.refresh.setRefreshing(false);
        });

        return binding.getRoot();
    }
    private void getData()
    {
        WhatsAppStatusModel model;

        String targetpath = Environment.getExternalStorageDirectory().getAbsolutePath()+
                "/WhatsApp/Media/.statuses";
        File targetDirectory = new File(targetpath);

        File[] allfile = targetDirectory.listFiles();
        String targetpathBusiness = Environment.getExternalStorageDirectory().getAbsolutePath()+
                "/WhatsApp Business/Media/.statuses";
        File targetDirectoryBusiness = new File(targetpathBusiness);

        File[] allfileBusiness = targetDirectoryBusiness.listFiles();

        Arrays.sort(allfile,((o1, o2) -> {
            if (o1.lastModified()>o2.lastModified()) return -1;
            else if(o1.lastModified()<o2.lastModified()) return  +1;
            else return 0;

        }));



        for(int i=0;i<allfile.length;i++)
        {
            File file = allfile[i];
            if(Uri.fromFile(file).toString().endsWith(".mp4"))
            {

                model= new WhatsAppStatusModel("whats" + i,
                        Uri.fromFile(file),
                        allfile[i].getAbsolutePath() ,
                        file.getName());
                list.add(model);
            }
        }

        adapter = new WhatsAppAdapter(list,getActivity());
        binding.whatappRecycler.setAdapter(adapter);


    }
}