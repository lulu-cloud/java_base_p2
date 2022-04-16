import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Tree{
    //中序遍历二叉树
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new LinkedList<>();
        inorderTraversal_tree(ans,root);
        return ans;
    }

    public void inorderTraversal_tree(List<Integer>ans,TreeNode root){
        if(root==null){
            return ;
        }
        inorderTraversal_tree(ans,root.left);
        ans.add(root.val);
        inorderTraversal_tree(ans,root.right);
    }



    //锯齿遍历[层序遍历翻版]
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean dic=false;

        Queue<TreeNode>queue=new LinkedList<>();
        List<List<Integer>>ans=new LinkedList<>();
        if(root==null) return ans;
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer>temp=new LinkedList<>();

            while(size>0) {
                TreeNode q = queue.poll();
                size--;
                if(dic) {
                    temp.add(q.val);
                }
                else {
                    temp.add(0,q.val);
                }
                if(q.left!=null) queue.offer(q.left);
                if(q.right!=null) queue.offer(q.right);
            }

            ans.add(temp);
            dic=!dic;
           }
        return ans;
    }
}


