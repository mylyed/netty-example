package lileix.netty.test;

import io.netty.util.internal.SystemPropertyUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lilei on 2017/3/17.
 */
public class AppTest {
    public static final String HTTP_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";
    public static final String HTTP_DATE_GMT_TIMEZONE = "GMT";
    static SimpleDateFormat dateFormatter = new SimpleDateFormat(HTTP_DATE_FORMAT, Locale.US);

    public static void main(String[] args) {
//        String path = SystemPropertyUtil.get("user.dir");
//        System.out.println(path);
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(dateFormatter.format(new Date()));
         final StringBuilder buf = new StringBuilder();
        buf.append("aaaaaaa");
        System.out.println(buf.toString());
        buf.setLength(0);
        System.out.println(buf.toString());
        buf.append("bbbb");
        System.out.println(buf.toString());
    }
}
