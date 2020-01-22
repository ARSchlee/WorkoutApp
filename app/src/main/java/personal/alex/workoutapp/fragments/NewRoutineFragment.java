package personal.alex.workoutapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import personal.alex.workoutapp.MainActivity;
import personal.alex.workoutapp.R;

public class NewRoutineFragment extends Fragment {
    private static final String TAG = "NewRoutineFragment";

    private FloatingActionButton newExFab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_routine_frag_layout, container, false);
        newExFab = view.findViewById(R.id.newRoutineFab);

        newExFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "New Exercise Frag", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });

        return view;
    }
}
