package personal.alex.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import personal.alex.workoutapp.adapters.SectionStatePagerAdapter;
import personal.alex.workoutapp.fragments.ExistingRoutineFragment;
import personal.alex.workoutapp.fragments.NewRoutineFragment;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private SectionStatePagerAdapter mSectionStatePagerAdapter;
    private ViewPager mViewPager;

    //vars
    DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Stated.");

        mSectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);



        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExistingRoutineFragment(), "ExistingRoutineFragment");
        adapter.addFragment(new NewRoutineFragment(), "NewRoutineFragment");
        viewPager.setAdapter(adapter);
    }


    public void setViewPager (int fragmentNumber) {
        mViewPager.setCurrentItem(fragmentNumber);
    }

}
