package com.lumr.sbeam.rpc.impl;

import com.lumr.sbeam.rpc.RPCService;
import com.lumr.sbeam.rpc.RequestData;
import com.lumr.sbeam.rpc.Result;
import com.lumr.sbeam.utils.SerializeUtil;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019/9/27
 **/
public class RPCServiceImpl implements RPCService.Iface, RPCService.AsyncIface {

    private static final Logger LOGGER = LoggerFactory.getLogger(RPCServiceImpl.class);

    @Override
    public Result call(RequestData req) throws TException {
        LOGGER.info("RPC请求: type {},method {}", req.group, req.action);
        Result result = new Result();
        result.code = 200;
        result.message = "ok";
        ByteBuffer buffer = req.data;

        if (req.data != null) {
            int length = buffer.limit() - buffer.position();
            byte[] bytes = new byte[length];
            buffer.get(bytes, 0, length);

            LOGGER.info("数组:{},pos {},limit {}", bytes, req.data.position(), req.data.limit());
            Class c;
            try {
                c = Class.forName(req.className);
                Object game = SerializeUtil.deserialize(bytes, c);
                LOGGER.info("game: {}", game);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (req.param != null) {
            LOGGER.info("param:{}", req.param);
        }

        return result;
    }

    @Override
    public void call(RequestData req, AsyncMethodCallback<Result> resultHandler) throws TException {
        LOGGER.info("RPC ASYNC请求: type {},method {}", req.group, req.action);
        Result result = new Result();
        result.code = 200;
        result.message = "ok";
        ByteBuffer buffer = req.data;
        if (req.data != null) {
            int length = buffer.limit() - buffer.position();
            byte[] bytes = new byte[length];
            buffer.get(bytes, 0, length);
            LOGGER.info("数组:{},pos {},limit {}", bytes, req.data.position(), req.data.limit());
            resultHandler.onComplete(result);
        }
    }
}
