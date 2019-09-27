package com.lumr.test;

import com.lumr.sbeam.rpc.RPCService;
import com.lumr.sbeam.rpc.RPCService.Processor;
import com.lumr.sbeam.rpc.RequestData;
import com.lumr.sbeam.rpc.impl.RPCServiceImpl;
import com.lumr.sbeam.utils.SerializeUtil;
import com.lumr.sbeam.vo.Game;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TSocket;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019/9/27
 **/
public class RPCTest {

    @Test
    public void req() {
        try {
            TFramedTransport transport = new TFramedTransport(new TSocket("localhost", 9606));
            TCompactProtocol protocol = new TCompactProtocol(transport);
            TAsyncClientManager clientManager = new TAsyncClientManager();
            RPCService.Client client = new RPCService.Client(protocol);

            RPCService.AsyncClient.Factory factory = new RPCService.AsyncClient.Factory(clientManager, new TCompactProtocol.Factory());

            RequestData data = new RequestData("abc", "test");
            data.data = ByteBuffer.wrap(new byte[]{1, 3, 9, 2, 5, 9, 3, 2, 7, 0, 2, 11, 22, 33, 44, 55, 66, 77, 88, 99, 0});
            transport.open();
            for (int i = 0; i < 2000; i++) {
                client.call(data);
            }

            transport.close();
        } catch (TException | IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void curReq() {
        TFramedTransport transport = new TFramedTransport(new TSocket("localhost", 9606));
        TCompactProtocol protocol = new TCompactProtocol(transport);
        RPCService.Client client = new RPCService.Client(protocol);
        try {
            transport.open();
            for (int i = 0; i < 2000; i++) {
                RequestData data = new RequestData("abc", "test");
                Game game = new Game("测试",1,i);
                data.data = ByteBuffer.wrap(SerializeUtil.serialize(game));
                data.className = game.getClass().getName();
                Map<String,String> param = new HashMap<>();
                param.put("名字","叮当");
                data.param = param;
                client.call(data);
            }

        } catch (TException e) {
            e.printStackTrace();
        } finally {
            transport.close();
        }


    }


    @Test
    @SuppressWarnings("unchecked")
    public void listen() {

        try {
            TNonblockingServerSocket socket = new TNonblockingServerSocket(9606, 300);
            TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(socket).workerThreads(2).selectorThreads(1);

            Processor processor = new Processor(new RPCServiceImpl());

            // 配置传输数据的格式
            args.protocolFactory(new TCompactProtocol.Factory());
            // 配置数据传输的方式
            args.transportFactory(new TFramedTransport.Factory());
            // 配置处理器用来处理rpc请求
            args.processorFactory(new TProcessorFactory(processor));
            //最大读取内存数
            args.maxReadBufferBytes = 1024 * 1024L;

            // 本示例中使用半同步半异步方式的服务器模型
            TServer server = new TThreadedSelectorServer(args);
            System.out.println("Thrift Server Started!");
            // 启动服务
            server.serve();

        } catch (Exception e) {

        }

    }
}
