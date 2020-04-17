import cn.com.spider.ZKClientBasic;
import org.junit.Test;

/**
 * @ClassName ZKClinetTest
 * @Description TODO
 * @Author SpiderMao
 * @Date 2020/4/16 18:19
 * @Version 1.0
 **/
public class ZKClinetTest {

    /**
     * @Description 测试类
     * @Author SpiderMao
     * @CreateDate 2020/4/16 18:20
     **/
    @Test
    public void test() {
        ZKClientBasic zkClientBasic = new ZKClientBasic();
        //zkClientBasic.createNode("/aaaa");  //创建节点
        //zkClientBasic.deleteNode("/aaaa");  //删除节点
        //zkClientBasic.createNode("/bbbb");
        //zkClientBasic.updateNode("/bbbb", "hello");  //更新节点信息
        zkClientBasic.readNode("/bbbb");  //读取节点信息
    }
}
