package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuRuixue
 * @Description: 奇异LRU
 * @date 2022/7/17/0017 16:46
 */
public class LRU {
    private int cap;
    private ArrayList<Integer> list = new ArrayList<>();

    public LRU(int cap) {
        //容量
        this.cap = cap;
    }

    public void put(int k){
        //存入值
        if(list.size() < cap) {
            list.add(k);
        }else{
            list.remove(cap / 2);
            list.add(k);
        }
    }
    public void del(int k){
        //删除值
       list.remove((Integer) k);
    }
    public int get(int k){
        //获取值并放入尾部
        if(list.contains(k)){
            int i = list.indexOf(k);
            list.remove(i);
            list.add(k);
            return k;
        }
        return -1;
    }
    public List<Integer> getAllElms() {
        return list;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(1);
        lru.put(2);
        lru.put(3);
        lru.del(3);
        lru.get(1);
        lru.put(7);
        lru.put(8);
        lru.put(9);
        System.out.println(lru.getAllElms());

    }
}
