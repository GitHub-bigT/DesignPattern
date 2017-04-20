package oracle.designpattern.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import oracle.designpattern.annotation.MethodInfoParser;

/**
 * Created by 田帅 on 2017/4/20.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        //开始注入
        MethodInfoParser.methodInfo(this);
    }
    public abstract int initLayout();
}
