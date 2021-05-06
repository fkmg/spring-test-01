package com.sxt.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class TestHash {

    @Test
    public void testMd5(){
        //md5加密，不加盐
        String password_md5 = new Md5Hash("sxt").toString();
        System.out.println("md5加密，不加盐="+password_md5);
        //md5加密，加盐，一次散列
        String password_md5_sale_1 = new Md5Hash("admin", ByteSource.Util.bytes("aa"+"acde96ad-32e9-4c9c-8555-a90a282193a1"), 1).toString();
        System.out.println("password_md5_sale_1="+password_md5_sale_1);
        String password_md5_sale_2 = new Md5Hash("123456", "sxt", 2).toString();
        System.out.println("password_md5_sale_2="+password_md5_sale_2);
        //两次散列相当于md5(md5())
        //使用SimpleHash
        String simpleHash = new SimpleHash("MD5", "123456", "sxt",1).toString();
        System.out.println(simpleHash);
    }
}
