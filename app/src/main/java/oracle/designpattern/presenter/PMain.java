package oracle.designpattern.presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 田帅 on 2017/4/20.
 */

public class PMain implements IMain{

    @Override
    public List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("单例模式");
        list.add("Builder模式");
        list.add("单例模式");
        list.add("单例模式");
        list.add("单例模式");
        list.add("单例模式");
        list.add("单例模式");
        list.add("单例模式");
        list.add("单例模式");
        return list;
    }
}
