package com.inturnsala.mystorysaver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.inturnsala.mystorysaver.R;
import com.inturnsala.mystorysaver.Util;
import com.inturnsala.mystorysaver.databinding.WhatsappItemLayoutBinding;
import com.inturnsala.mystorysaver.models.WhatsAppStatusModel;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

import javax.sql.StatementEvent;

public class WhatsAppAdapter extends RecyclerView.Adapter<WhatsAppAdapter.ViewHolder>
{
    private ArrayList<WhatsAppStatusModel>  list;
    private Context context;
    private LayoutInflater inflater;
    private String saveFilePath = Util.RootDirectoryWhatapp+"/";

    public WhatsAppAdapter(ArrayList<WhatsAppStatusModel> list, Context context)
    {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       if(inflater == null)
       {
           inflater = LayoutInflater.from(parent.getContext());

       }


        return new ViewHolder(DataBindingUtil.inflate(inflater, R.layout.whatsapp_item_layout
        ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull WhatsAppAdapter.ViewHolder holder, int position) {

        WhatsAppStatusModel item = list.get(position);
        if(item.getUri().toString().endsWith(".mp4"))
            holder.binding.playbutton.setVisibility(View.VISIBLE);
        else
            holder.binding.playbutton.setVisibility(View.GONE);


        Glide.with(context).load(item.getPath()).into(holder.binding.statusImage);



        holder.binding.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.createFileFolder();
                final String  path = item.getPath();
                final File file = new File(path);
                File destinationfile =new File(saveFilePath);

                try {
                    FileUtils.copyFileToDirectory(file,destinationfile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(context,"saved to : "+saveFilePath,Toast.LENGTH_SHORT).show();
            }


        });








    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder
    {
      WhatsappItemLayoutBinding binding;



        public ViewHolder(WhatsappItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }




}
