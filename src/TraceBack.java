import java.util.LinkedList;
import java.util.List;

public class TraceBack {

    //求全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new LinkedList<>();
        dfs_permute(nums,new LinkedList<>(),ans);
        return ans;

    }

    public void dfs_permute(int[] nums,List<Integer>temp,List<List<Integer>>ans){
        if(temp.size()==nums.length){
            ans.add(new LinkedList<>(temp));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                dfs_permute(nums,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }

    //求解子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new LinkedList<>();
        dfs_subsets(nums,ans,0,new LinkedList<>());
        return ans;
    }

    public void dfs_subsets(int[]nums,List<List<Integer>>ans,int layer,List<Integer>temp){
        if(layer==nums.length){
            ans.add(new LinkedList<>(temp));
            return ;
        }
        //两个分叉，选或者不选
        for(int i=0;i<2;i++){
            if(i==0){
                temp.add(nums[layer]);
                dfs_subsets(nums, ans, layer + 1, temp);
                temp.remove(temp.size() - 1);
            }
            else{
                dfs_subsets(nums, ans, layer + 1, temp);
            }
        }
    }

    //单词搜索
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs_exist(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs_exist(char[][] board,String word,int layer,int i,int j){
        if(layer==word.length()){
            return true;
        }
        //越界处理
        if(i<0||i>=board.length||j<0||j>=board[0].length){
            return false;
        }
        if(word.charAt(layer)!=board[i][j]){
            return false;
        }
        else {
            char ch=board[i][j];
            board[i][j]='@';
            boolean ans = dfs_exist(board, word, layer + 1, i + 1, j) || dfs_exist(board, word, layer + 1, i - 1, j)
                    || dfs_exist(board, word, layer + 1, i, j + 1) || dfs_exist(board, word, layer + 1, i, j - 1);
            board[i][j]=ch;
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[]nums={1,2,3};
//        List<List<Integer>>ans=new LinkedList<>();
//        ans=new TraceBack().subsets(nums);
//
//        System.out.println("lili");
    }
}
