package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: YuRuixue
 * @Description: collection常用方法
 * @date 2022/6/15/0015 10:16
 */
public class CollMethod {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("12");
        coll.add(12);
        coll.add('3');
        Iterator it = coll.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        for (Object o : coll) {
            System.out.println(o);
        }
    }
}
