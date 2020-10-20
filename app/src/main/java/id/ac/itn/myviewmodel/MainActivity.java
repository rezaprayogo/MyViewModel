package id.ac.itn.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    TextView textView;
    Button button;
    MyViewModel mvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        mvm = new ViewModelProvider(this).get(MyViewModel.class);

        mvm.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
                //Log.d(TAG, "onChanged: ubah data ketika onchange");
            }
        });
    }

    @Override
    public void onClick(View view) {
       // textView.setText("Ubah isi tanpa viewmodel");
        //mvm.getData().setValue("Ubah teks dengan setvalue dari activity");  //." getdata() dari livedata ke mutablelivedata di viewmodel");
        //Log.d(TAG, "onClick: ubah data pada event tombol");
        mvm.setData("Ubah isi dari Viewmodel");
    }
}
