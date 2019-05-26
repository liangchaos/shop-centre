package com.liangchao.shop.extend;

import com.liangchao.shop.util.DateUtil;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.Date;
/**
 * Description: 打印 txt Banner 扩展
 * User: Administrator-LiangChao
 * Date: 2019-05-24
 * Time: 11:12
 */
public class UserBannerPrinter implements Banner {

    // @formatter:off
    private static final String[] BANNER = { "",
            "  .   ____          _            __ _ _",
            " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\",
            "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\",
            " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )",
            "  '  |____| .__|_| |_|_| |_\\__, | / / / /",
            " =========|_|==============|___/=/_/_/_/" };
    // @formatter:on

    private static final String SPRING_BOOT = " :: Spring Boot :: ";

    private static final int STRAP_LINE_SIZE = 42;
    private Date startDate;

    public UserBannerPrinter (Date startDate) {
        this.startDate = startDate;
    }

   // @Override
    public void printBanner (Environment environment, Class<?> sourceClass, PrintStream printStream) {
        for (String line : BANNER) {
            printStream.println (line);
        }
        String version = SpringBootVersion.getVersion ();
        version = (version != null) ? " (v" + version + ")" : "";
        StringBuilder padding = new StringBuilder ();
        while (padding.length () < STRAP_LINE_SIZE - (version.length () + SPRING_BOOT.length ())) {
            padding.append (" ");
        }

        printStream.println (AnsiOutput.toString (AnsiColor.GREEN, SPRING_BOOT, AnsiColor.DEFAULT, padding.toString (), AnsiStyle.FAINT, version));
        printStream.println (String.format ("%s:%s", environment.getProperty ("spring.application.name"), environment.getProperty ("server.port")));
        printStream.println (String.format ("http://%s:%s", environment.getProperty ("eureka.instance.hostname"), environment.getProperty ("server.port")));
        printStream.println (String.format ("开始时间:%s 执行时间:%s ", DateUtil.dataTime (startDate), DateUtil.time (new Date ().getTime () - startDate.getTime ())));
        printStream.println ();
    }

}
