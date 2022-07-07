Codec 框架
====

本章介绍

* Decoder(解码器)
* Encoder(编码器)
* Codec(编解码器)
        
在前面的章节中,我们讨论了连接到拦截操作或数据处理链的不同方式,展示了如何使用 ChannelHandler 及其相关的类来实现几乎任何一种应用程序所需的逻辑。但正如标准架构模式通常有专门的框架,通用处理模式很适合使用目标实现,可以节省我们大量的开发时间和精力。

在这一章,我们将研究编码和解码——数据从一种特定协议格式到另一种格式的转换。这种处理模式是由通常被称为“codecs(编解码器)”的组件来处理的。Netty提供了一些组件,利用它们可以很容易地为各种不同协议编写编解码器。例如,如果您正在构建一个基于 Netty 的邮件服务器，你可以使用[POP3](http://www.ietf.org/rfc/rfc1939.txt), [IMAP](https://www.ietf.org/rfc/rfc2060.txt) 和 [SMTP](15 http://www.ietf.org/rfc/rfc2821.txt)的现成的实现