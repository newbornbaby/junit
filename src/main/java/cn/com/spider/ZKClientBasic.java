package cn.com.spider;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @ClassName ZKClientBasic
 * @Description zk客户端基本操作
 * @Author SpiderMao
 * @Date 2020/4/16 17:44
 * @Version 1.0
 **/
public class ZKClientBasic {

    private String connectionInfo = "192.168.111.130:2181";

    private CuratorFramework zkClient = null;

    /**
     * @Description 初始化一个客户端
     * @Author SpiderMao
     * @Version 1.0
     * @CreateDate 2020/4/16 18:14
     * @Param
     * @Return
     **/
    public ZKClientBasic() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        // namespace("/base")设置一个根目录
        zkClient = CuratorFrameworkFactory.builder()
                .connectString(connectionInfo)
                .sessionTimeoutMs(6000)
                .connectionTimeoutMs(6000)
                .retryPolicy(retryPolicy)
                .namespace("base")
                .build();
        // 使用client前必须先启动
        this.zkClient.start();
    }

    /**
     * @Description 创建节点
     * @Author SpiderMao
     * @Version 1.0
     * @CreateDate 2020/4/16 17:59
     * @Param
     * @Return void
     **/
    public void createNode(String path) {
        try {
            zkClient.create().forPath(path);
        } catch (Exception e) {
            System.out.println("创建节点失败。");
            e.printStackTrace();
        }
    }

    /**
     * @Description 删除一个节点（只能删除叶子节点）
     * @Author SpiderMao
     * @Version 1.0
     * @CreateDate 2020/4/16 18:09
     * @Param
     * @Return
     **/
    public void deleteNode(String path) {
        try {
            zkClient.delete().forPath(path);
        } catch (Exception e) {
            System.out.println("删除节点失败。");
        }
    }

    /**
     * @Description 读取一个节点的内容
     * @Author SpiderMao
     * @Version 1.0
     * @CreateDate 2020/4/16 18:11
     * @Param
     * @Return
     **/
    public void readNode(String path) {
        try {
            byte[] bytes = zkClient.getData().forPath(path);
            String str = new String(bytes, "UTF-8");
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("读取节点内容失败。");
            e.printStackTrace();
        }
    }

    /**
     * @Description 更新节点数据
     * @Author SpiderMao
     * @Version 1.0
     * @CreateDate 2020/4/16 18:13
     * @Param
     * @Return
     **/
    public void updateNode(String path, String data) {
        try {
            zkClient.setData().forPath(path, data.getBytes("UTF-8"));
        } catch (Exception e) {
            System.out.println("更新节点内容失败。");
        }
    }

    /**
     * @Description 判断节点是否存在
     * @Author SpiderMao
     * @Version 1.0
     * @CreateDate 2020/4/16 18:18
     * @Param
     * @Return
     **/
    public void existsNode(String path) {
        try {
            zkClient.checkExists().forPath(path);
        } catch (Exception e) {
            System.out.println("查询节点状态失败。");
        }
    }

}
