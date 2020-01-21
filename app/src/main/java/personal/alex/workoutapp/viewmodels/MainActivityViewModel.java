package personal.alex.workoutapp.viewmodels;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import personal.alex.workoutapp.models.Routine;
import personal.alex.workoutapp.repositories.RoutineRepository;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Routine>> mRoutine;
    private RoutineRepository mRepo;

    public void init(){
        if(mRoutine != null){
            return;
        }
        mRepo = RoutineRepository.getInstance();
        mRoutine = mRepo.getRoutines();
    }

    public LiveData<List<Routine>> getRoutines(){
        return mRoutine;
    }
}
