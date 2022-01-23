# Tabs_and_Fragment_ViewPager2
Using Tabs and Fragment in App also ViewPager2 &amp; Adapter

# Code

### FragmentOne.java
```
public class FragmentOne extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
}
```

#### FragmentAdapter.java
```
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
```

#### MainActivity.java
```
ViewPager2 viewPager2;
TabLayout tabLayout;
FragmentAdapter fragmentAdapter;

//set the status bar color
getWindow().setStatusBarColor(getResources().getColor(R.color.teal_700));

FragmentManager fragmentManager = getSupportFragmentManager();
fragmentAdapter = new FragmentAdapter(fragmentManager, getLifecycle());
viewPager2.setAdapter(fragmentAdapter);



FragmentAdapter fragmentAdapter;
TabLayout tabLayout;
ViewPager2 viewPager2;

viewPager2 = findViewById(R.id.viewPager2);
tabLayout = findViewById(R.id.tabLayout);

fragmentAdapter = new FragmentAdapter(this);

viewPager2.setAdapter(fragmentAdapter);

// Method 1
//new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(titles[position]))).attach();

// Method 2
tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
```

# App Highlight

<img src="app_images/Fragment and Tabs Code.png" width="1000" /><br>

<img src="app_images/Fragment and Tabs App.png" width="300" />
