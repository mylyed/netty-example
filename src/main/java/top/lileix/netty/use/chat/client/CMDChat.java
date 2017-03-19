package top.lileix.netty.use.chat.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by lilei on 2017/3/19.
 */
public class CMDChat {

    Channel channel;

    public CMDChat(Channel channel) {
        this.channel = channel;
    }

    public void chat() {
        try {
            ChannelFuture lastWriteFuture = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                String line = null;
                line = in.readLine();
                if (line == null) {
                    break;
                }
                lastWriteFuture = channel.writeAndFlush(line + "\r\n");
                if ("bye".equals(line.toLowerCase())) {
                    channel.closeFuture().sync();
                    break;
                }
            }
            if (lastWriteFuture != null) {
                lastWriteFuture.sync();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
