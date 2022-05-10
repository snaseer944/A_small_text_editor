
package javafx.application;
import com.sun.javafx.application.LauncherImpl;
import com.sun.javafx.application.ParametersImpl;
import com.sun.javafx.application.PlatformImpl;
import java.util.List;
import java.util.Map;
import javafx.application.Preloader.PreloaderNotification;
import javafx.stage.Stage;

public abstract class Application {
    private HostServices hostServices = null;
    private static String userAgentStylesheet = null;

    public static void launch(Class<? extends Application> var0, String... var1) {
        LauncherImpl.launchApplication(var0, var1);
    }


    public Application() {
    }

    public void init() throws Exception {
    }

    public abstract void start(Stage var1) throws Exception;

    public void stop() throws Exception {
    }
    public static void launch(String... var0) {
        StackTraceElement[] var1 = Thread.currentThread().getStackTrace();
        boolean var2 = false;
        String var3 = null;
        StackTraceElement[] var4 = var1;
        int var5 = var1.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            StackTraceElement var7 = var4[var6];
            String var8 = var7.getClassName();
            String var9 = var7.getMethodName();
            if (var2) {
                var3 = var8;
                break;
            }

            if (Application.class.getName().equals(var8) && "launch".equals(var9)) {
                var2 = true;
            }
        }

        if (var3 == null) {
            throw new RuntimeException("Error: unable to determine Application class");
        } else {
            try {
                Class var12 = Class.forName(var3, false, Thread.currentThread().getContextClassLoader());
                if (Application.class.isAssignableFrom(var12)) {
                    LauncherImpl.launchApplication(var12, var0);
                } else {
                    throw new RuntimeException("Error: " + var12 + " is not a subclass of javafx.application.Application");
                }
            } catch (RuntimeException var10) {
                throw var10;
            } catch (Exception var11) {
                throw new RuntimeException(var11);
            }
        }
    }



}
