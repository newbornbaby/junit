package cn.com.spider;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description ssh <br>
 * @Author SpiderMao <br>
 * @Version 1.0 <br>
 * @CreateDate 2020/04/09 21:29 <br>
 * @See cn.com.spider <br>
 */
public class SSHBasic {
    /**
     * @Description SSHConnect
     * @Author SpiderMao
     * @Version 1.0
     * @CreateDate 2020/4/9 21:40
     * @Param hostname
     * @Param username
     * @Param password
     * @Return void
     **/
    public static void SSHConnect(String hostname, String username, String password) {
        try {
            /* Create a connection instance */
            Connection conn = new Connection(hostname);
            /* Now connect */
            conn.connect();
            /* Authenticate.
             * If you get an IOException saying something like
             * "Authentication method password not supported by the server at this stage."
             * then please check the FAQ.
             */
            boolean isAuthenticated = conn.authenticateWithPassword(username, password);
            if (isAuthenticated == false)
                throw new IOException("Authentication failed.");
            /* Create a session */
            Session sess = conn.openSession();
            sess.execCommand("uname -a && date && uptime && who");
            System.out.println("Here is some information about the remote host:");
            /*
             * This basic example does not handle stderr, which is sometimes dangerous
             * (please read the FAQ).
             */
            InputStream stdout = new StreamGobbler(sess.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
            /* Show exit status, if available (otherwise "null") */
            System.out.println("ExitCode: " + sess.getExitStatus());
            /* Close this session */
            sess.close();
            /* Close the connection */
            conn.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(2);
        }
    }
}
