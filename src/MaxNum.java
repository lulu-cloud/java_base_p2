import java.util.Arrays;

public class MaxNum {

    public String largestNumber(int[] nums) {
        StringBuilder sb=new StringBuilder();
        for(int num:nums){
            //对每个数字分解
            int temp=num;
            while(temp!=0){
                sb.append(Integer.toString(temp%10));
                temp/=10;
            }
        }
        char[]chars=sb.toString().toCharArray();
        Arrays.sort(chars);
        return chars.toString();
    }
    public void wiggleSort(int[] nums) {
        if(nums.length==0||nums.length==1)
            return ;
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int[]ans=new int[nums.length];
        int k=0;
        while(i<=j){
            ans[k++]=nums[i++];
            ans[k++]=nums[j--];
        }
        for(i=0;i<nums.length;i++){
            nums[i]=ans[i];
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }

    public boolean isHappy(int n) {
        StringBuilder sb=new StringBuilder();
        int temp=n;
        while(temp!=0){
            sb.append(Integer.toString(temp%10));
            temp/=10;
        }
//        char[]chars=sb.toString().toCharArray();
//        int sum=0;
//        while
        return false;
    }

}
