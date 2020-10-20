package id.ac.itn.myviewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private static final String TAG = "MyViewModel";

    private MutableLiveData<String> data;

    public MutableLiveData<String> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            setData("Hallo ViewModel");
        }
        return data;
    }

    public void setData(String data) {
        this.data.postValue(data);
        Log.d(TAG, "setData: post data");
    }
}
