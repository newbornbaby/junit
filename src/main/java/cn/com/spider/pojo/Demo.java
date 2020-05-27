package cn.com.spider.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import java.util.Date;

/**
 * @ClassName Demo
 * @Description
 * @Author spiderMao
 * @Date 2020/5/10 10:25
 * @Version V1.0
 **/
public class Demo {

    private String biz;

    private String uuid;

    private Date time;

    @JSONField(name="biz1")
    public String getBiz() {
        return biz;
    }

    @JSONField(name="biz1")
    public void setBiz(String biz) {
        this.biz = biz;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "biz='" + biz + '\'' +
                ", uuid='" + uuid + '\'' +
                ", time=" + time +
                '}';
    }
}
