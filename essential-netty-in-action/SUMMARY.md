# Summary

This is the summary of my book.

* 开始
	* [Netty-异步和数据驱动](GETTING STARTED/Asynchronous and Event Driven.md)
		* [Netty 介绍](GETTING STARTED/Introducing Netty.md)
		* [构成部分](GETTING STARTED/Building Blocks.md)
		* [关于本书](GETTING STARTED/About this Book.md)
	* [第一个 Netty 应用](GETTING STARTED/Your first Netty application.md)
		* [设置开发环境](GETTING STARTED/Setting up the development environment.md)
		* [Netty 客户端/服务端 总览](GETTING STARTED/Netty client  server overview.md)
		* [写一个 echo 服务器](GETTING STARTED/Writing the echo server.md)
		* [写一个 echo 客户端](GETTING STARTED/Writing an echo client.md)
		* [编译和运行 Echo 服务器和客户端](GETTING STARTED/Building and running the Echo Server and Client.md)
		* [总结](GETTING STARTED/Summary.md)
	* [Netty 总览](GETTING STARTED/Netty Overview.md)
		* [Netty 快速入门](GETTING STARTED/Netty Crash Course.md)
		* [Channel, Event 和 I/O](GETTING STARTED/Channels and Events and IO.md)
		* [什么是 Bootstrapping 为什么要用](GETTING STARTED/The What and Why of Bootstrapping.md)
		* [ChannelHandler 和 ChannelPipeline](GETTING STARTED/ChannelHandler and ChannelPipeline.md)
		* [近距离观察 ChannelHandler](GETTING STARTED/A Closer Look at ChannelHandlers.md)
		* [总结](GETTING STARTED/3.6  Summary.md)
* 核心功能
 	* [Transport（传输）](CORE FUNCTIONS/Transports.md)
		* [案例研究:Transport 的迁移](CORE FUNCTIONS/Case study transport migration.md)
		* [Transport API](CORE FUNCTIONS/Transport API.md)
		* [包含的 Transport](CORE FUNCTIONS/Included transports.md)
		* [Transport 使用情况](CORE FUNCTIONS/Transport Use Cases.md)
		* [总结](CORE FUNCTIONS/4.5  Summary.md)
 	* [Buffer（缓冲）](CORE FUNCTIONS/Buffers.md)
		* [Buffer API](CORE FUNCTIONS/Buffer API.md)
		* [ByteBuf - 字节数据的容器](CORE FUNCTIONS/ByteBuf - The byte data container.md)
		* [字节级别的操作](CORE FUNCTIONS/Byte-level Operations.md)
		* [ByteBufHolder](CORE FUNCTIONS/ByteBufHolder.md)
		* [ByteBuf 分配](CORE FUNCTIONS/ByteBuf allocation.md)
		* [引用计数器](CORE FUNCTIONS/Reference counting.md)
		* [总结](CORE FUNCTIONS/5.7  Summary.md)
 	* [ChannelHandler 和 ChannelPipeline](CORE FUNCTIONS/ChannelHandler and ChannelPipeline.md)
		* [ChannelHandler 家族](CORE FUNCTIONS/The ChannelHandler Family.md)
		* [ChannelPipeline](CORE FUNCTIONS/ChannelPipeline.md)
		* [ChannelHandlerContext](CORE FUNCTIONS/ChannelHandlerContext.md)
		* [总结](CORE FUNCTIONS/6.4  Summary.md)
 	* [Codec 框架](CORE FUNCTIONS/The Codec Framework.md)
		* [什么是 Codec](CORE FUNCTIONS/What is a Codec.md)
		* [Decoder(解码器)](CORE FUNCTIONS/Decoders.md)
		* [Encoder(编码器)](CORE FUNCTIONS/Encoders.md)
		* [抽象 Codec(编解码器)类](CORE FUNCTIONS/Abstract Codec classes.md)
		* [总结](CORE FUNCTIONS/7.5  Summary.md)
 	* [提供了的 ChannelHandler 和 Codec](CORE FUNCTIONS/Provided ChannelHandlers and Codecs.md)
		* [使用 SSL/TLS 加密 Netty 程序](CORE FUNCTIONS/Securing Netty applications with SSLTLS.md)
		* [构建 Netty HTTP/HTTPS 应用](CORE FUNCTIONS/Building Netty HTTPHTTPS applications.md)
		* [空闲连接以及超时](CORE FUNCTIONS/Idle connections and Timeouts.md)
		* [解码分隔符和基于长度的协议](CORE FUNCTIONS/Decoding delimited and length-based protocols.md)
		* [编写大型数据](CORE FUNCTIONS/Writing big data.md)
		* [序列化数据](CORE FUNCTIONS/Serializing data.md)
		* [总结](CORE FUNCTIONS/8.7  Summary.md)
 	* [引导](CORE FUNCTIONS/Bootstrapping.md)
		* [Bootstrap 类型](CORE FUNCTIONS/Bootstrap types.md)
		* [引导客户端和无连接协议](CORE FUNCTIONS/Bootstrapping clients and connectionless protocols.md)
		* [引导服务器](CORE FUNCTIONS/Bootstrapping servers.md)
		* [从 Channel 引导客户端](CORE FUNCTIONS/Bootstrapping clients from a Channel.md)
		* [在一个引导中添加多个 ChannelHandler](CORE FUNCTIONS/Adding multiple ChannelHandlers during a bootstrap.md)
		* [使用Netty 的 ChannelOption 和属性](CORE FUNCTIONS/Using Netty ChannelOptions and Attributes.md)
		* [关闭之前已经引导的客户端或服务器](CORE FUNCTIONS/Shutting down a previously bootstrapped Client or Server.md)
		* [总结](CORE FUNCTIONS/9.9  Summary.md)
* NETTY 实例
	* [单元测试](NETTY BY EXAMPLE/Unit Testing.md)
		* [总览](NETTY BY EXAMPLE/Overview.md)
		* [测试 ChannelHandler](NETTY BY EXAMPLE/Testing ChannelHandler.md)
		* [测试异常处理](NETTY BY EXAMPLE/Testing exception handling.md)
		* [总结](NETTY BY EXAMPLE/10.4 Summary.md)
	* [WebSocket](NETTY BY EXAMPLE/WebSockets.md)
		* [WebSocket 程序示例](NETTY BY EXAMPLE/The example WebSockets application.md)
		* [添加 WebSocket 支持](NETTY BY EXAMPLE/Adding WebSockets support.md)
		* [测试程序](NETTY BY EXAMPLE/Testing the Application.md)
		* [总结](NETTY BY EXAMPLE/11.4 Summary.md)
	* [SPDY](NETTY BY EXAMPLE/SPDY.md)
		* [SPDY 背景](NETTY BY EXAMPLE/SPDY background.md)
		* [示例程序](NETTY BY EXAMPLE/The sample application.md)
		* [实现](NETTY BY EXAMPLE/Implementation.md)
		* [启动 SpdyServer 并测试](NETTY BY EXAMPLE/Start the SpdyServer and test it.md)
		* [总结](NETTY BY EXAMPLE/12.5 Summary.md)
	* [通过 UDP 广播事件](NETTY BY EXAMPLE/Broadcasting events with UDP.md)
		* [UDP 基础](NETTY BY EXAMPLE/UDP Basics.md)
		* [UDP 广播](NETTY BY EXAMPLE/UDP Broadcast.md)
		* [UDP 示例](NETTY BY EXAMPLE/The UDP Sample Application.md)
		* [EventLog 的 POJO](NETTY BY EXAMPLE/EventLog POJOs.md)
		* [写广播器](NETTY BY EXAMPLE/Writing the broadcaster.md)
		* [写监视器](NETTY BY EXAMPLE/Writing the monitor.md)
		* [运行 LogEventBroadcaster 和 LogEventMonitor](NETTY BY EXAMPLE/Running the LogEventBroadcaster and LogEventMonitor.md)
		* [总结](NETTY BY EXAMPLE/13.8 Summary.md)
* 高级主题
	* [实现自定义的编解码器](ADVANCED TOPICS/Implement a custom codec.md)
		* [编解码器的范围](ADVANCED TOPICS/Scope of the codec.md)
		* [实现 Memcached 编解码器](ADVANCED TOPICS/Implementing the Memcached codec.md)
		* [了解 Memcached 二进制协议](ADVANCED TOPICS/Getting to know the Memcached binary protocol.md)
		* [Netty 编码器和解码器](ADVANCED TOPICS/Netty encoders and decoders.md)
		* [测试编解码器](ADVANCED TOPICS/Testing the codec.md)
		* [总结](ADVANCED TOPICS/14.6 Summary.md)
	* [EventLoop 和线程模型](ADVANCED TOPICS/EventLoop and thread model.md)
		* [线程模型的总览](ADVANCED TOPICS/Thread model overview.md)
		* [EventLoop](ADVANCED TOPICS/The EventLoop.md)
		* [EventLoop](ADVANCED TOPICS/Scheduling tasks for later execution.md)
		* [I/O EventLoop/Thread 分配细节](ADVANCED TOPICS/IO EventLoop Thread allocation in detail.md)
		* [总结](ADVANCED TOPICS/15.6 Summary.md)
	* [用例1：Droplr Firebase 和 Urban Airship](ADVANCED TOPICS/Droplr Firebase and Urban Airship.md)
	* [用例2：Facebook 和 Twitter](ADVANCED TOPICS/Facebook and Twitter.md)