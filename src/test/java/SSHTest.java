import cn.com.spider.SSHBasic;
import org.junit.Test;

/**
 * @ClassName SSHTest
 * @Description ssh测试类
 * @Author SpiderMao
 * @Date 2020/4/9 21:44
 * @Version 1.0
 **/
public class SSHTest {
    /**
     * @Description 测试类
     * @Author SpiderMao
     * @CreateDate 2020/4/9 21:44
     **/
    @Test
    public void test() {
        //String hostname = "192.168.111.130";
        String hostname = "server01";
        String username = "admin";
        String password = "123456";
        SSHBasic.SSHConnect(hostname, username, password);
    }
}
