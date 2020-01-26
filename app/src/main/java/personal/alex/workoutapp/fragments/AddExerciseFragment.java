package personal.alex.workoutapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import personal.alex.workoutapp.MainActivity;
import personal.alex.workoutapp.R;

public class AddExerciseFragment extends Fragment {

    private static final String TAG = "AddExerciseFragment";

    private ImageButton backButon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_exercise_frag, container, false);

        backButon = view.findViewById(R.id.backButton);

        backButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        return view;
    }
}
