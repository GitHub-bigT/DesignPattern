package oracle.designpattern.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import oracle.designpattern.annotation_reflect.FindViewParser;
import oracle.designpattern.annotation_reflect.MethodInfoParser;
import oracle.designpattern.annotation_reflect.OnClickParser;

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
        FindViewParser.startFind(this);
        ButterKnife.inject(this);
        OnClickParser.bindOnclick(this);
        initData();
    }
    public abstract int initLayout();
    public abstract void initData();
}
