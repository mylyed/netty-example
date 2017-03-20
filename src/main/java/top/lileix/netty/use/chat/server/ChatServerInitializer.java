package top.lileix.netty.use.chat.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import top.lileix.netty.use.chat.client.ChatClientHandler;

/**
 * Created by lilei on 2017/3/19.
 */
public class ChatServerInitializer extends ChannelInitializer<SocketChannel> {


//    private static final StringDecoder DECODER = new StringDecoder();
//    private static final StringEncoder ENCODER = new StringEncoder();
//
//    private static final ChatServerHandler chatServerHandler = new ChatServerHandler();

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new StringDecoder());
        pipeline.addLast(new StringEncoder());
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//        pipeline.addLast(new IdleStateHandler(ChatClient.READ_TIMEOUT, 0, 0));
        pipeline.addLast( new ChatServerHandler());
    }
}
