package Flipkart;

interface MountainArray {
    public int get(int index);
    public int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
         int peak = peakIndexInMountainArray(arr);
         int firstTry = orderAgnosticBS(arr, target, 0, peak);
         if (firstTry != -1) {
             return firstTry;
         }
         return orderAgnosticBS(arr, target, peak+1, arr.length() - 1);
     }
 
     public int peakIndexInMountainArray(MountainArray arr) {
         int start = 0;
         int end = arr.length() - 1;
 
         while (start < end) {
             int mid = start + (end - start) / 2;
             if (arr.get(mid) > arr.get(mid+1)) {
                 end = mid;
             } else {
                 start = mid + 1;
             }
         }
         return start;
     }
 
     static int orderAgnosticBS(MountainArray arr, int target, int start, int end) {
         boolean isAsc = arr.get(start) < arr.get(end);
 
         while(start <= end) {
             int mid = start + (end - start) / 2;
 
             if (arr.get(mid) == target) {
                 return mid;
             }
 
             if (isAsc) {
                 if (target < arr.get(mid)) {
                     end = mid - 1;
                 } else {
                     start = mid + 1;
                 }
             } else {
                 if (target > arr.get(mid)) {
                     end = mid - 1;
                 } else {
                     start = mid + 1;
                 }
             }
         }
         return -1;
     }
 }