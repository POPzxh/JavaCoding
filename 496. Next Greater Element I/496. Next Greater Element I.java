class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ;i < nums2.length ; i++){
            int nextGreater = -1;
            for(int j = i+ 1 ; j<nums2.length ; j++){
                if(nums2[j] > nums2[i]){
                    nextGreater = nums2[j];break;
                }
            }
            map.put(nums2[i] , nextGreater);
        }
        for(int i = 0 ;i<nums1.length ; i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
//使用栈，没遍历一个**nums2[i]**与栈顶元素比较，大于则在map中添加，小于则加入栈。保证栈维持一个递减序列。
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer , Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop() , num);
            }
            stack.push(num);
        }
        for(int i = 0 ; i< nums1.length ;i++){
            nums1[i] = map.getOrDefault(nums1[i] , -1);
        }
        return nums1;
    }
}