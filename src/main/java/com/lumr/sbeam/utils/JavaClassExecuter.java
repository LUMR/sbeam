package com.lumr.sbeam.utils;

import java.lang.reflect.Method;

/**
 * @author lumr
 * @since 2019-03-29 00:41
 */
public class JavaClassExecuter {
    public static String execute(byte[] classByte){
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System","org/fennixsoft/classloading/execute/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null,new String[] {null});
        }catch (Throwable e){
            e.printStackTrace();
        }

        return "";
    }
}
