package com.dongbawen.thrift.test.thrift;

import com.dongbawen.thrift.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by blank on 2017/6/25.
 */
public class ThriftServer {
    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory())
                .transportFactory(new TFramedTransport.Factory())
                .processorFactory(new TProcessorFactory(processor));
        TServer server = new THsHaServer(arg);
        System.out.println("Server is started.");
        server.serve();
    }
}
