package utils.wzl.com.myutils.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import utils.wzl.com.myutils.R;
import utils.wzl.com.utilslibrary.permission.PermissionHelper;

public class PermissionActivity extends AppCompatActivity {
    private PermissionHelper mPermissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        if (Build.VERSION.SDK_INT < 23) {
            // 如果系统版本低于23，直接跑应用的逻辑
            Toast.makeText(this.getApplicationContext(), "运行app", Toast.LENGTH_SHORT).show();
        } else {
            PermissionHelper.PermissionModel[] mPermissionModels = new PermissionHelper.PermissionModel[]{
                    new PermissionHelper.PermissionModel("电话"
                            , Manifest.permission.READ_PHONE_STATE
                            , "我们需要读取手机信息的权限来标识您的身份"
                            , PermissionHelper.READ_PHONE_STATE_CODE),
                    new PermissionHelper.PermissionModel("存储空间"
                            , Manifest.permission.WRITE_EXTERNAL_STORAGE
                            , "我们需要您允许我们读写你的存储卡，以方便我们临时保存一些数据",
                            PermissionHelper.WRITE_EXTERNAL_STORAGE_CODE)
            };

            // 当系统为6.0以上时，需要申请权限
            mPermissionHelper = new PermissionHelper(this, mPermissionModels);
            mPermissionHelper.setOnApplyPermissionListener(new PermissionHelper.OnApplyPermissionListener() {
                @Override
                public void onAfterApplyAllPermission() {
                    Toast.makeText(PermissionActivity.this.getApplicationContext(), "运行app", Toast.LENGTH_SHORT).show();
                }
            });
            // 如果权限全部申请了，那就直接跑应用逻辑
            if (mPermissionHelper.isAllRequestedPermissionGranted()) {
                Toast.makeText(this.getApplicationContext(), "运行app", Toast.LENGTH_SHORT).show();
            } else {
                // 如果还有权限为申请，而且系统版本大于23，执行申请权限逻辑
                mPermissionHelper.applyPermissions();
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mPermissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPermissionHelper.onActivityResult(requestCode, resultCode, data);
    }
}
