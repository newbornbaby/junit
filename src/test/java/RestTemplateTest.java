import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @ClassName RestTemplateTest
 * @Description 测试类
 * @Author SpiderMao
 * @Date 2020/4/26 15:33
 * @Version 1.0
 **/
public class RestTemplateTest {
    /**
     * @Description 测试类
     * @Author SpiderMao
     * @CreateDate 2020/4/26 15:34
     **/
    @Test
    public void test() {
        String url = "http://192.168.111.130:9180/BANK/bank/test/rule?debug=false";
        // GET请求，返回body转换成String
        Map<String, Object> map = new HashMap();
        map.put("@type", "cn.com.bsfit.sd.bank.BankBankTestEvent");
        map.put("uuid", "Of_FVMMWWaUImAIqxgzt");
        map.put("org", "1");
        map.put("time", new Date().getTime());
        map.put("extra", Maps.newHashMap());
        JSONObject obj = new JSONObject(map);
        JSONArray objs = new JSONArray();
        objs.add(obj);
        //restTemplate.getForObject(url, String.class);
        // POST请求，返回body转换成String，requestEntity中可设置请求头和请求body
        //RestTemplateUtil.post(url, objs);
        //exchange方法可以是任意类型的HTTP方法，返回ResponseEntity类型，可获取response的更多信息
        //restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class).getBody();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        FastJsonHttpMessageConverter fastJson = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        fastJson.setSupportedMediaTypes(mediaTypes);
        converters.add(fastJson);
        RestTemplate restTemplate = new RestTemplate(converters);
        String result = restTemplate.postForObject(url, objs, String.class);
        System.out.println(result);
    }
}
