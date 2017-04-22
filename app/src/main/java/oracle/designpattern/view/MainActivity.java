package oracle.designpattern.view;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import butterknife.OnClick;
import oracle.designpattern.R;
import oracle.designpattern.annotation.FindView;
import oracle.designpattern.annotation.MethodInfo;
import oracle.designpattern.base.BaseActivity;
import oracle.designpattern.presenter.PMain;

public class MainActivity extends BaseActivity {

    @FindView(id = R.id.lv_main)
    private ListView lv_main;
    @FindView(id = R.id.btn_annotation)
    private Button btn_annotation;

    @Override
    @MethodInfo(author = "123", version = 22, date = "嘿嘿")
    public int initLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initData() {
        PMain pMain = new PMain();
        List<String> list = pMain.getData();
        LVAdapter adapter = new LVAdapter(getApplicationContext(),list);
        lv_main.setAdapter(adapter);
    }

    @OnClick(R.id.btn_annotation)
    //不加范围修饰词时默认是friendly（同一个包下的类可以访问）
    void finishMain(View view){
        finish();
    }

}
