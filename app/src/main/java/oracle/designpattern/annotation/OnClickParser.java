package oracle.designpattern.annotation;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import oracle.designpattern.R;

/**
 * Created by 田帅 on 2017/4/20.
 */

public class OnClickParser{
    public static void bindOnclick(Object object){
        try {
            parser(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void parser(final Object object) throws Exception{
        try {
            Class<?> cls = object.getClass();
            //得到自定义的方法（自己写的方法，范围为private也同样可以得到）
            //和getMethods的区别的  后者得到object对象中所有的方法（public）
            Method[] methods = cls.getDeclaredMethods();
            for (final Method method : methods) {
                //
                method.setAccessible(true);
                OnClick onClick = method.getAnnotation(OnClick.class);
                if (onClick != null) {
                    //得到控件的id
                    int id = onClick.value();
                    View view = null;
                    //通过id和
                    if (object instanceof Activity){
                        view = ((Activity) object).findViewById(id);
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    method.invoke(object);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
