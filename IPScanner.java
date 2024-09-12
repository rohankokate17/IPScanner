import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class IPScanner {

    private static final int TIMEOUT = 1000; 

    public static void main(String[] args) {
        String subnet = "192.168.1"; 

        List<String> activeIPs = scanIPRange(subnet);

        System.out.println("Active IPs in range " + subnet + ".1 to " + subnet + ".254:");
        for (String ip : activeIPs) {
            System.out.println(ip);
        }
    }

    public static List<String> scanIPRange(String subnet) {
        List<String> activeIPs = new ArrayList<>();
        
        for (int i = 1; i < 255; i++) {
            String ip = subnet + "." + i;
            try {
                InetAddress address = InetAddress.getByName(ip);
                if (address.isReachable(TIMEOUT)) {
                    activeIPs.add(ip);
                }
            } catch (Exception e) {
                // Handle exceptions
                System.out.println("Error checking " + ip);
            }
        }
        return activeIPs;
    }
}
