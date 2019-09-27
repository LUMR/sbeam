package com.lumr.sbeam.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019/9/27
 **/
public class SerializeUtil {

    private static ThreadLocal<LinkedBuffer> LINKED_BUFFER = new ThreadLocal<>();

    @SuppressWarnings("unchecked")
    public static  <T> byte[] serialize(T obj){
        Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(obj.getClass());
        return ProtostuffIOUtil.toByteArray(obj,schema,get());
    }

    public static <T> T deserialize(byte[] bytes,Class<T> tClass){
        Schema<T> schema = RuntimeSchema.getSchema(tClass);
        T result = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(bytes,result,schema);
        return result;
    }

    private static LinkedBuffer get(){
        LinkedBuffer buffer = LINKED_BUFFER.get();
        if (buffer == null){
            buffer = LinkedBuffer.allocate();
            LINKED_BUFFER.set(buffer);
        }else {
            buffer.clear();
        }
        return buffer;
    }
}
