package array;

import lombok.var;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifference {
    /**
     * hash表找两个数组不用的数字
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set1.remove(n);
            set2.add(n);
        }
        for (int n : nums1) {
            set2.remove(n);
        }
        //after: set1=[1,3], set2=[4,6]
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>(set1));
        resultList.add(new ArrayList<>(set2));
        return resultList;
    }
    }
