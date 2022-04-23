package com.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    //javaBean和json
    @Test
    public void test1()
    {
        Person person = new Person(1,"kirito");
        Gson gson = new Gson();
        //toJson可以把javabean转换为json字符串
        String json = gson.toJson(person);
        System.out.println(json);

        Person person1 = gson.fromJson(json, Person.class);
        System.out.println(person1);
    }


    //list和json
    @Test
    public void test2()
    {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"kirito"));
        personList.add(new Person(2,"kabuda"));
        Gson gson = new Gson();
        String json = gson.toJson(personList);
        System.out.println(json);

        List<Person> list= gson.fromJson(json,new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }



    //map和json
    @Test
    public void test3()
    {
        Map<Integer,Person> personMap= new HashMap<>();
        personMap.put(1,new Person(1,"person"));
        personMap.put(2,new Person(2,"hirro"));
        Gson gson = new Gson();
        String json = gson.toJson(personMap);
        System.out.println(json);

        /*Map<Integer,Person> map = gson.fromJson(json, new PersonMapType().getType());*/
        Map<Integer,Person> map = gson.fromJson(json, new TypeToken<HashMap<Integer,Person>>(){}.getType());//匿名内部类
        System.out.println(map);
        Person person = map.get(1);
        System.out.println(person);
    }
}
