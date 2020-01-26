package personal.alex.workoutapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import personal.alex.workoutapp.MainActivity;
import personal.alex.workoutapp.R;
import personal.alex.workoutapp.adapters.RecyclerViewAdapter;
import personal.alex.workoutapp.models.Routine;
import personal.alex.workoutapp.viewmodels.ExistingRoutineViewModel;

public class ExistingRoutineFragment extends Fragment {
    private static final String TAG = "ExistingRoutineFragment";

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private ExistingRoutineViewModel mExistingRoutineViewModel;
    private ImageButton addRoutine;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.existing_routine_frag, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mExistingRoutineViewModel = ViewModelProviders.of(getActivity()).get(ExistingRoutineViewModel.class);
        mExistingRoutineViewModel.init();
        mExistingRoutineViewModel.getRoutines().observe(this, new Observer<List<Routine>>() {
            @Override
            public void onChanged(List<Routine> routines) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();

        addRoutine = view.findViewById(R.id.backButton);

        addRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });


        return view;
    }




    private void initRecyclerView () {
        Log.d(TAG, "initRecyclerView: init RecyclerView.");
        mAdapter = new RecyclerViewAdapter(getActivity(), mExistingRoutineViewModel.getRoutines().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
