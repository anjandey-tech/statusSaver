package com.inturnsala.mystorysaver;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

public class Util
{
    public static String  RootDirectoryFacebook = "/MyStorySaver/Facebook/";

    public static String  RootDirectoryShareChat = "/MyStorySaver/sharechat/";

    public static String  RootDirectoryInstagram = "/MyStorySaver/Instagram/";

    public static String  RootDirectoryYouTube = "/MyStorySaver/youTube/";

    public static File  RootDirectoryWhatapp = new File(Environment.getExternalStorageDirectory()
    +"/Download/MyStorySaver/Whatsapp");



    public static void createFileFolder()
    {
        if(!RootDirectoryWhatapp.exists())
            RootDirectoryWhatapp.mkdirs();
    }

    public static void download(String downloadPath, String destinationPath, Context context, String filename)
    {
        Toast.makeText(context,"download started",Toast.LENGTH_SHORT).show();
        Uri uri = Uri.parse(downloadPath);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle(filename);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,destinationPath+filename);
        ((DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE)).enqueue(request);


    }

}
