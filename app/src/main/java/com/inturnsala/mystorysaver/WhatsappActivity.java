package com.inturnsala.mystorysaver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

public class WhatsappActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);
    }

//     class viewpagerAdapter extends FragmentStateAdapter{
//
//         public viewpagerAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fragmentManager, @NonNull @org.jetbrains.annotations.NotNull Lifecycle lifecycle) {
//             super(fragmentManager, lifecycle);
//         }
//
//         @NonNull
//         @org.jetbrains.annotations.NotNull
//         @Override
//         public Fragment createFragment(int position) {
//             return null;
//         }
//
//         @Override
//         public int getItemCount() {
//             return 0;
//         }
//     }
//
//    class viewpagerAdapter extends FragmentStateAdapter{
//
//        public viewpagerAdapter(@NonNull   FragmentManager fragmentManager, @NonNull   Lifecycle lifecycle) {
//            super(fragmentManager, lifecycle);
//        }
//
//
//
//        @Override
//        public Fragment createFragment(int position) {
//            return null;
//        }
//
//        @Override
//        public int getItemCount() {
//            return 0;
//        }
//    }
}