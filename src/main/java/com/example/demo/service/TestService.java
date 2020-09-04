package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

public class TestService {

    public TestService() {
    }

    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        Assert.notEmpty(list1, "List 1 cannot be empty.");
        Assert.notEmpty(list2, "List 2 cannot be empty.");

        List<Integer> mergedList = new ArrayList<>();

        int maxSizeList = list1.size() > list2.size() ? list1.size() : list2.size();

        for (int i = 0; i < maxSizeList ; i++) {
            if(i < list1.size() ){
                mergedList.add( list1.get(i));
            }
            if(i < list2.size()){
                mergedList.add( list2.get(i));
            }
        }
        return mergedList;
    }

}
