package uk.co.innoxium.swing.util;

import javax.swing.*;
import java.io.IOException;

public class DesktopUtil {

    // We must use toLowerCase to accurately check the string later on
    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static void openURL(String domain) {

        openURL("https://", domain);
    }

    public static void openURL(String protocol, String domain) {

        String url = protocol + domain;
        Runtime rt = Runtime.getRuntime();
        try {

            if (isWindows()) {

                rt.exec("rundll32 url.dll,FileProtocolHandler " + url).waitFor();
            } else if (isMac()) {

                String[] cmd = {"open", url};
                rt.exec(cmd).waitFor();
            } else if (isUnix()) {

                String[] cmd = {"xdg-open", url};
                rt.exec(cmd).waitFor();
            } else {

                try {

                    throw new IllegalStateException();
                } catch (IllegalStateException e1) {

                    JOptionPane.showMessageDialog(null, "Desktop not supported. Unable to open link");
                    e1.printStackTrace();
                }
            }
        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static boolean isWindows() {

        return OS.contains("win");
    }

    public static boolean isMac() {

        return OS.contains("mac");
    }

    public static boolean isUnix() {

        return OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0;
    }
}
