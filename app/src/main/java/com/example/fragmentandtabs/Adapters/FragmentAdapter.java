package com.example.fragmentandtabs.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fragmentandtabs.FragmentOne;
import com.example.fragmentandtabs.FragmentThree;
import com.example.fragmentandtabs.FragmentTwo;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                return new FragmentOne();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
