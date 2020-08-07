package com.bz.cadenceclient.activities;

/**
 * @author:11411
 * @date: 2020/8/7 15:03
 **/
public class BeforeHelloActivityImpl implements BeforeHelloActivity {


    @Override
    public String offer(String mes) {
        try {
            //模拟暂停
            Thread.sleep(3000);
            System.out.println("暂停三秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "delivery: " + mes;
    }
}
