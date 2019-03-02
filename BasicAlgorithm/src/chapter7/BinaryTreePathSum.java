package chapter7;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {

    public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        find(root, target, result, list);
        return result;
    }

    public static void find(TreeNode root,int target,List<List<Integer>> result,List<Integer> array){
        if(null == root){
            return;
        }
        array.add(root.val);
        target-=root.val;
        if(0 == target && null == root.left && null == root.right){
            result.add(new ArrayList<>(array)); //直接赋值是引用赋值，指向相同对象。
            //aarry传的是一个引用，会一直被改变。找到一个可行的答案需要深拷贝一份保存下来。否则你会发现array最后都变成一样的东西了。
            return;
        }

        if(null !=root.left){
            find(root.left,target,result,array);
            array.remove(array.size() -1);
        }
        if(null != root.right){
            find(root.right,target,result,array);
            array.remove(array.size() -1);
        }

    }
}
