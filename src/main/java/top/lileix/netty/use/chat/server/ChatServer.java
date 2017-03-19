package top.lileix.netty.use.chat.server;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by lilei on 2017/3/19.
 */
public class ChatServer {
    /**
     * 端口
     */
    public  static  final int PORT=1017;

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
    }
}
