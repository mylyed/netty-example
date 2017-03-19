package top.lileix.netty.use.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 聊天-客户端
 * Created by lilei on 2017/3/19.
 */
public class ChatClient {

    static final String HOST = "127.0.0.1";
    static final int PORT = 1017;
public  static final int READ_TIMEOUT=10;
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());
            Channel ch = b.connect(HOST, PORT).sync().channel();
            CMDChat cmdChat=new CMDChat(ch);
            cmdChat.chat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
