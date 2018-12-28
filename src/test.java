import math.IsPalindrome;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 罗马数字转数字
 */
public class test {
    public static void main(String[] args){
        String s = "MCMXCIV";
        int a = 0;
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("A",4);//IV
        map.put("B",9);//IX
        map.put("E",40);//XL
        map.put("F",90);//XC
        map.put("G",400);//CD
        map.put("H",900);//CM
        List<Integer> list = new ArrayList<>();
        if(s==null){ }
        s = s.replaceAll("IV","A")
                .replaceAll("IX","B")
                    .replaceAll("XL","E")
                        .replaceAll("XC","F")
                            .replaceAll("CD","G")
                                .replaceAll("CM","H");
        for(int i=0;i<s.length();i++){
            list.add(map.get(s.substring(i,i+1)));
        }
        for(int j=0;j<list.size();j++){
            int b = list.get(j);
            a+=b;
        }
        System.out.println(a);
    }
}
