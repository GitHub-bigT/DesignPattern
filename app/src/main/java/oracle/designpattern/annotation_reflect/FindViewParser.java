package oracle.designpattern.annotation_reflect;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by 田帅 on 2017/4/20.
 */

public class FindViewParser {

    public static void startFind(Object object1) {
        try {
            parse(object1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startFind(Object object1, Object object2) {
        try {
            parse(object1, object2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parse(Object object) throws Exception {
        try {
            Class<?> cls = object.getClass();
            View view = null;
            //通过class得到公开的变量
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                //通过反射得到FindView注解
                FindView findView = field.getAnnotation(FindView.class);
                int id = findView.id();
                if (id < 0) {
                    throw new Exception("it not null");
                } else {
                    //设置
                    field.setAccessible(true);
                    //判断object是view传入的还是activity传入的
                    if (object instanceof View) {
                        view = ((View) object).findViewById(id);
                    } else if (object instanceof Activity) {
                        view = ((Activity) object).findViewById(id);
                    }
                    field.set(object, view);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parse(Object object1, Object object2) throws Exception {
        try {
            Class<?> cls = object1.getClass();
            View view = null;
            //通过class得到公开的变量
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                //通过反射得到FindView注解
                FindView findView = field.getAnnotation(FindView.class);
                if (findView != null) {
                    int id = findView.id();
                    if (id < 0) {
                        throw new Exception("it not null");
                    } else {
                        //设置
                        field.setAccessible(true);
                        //判断object是view传入的还是activity传入的
                        if (object2 instanceof View) {
                            view = ((View) object2).findViewById(id);
                        } else if (object2 instanceof Activity) {
                            view = ((Activity) object2).findViewById(id);
                        }
                        field.set(object1, view);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
