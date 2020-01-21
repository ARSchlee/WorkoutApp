package personal.alex.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import personal.alex.workoutapp.adapters.RecyclerViewAdapter;
import personal.alex.workoutapp.models.Routine;
import personal.alex.workoutapp.viewmodels.MainActivityViewModel;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private MainActivityViewModel mMainActivityViewModel;

    //vars
    DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Stated.");

        mRecyclerView = findViewById(R.id.recycler_view);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mMainActivityViewModel.init();

        mMainActivityViewModel.getRoutines().observe(this, new Observer<List<Routine>>() {
            @Override
            public void onChanged(List<Routine> routines) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }


    private void initRecyclerView () {
        Log.d(TAG, "initRecyclerView: init RecyclerView.");
        mAdapter = new RecyclerViewAdapter(this, mMainActivityViewModel.getRoutines().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
