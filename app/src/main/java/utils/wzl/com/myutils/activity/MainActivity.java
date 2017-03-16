package utils.wzl.com.myutils.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.wzl.com.myutils.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.statusLayout, R.id.permission})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.statusLayout:
                startActivity(new Intent(this, StatusLayoutActivity.class));
                break;
            case R.id.permission:
                startActivity(new Intent(this, PermissionActivity.class));
                break;
        }
    }
}
