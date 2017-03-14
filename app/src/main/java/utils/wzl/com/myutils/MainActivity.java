package utils.wzl.com.myutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.wzl.com.myutils.application.App;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.statusLayout)
    public void onClick() {
        Toast.makeText(App.getContext(),"布局gsdfdf eng",Toast.LENGTH_SHORT).show();
    }
}
