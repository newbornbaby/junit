import cn.com.spider.SSHBasic;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author SpiderMao
 * @Date 2020/4/27 20:27
 * @Version 1.0
 **/
public class Test2 {

    /**
     * @Description 测试类
     * @Author SpiderMao
     * @CreateDate 2020/4/27 20:27
     **/
    @Test
    public void test() {
        //SSHBasic sshBasic = new SSHBasic();
        //System.out.println(sshBasic.getClass());
        System.out.println(SSHBasic.class.getName());
    }

    /**
     * @Description 测试类
     * @Author SpiderMao
     * @CreateDate 2020/5/5 18:52
     **/
    @Test
    public void test2() {
        List<String> list1 = Lists.newArrayListWithCapacity(1);
        list1.add("1");
        list1.add("2");
        list1.add("3");
        Iterator itr = list1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        list1.forEach((s) -> System.out.println(s));
        long a = list1.stream().filter(x -> x.length() > 0).count();
        System.out.println(a);

        LinkedList<String> list2 = Lists.newLinkedList();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.forEach((s) -> System.out.println(s));
    }


}
