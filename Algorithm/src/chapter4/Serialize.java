package chapter4;

import java.util.ArrayList;

public class Serialize {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size();i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        //指示当前节点
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals.equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                //添加当前节点的左右儿子
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                // 记得向arr中添加结点，好通过arr.get(index)访问并修改左右子结点
                queue.add(node);
            }
            //如果为右儿子，则进入下一个node
            if (!isLeftChild) {
                index++;
            }
            //检测完左儿子，检测右儿子，依次交替
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
