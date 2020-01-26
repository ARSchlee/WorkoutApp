package personal.alex.workoutapp.repositories;

import android.media.MediaRouter;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import personal.alex.workoutapp.models.Routine;

public class RoutineRepository {

    private static RoutineRepository instance;
    private ArrayList<Routine> dataSet = new ArrayList<>();

    public static RoutineRepository getInstance(){
        if(instance==null){
            instance = new RoutineRepository();
        }
        return instance;
    }

    //Pretend to get data from a webservice or online source
    public MutableLiveData<List<Routine>> getRoutines(){
        setRoutines();

        MutableLiveData<List<Routine>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;

    }

    private void setRoutines(){
        dataSet.add(new Routine("Chest Day"));
        dataSet.add(new Routine("Leg Day"));
        dataSet.add(new Routine("Shoulder Day"));
        dataSet.add(new Routine("Leg Day"));
        dataSet.add(new Routine("Arm Day"));
        dataSet.add(new Routine("Circuit"));
        dataSet.add(new Routine("Body Weight"));
    }
}
