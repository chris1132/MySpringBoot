package com.chovy.boot1;

/**
 * Created by wangchaohui on 2017/9/14.
 */
public class Solution {

        public static int[] twoSum(int[] nums, int target) {
            for(int i=0;i<nums.length;i++){
                for(int j=i;j<nums.length;j++){
                    if(nums[i]+nums[j]==target){
                        return new int[]{i,j};
                    }
                }
            }
            return new int[]{1,2};
        }

    public static void main(String[] args){
        int[] arg = {2,7,11,15};
        int[] a=twoSum(arg,1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
