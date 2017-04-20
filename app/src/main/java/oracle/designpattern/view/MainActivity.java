package oracle.designpattern.view;

import android.widget.ListView;

import java.util.List;

import oracle.designpattern.R;
import oracle.designpattern.annotation.FindView;
import oracle.designpattern.annotation.FindViewParser;
import oracle.designpattern.annotation.MethodInfo;
import oracle.designpattern.base.BaseActivity;
import oracle.designpattern.presenter.PMain;

public class MainActivity extends BaseActivity {

    @FindView(id = R.id.lv_main)
    private ListView lv_main;


    @Override
    @MethodInfo(author = "123", version = 22, date = "嘿嘿")
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        FindViewParser.startFind(this);
    }

    @Override
    public void initData() {
        PMain pMain = new PMain();
        List<String> list = pMain.getData();
        LVAdapter adapter = new LVAdapter(getApplicationContext(),list);
        lv_main.setAdapter(adapter);
    }


}
