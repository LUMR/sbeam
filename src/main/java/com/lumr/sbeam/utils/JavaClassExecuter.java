package com.lumr.sbeam.utils;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Method;

/**
 * @author lumr
 * @since 2019-03-29 00:41
 */
public class JavaClassExecuter {

    public static String execute(byte[] classByte){
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System","com/lumr/sbeam/utils/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main",new Class[] {String[].class});
            method.invoke(null,new String[] {null});
        }catch (Throwable e) {
            e.printStackTrace();
        }

        return "";
    }
}
