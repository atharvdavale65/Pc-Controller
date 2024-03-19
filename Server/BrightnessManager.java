import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BrightnessManager {
    public static void setBrightness(int brightness)
            throws IOException {
        
        String s = String.format("$brightness = %d;", brightness)
                + "$delay = 0;"
                + "$myMonitor = Get-WmiObject -Namespace root\\wmi -Class WmiMonitorBrightnessMethods;"
                + "$myMonitor.wmisetbrightness($delay, $brightness)";
        String command = "powershell.exe  " + s;
        
        Process powerShellProcess = Runtime.getRuntime().exec(command);

        powerShellProcess.getOutputStream().close();

        
        String line;

        BufferedReader stderr = new BufferedReader(new InputStreamReader(
                powerShellProcess.getErrorStream()));
        line = stderr.readLine();
        if (line != null)
        {
            System.err.println("Standard Error:");
            do
            {
                System.err.println(line);
            } while ((line = stderr.readLine()) != null);

        }
        stderr.close();

    }
}