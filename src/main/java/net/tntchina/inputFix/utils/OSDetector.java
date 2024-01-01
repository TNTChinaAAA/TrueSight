package net.tntchina.inputFix.utils;

public class OSDetector {

    String osName = System.getProperty("os.name");

    public static OS detectOS() {
        OSDetector detector = new OSDetector();

        if (detector.isWindows())
            return OS.Windows;

        if (detector.isLinux())
            return OS.Linux;

        if (detector.isMac()) {
            return OS.Mac;
        }

        return OS.Unknown;
    }

    boolean isLinux() {
        return (this.osName.startsWith("Linux") || this.osName.startsWith("FreeBSD") || this.osName.startsWith("SunOS") || this.osName.startsWith("Unix"));
    }

    boolean isMac() {
        return (this.osName.startsWith("Mac OS X") || this.osName.startsWith("Darwin"));
    }

    boolean isWindows() {
        return this.osName.startsWith("Windows");
    }

    public enum OS {
        Windows, Linux, Mac, Unknown
    }
}
