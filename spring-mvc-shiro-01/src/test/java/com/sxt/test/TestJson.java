package com.sxt.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestJson {


    @Test
    public void testGetJson() throws IOException {
        File filestr = new File("G:\\html\\test\\src.txt");

        File filedest = new File("G:\\html\\test\\dest.txt");
        //读取文件
        String str = FileUtils.readFileToString(filestr);
        //将字符串转换成json对象
        JSONArray jsonArray = JSONArray.parseArray(str);
        Map<Integer, List<JSONObject>> jsonMap = new HashMap<>();
        JSONObject jsonObject = null;
        List<JSONObject> jsonObjects = null;
        for(int i = 0; i< jsonArray.size();i++){
            jsonObject = jsonArray.getJSONObject(i);
            Integer id = jsonObject.getInteger("parent_id");
            jsonObjects = jsonMap.get(id);
            if(jsonObjects == null){
                jsonObjects = new ArrayList<>();
            }
            jsonObjects.add(jsonObject);
            jsonMap.put(id,jsonObjects);
        }

        JSONObject obj = new JSONObject();
        obj.put("id",0);
        obj.put("name","");
        obj.put("parent_id",-1);

        //将map中的值转换载到obj中
        getChild(obj,jsonMap,0);

        JSONArray result = obj.getJSONArray("children");

        FileUtils.writeStringToFile(filedest,result.toJSONString());
    }

    private void getChild(JSONObject obj,Map<Integer, List<JSONObject>> jsonMap,Integer parentId){
        List<JSONObject> jsonObjects = jsonMap.get(parentId);
        JSONObject jsonObject = null;
        if(jsonObjects == null){
            obj.put("children",new ArrayList<JSONObject>());
            return;
        }
        //不为空循环遍历
        else {
            obj.put("children",jsonObjects);
            //查找孩子的孩子
            for(int i = 0; i< jsonObjects.size();i++){
                jsonObject = jsonObjects.get(i);
                getChild(jsonObject,jsonMap,jsonObject.getInteger("id"));
            }
        }
    }
}
