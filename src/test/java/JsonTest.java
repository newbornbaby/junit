import cn.com.spider.pojo.Demo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName JsonTest
 * @Description
 * @Author spiderMao
 * @Date 2020/5/10 10:27
 * @Version V1.0
 **/
public class JsonTest {

    @Test
    public void test() {
        JSONObject obj = new JSONObject();
        obj.put("biz", "bank");
        obj.put("uuid", "3412");
        obj.put("time", new Date().getTime());
        System.out.println(obj.toJSONString());
    }

    @Test
    public void test2() {
        String str = "{\"biz1\":\"bank\",\"time\":1589077895575,\"uuid\":\"3412\"}";
        Demo demo = JSON.parseObject(str, Demo.class);
        System.out.println(demo.toString());
    }
}
