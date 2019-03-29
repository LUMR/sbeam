package com.lumr.sbeam.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author lumr
 * @since 2019-03-28 23:13
 */
@Scope()
public class HotSwapClassLoader extends ClassLoader {

    private HashMap<String, byte[]> classBytes = new HashMap<>();

    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(String fileName, String javaStr) {
        JavaCompiler jCompiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager stdManager = jCompiler.getStandardFileManager(null, null, null);
        try (MemoryJavaFileManager fileManager = new MemoryJavaFileManager(stdManager)) {
            JavaFileObject fileObject = fileManager.makeStringSource(fileName, javaStr);
            JavaCompiler.CompilationTask task = jCompiler.getTask(null, fileManager, null, null, null, Collections.singletonList(fileObject));
            if (task.call()) {
                String className = fileManager.classBytes.keySet().stream().filter(k -> !k.contains("$")).findFirst().orElse(null);
                classBytes.putAll(fileManager.classBytes);
                return this.loadByte(classBytes.remove(className));
            }
        }

        return null;
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (classBytes.containsKey(name)) {
            byte[] clazzB = classBytes.remove(name);
            return defineClass(name, clazzB, 0, clazzB.length);
        }
        return super.findClass(name);
    }
}
