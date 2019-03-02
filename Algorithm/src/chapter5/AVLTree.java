package chapter5;

//定义节点
class AvlNode{
    int data;
    AvlNode left; //左孩子
    AvlNode right; //右孩子
    int height; //记录节点的高度

    public AvlNode(int data) {
        this(data, null,null);
    }

    public AvlNode(int data, AvlNode left, AvlNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

//在这里定义各种操作
public class AVLTree{
    private AvlNode root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(data, root);
    }

    public void remove(int data) {
        remove(data, root);
    }

    public void printTree() {
        printTree(root);
    }

    public void printTree(AvlNode T) {
        if (T == null) {
            return;
        }
        System.out.print(T.data + " ");
        printTree(T.left);
        printTree(T.right);
    }

    //计算节点的高度
    public int height() {
        return height(root);
    }

    public int height(AvlNode T) {
        if(T == null) {
            return -1;
        } else{
            return T.height;
        }
    }

    //左左型，右旋操作
    public AvlNode rightRotate(AvlNode T) {
        AvlNode newNode = T.left;
        T.left = newNode.right;
        newNode.right = T;
        //重新计算节点的高度
        T.height = Math.max(height(T.left), height(T.right)) + 1;
        newNode.height = Math.max(height(newNode.left), height(newNode.right)) + 1;
        return newNode;
    }

    //进行左旋
    public AvlNode leftRotate(AvlNode T) {
        AvlNode newNode = T.right;
        T.right = newNode.left;
        newNode.left = T;
        //重新计算高度
        T.height = Math.max(height(T.left), height(T.right)) + 1;
        newNode.height = Math.max(height(newNode.left), height(newNode.right)) + 1;
        return newNode;
    }

    //左-右型，进行左旋，再右旋
    public AvlNode leftRightRotate(AvlNode T) {
        //先对其孩子进行左旋
        T.left = leftRotate(T.left);
        //再进行右旋
        return rightRotate(T);
    }

    //右-左型，先进行右旋，再左旋
    public AvlNode rightLeftRotate(AvlNode T) {
        //先对孩子进行右旋
        T.right = rightRotate(T.right);
        //在左旋
        return leftRotate(T);
    }

    //插入数值操作
    public AvlNode insert(int data, AvlNode T) {
        if(T == null) {
            return new AvlNode(data);
        }
        //先比较 是插左边还是插右边
        if (data < T.data) {
            //向左孩子递归插入
            T.left = insert(data, T.left);
            //插入之后要判断是否打破了平衡，因为插入的是左子树，只有左子树才会打破平衡，用左子树的高减去右子树的高
            //如果左孩子的高度比右孩子大2，说明平衡被打破了,需要进行调整。
            if(height(T.left) - height(T.right) == 2) {
                //如果x小于t的左子树的值，那么x会被插到t的左子树的左子树上，符合LL 用右旋转调整。
                if(data < T.left.data) {
                    T = rightRotate(T);
                } else{
                    //如果x大于t的左子树的值，则会被插到t的左子树的右子树上，符合LR，用先左旋转后右旋转来矫正。
                    T = leftRightRotate(T);
                }
            }
        } else if (data > T.data) {
            //向右孩子递归插入
            T.right = insert(data, T.right);
            //右孩子比左孩子高度大2
            if(height(T.right) - height(T.left) == 2)
                //右-右型
                if(data > T.right.data) {
                    T = leftRotate(T);
                } else{
                    T = rightLeftRotate(T);
                }
        }
        //否则，这个节点已经在书上存在了，我们什么也不做
        //重新计算T的高度
        T.height = Math.max(height(T.left), height(T.right)) + 1;
        return T;
    }

    public AvlNode remove(int data, AvlNode T) {
        if (T == null) {
            return null;
        }
        if (data < T.data) {
            T.left = remove(data, T.left);
            //完了之后验证该子树是否平衡
            if (T.right != null) { //若右子树为空，则一定是平衡的，此时左子树相当对父节点深度最多为1, 所以只考虑右子树非空情况
                if (T.left == null) { //若左子树删除后为空，则需要判断右子树
                    if (height(T.right) - T.height == 2) {
                        AvlNode temp = T.right;
                        if (temp.right != null) { //右子树存在，按正常情况单旋转
                            T = leftRotate(T);
                        } else { //否则是右左情况，双旋转
                            T = rightLeftRotate(T);
                        }
                    }
                } else if (T.left != null) { //否则判断左右子树的高度差
                    //左子树自身也可能不平衡，故先平衡左子树，再考虑整体
                    AvlNode temp = T.left;
                    //删除操作默认用右子树上最小节点补删除的节点
                    //k的左子树高度不低于k的右子树
                    if (temp.right != null) {
                        if (height(temp.left) - height(temp.right) == 2) {
                            AvlNode ltemp = temp.left;
                            if (ltemp.left != null) { //左子树存在，按正常情况单旋转
                                temp = rightRotate(temp);
                            } else { //否则是左右情况，双旋转
                                temp = leftRightRotate(temp);
                            }
                        }
                    } else {
                        if (height(temp.left) - temp.height == 2) {
                            AvlNode ltemp = temp.left;
                            if (ltemp.left != null) { //左子树存在，按正常情况单旋转
                                temp = rightRotate(temp);
                            } else { //否则是左右情况，双旋转
                                temp = leftRightRotate(temp);
                            }
                        }
                    }
                    if (height(T.right) - height(T.left) == 2) {
                        //右子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
                        T = leftRotate(T);
                    }
                }
            }
            // 完了之后更新height值
            T.height = Math.max(height(T.left), height(T.right)) + 1;
        } else if (data > T.data) {
            T.right = remove(data, T.right);
            //下面验证子树是否平衡
            if (T.left != null) { //若左子树为空，则一定是平衡的，此时右子树相当对父节点深度最多为1
                T = balanceChild(T);
            }
            //完了之后更新height值
            T.height = Math.max(height(T.left), height(T.right)) + 1;
        } else if (T.left != null && T.right != null) {
            //默认用其右子树的最小数据代替该节点的数据并递归的删除那个节点
            AvlNode min = T.right;
            while (min.left != null) {
                min = min.left;
            }
            T.data = min.data;
            T.right = remove(T.data, T.right);
            T = balanceChild(T);
            //完了之后更新height值
            T.height = Math.max(height(T.left), height(T.right)) + 1;
        } else {
            T = (T.left != null) ? T.left : T.right;
        }
        return T;
    }

    public AvlNode balanceChild(AvlNode T) {
        if (T.right == null) { //若右子树删除后为空，则只需判断左子树与根的高度差
            if (height(T.left) - height(T.right) == 2) {
                AvlNode temp = T.left;
                if (T.left != null) {
                    T = rightRotate(T);
                } else {
                    T = leftRightRotate(T);
                }
            }
        } else { //若右子树删除后非空，则判断左右子树的高度差
            //右子树自身也可能不平衡，故先平衡右子树，再考虑整体
            AvlNode temp = T.right;
            //删除操作默认用右子树上最小节点（靠左）补删除的节点
            if (temp.left != null) {
                if (height(temp.right) - height(temp.left) == 2) {
                    AvlNode rtemp = temp.right;
                    if (rtemp.right != null) { //右子树存在，按正常情况单旋转
                        temp = leftRotate(temp);
                    } else {
                        temp = rightLeftRotate(temp); //否则是右左情况，双旋转
                    }
                }
            } else {
                if (height(temp.right) - height(temp.left) == 2) {
                    AvlNode rtemp = temp.right;
                    if (rtemp.right != null) { //右子树存在，按正常情况单旋转
                        temp = leftRotate(temp);
                    } else { //否则是右左情况，双旋转
                        temp = rightLeftRotate(temp);
                    }
                }
            }
            //左子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
            if (height(T.left) - height(T.right) == 2) {
                T = rightRotate(T);
            }
        }
        return T;
    }
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 10; i++) {
            avlTree.insert(i);
            System.out.println("插入"+i+"后整颗树的高 " + avlTree.height());
        }
        System.out.println("一般二叉查找树的先序遍历:");
        avlTree.printTree();
    }
}