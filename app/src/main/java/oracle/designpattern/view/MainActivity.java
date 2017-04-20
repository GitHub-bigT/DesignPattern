package oracle.designpattern.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import oracle.designpattern.R;
import oracle.designpattern.annotation.MethodInfo;
import oracle.designpattern.annotation.MethodInfoParser;
import oracle.designpattern.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    @MethodInfo(author = "123",version = 22 ,date = "嘿嘿")
    public int initLayout() {
        return R.layout.activity_main;
    }
}
