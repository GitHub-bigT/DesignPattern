package oracle.designpattern.annotation;

import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by 田帅 on 2017/4/20.
 */

public class MethodInfoParser {

    private final static String TAG = "parser";

    public static void methodInfo(Object object) {
        try {
            parse(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(Object object) throws Exception {
        Log.d(TAG, "class name : " + object.getClass().getName());
        try{
            Class<?> cls = object.getClass();
            for (Method method : cls.getMethods()) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                if (methodInfo != null) {
                    Log.d(TAG, "method name : " + method.getName());
                    Log.d(TAG, "method author : " + methodInfo.author());
                    Log.d(TAG, "method version : " + methodInfo.version());
                    Log.d(TAG, "method date : " + methodInfo.date());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
