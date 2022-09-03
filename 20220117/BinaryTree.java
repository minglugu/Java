import java.util.*;

/**
 * Date: 2022/1/17
 * Time: 9:51
 * Description: binary tree
 */
class TreeNode {
    public char val;
    public TreeNode left;//left child - reference
    public TreeNode right;//right child - reference
    public TreeNode(char val) {
        this.val = val;
    }
}
public class BinaryTree {
    //public BTNode root;//root node of binary tree

    /**
     * 这种方式 是穷举的方式创建的
     * 但是 这样写不行 太low了。
     * @return
     */
    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    /*public static int i = 0 ;
    public static TreeNode createTree(String str) {
        TreeNode root = null;
        if(str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else {
            //遇到# 就是空树
            i++;
        }
        return root;
    }

    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            TreeNode root = createTree(str);
            inorder(root);
        }
    }*/
    // 前序遍历
    void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //shift+f6->回车才会生效

    public List<Character> preorderTraversal(TreeNode root) {
        List<Character> retlist = new ArrayList<>();
        if(root == null) {
            return retlist;
        }
        retlist.add(root.val);
        List<Character> leftTree = preorderTraversal(root.left);
        retlist.addAll(leftTree);

        List<Character> rightTree =preorderTraversal(root.right);
        retlist.addAll(rightTree);

        return retlist;
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retlist = new ArrayList<>();
        if(root == null) {
            return retlist;
        }
        List<Integer> leftTree = inorderTraversal(root.left);
        retlist.addAll(leftTree);

        retlist.add(root.val);


        List<Integer> rightTree =inorderTraversal(root.right);
        retlist.addAll(rightTree);

        return retlist;
    }*/

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> retlist = new ArrayList<>();
        if(root == null) {
            return retlist;
        }
        List<Integer> leftTree = postorderTraversal(root.left);
        retlist.addAll(leftTree);
        List<Integer> rightTree =postorderTraversal(root.right);
        retlist.addAll(rightTree);
        retlist.add(root.val);
        return retlist;
    }*/

    /**
     *获取树中节点的个数
     */
    int count = 0;
    int size1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        count++;
        size1(root.left);
        size1(root.right);
        return count;
    }

    /**
     * 子问题思路
     * @param root
     * @return
     */
    int size(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    /**
     * 获取叶子节点的个数
     * 遍历思路：
      */
    static int leafCount = 0;
    void getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leafCount ++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    /**
     * 获取叶子节点的个数
     * 子问题思路
     * @param root
     * @return
     */
    int getLeafNodeCount2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            //当前的root是叶子节点
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    /**
     * 获取第K层节点的个数
     * 子问题思路：
     *
     */
    int getKLevelNodeCount(TreeNode root,int k) {
        if(root == null || k <= 0) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1) + getKLevelNodeCount(root.right,k-1);
    }

    /**
     * 获取二叉树的高度
     * 时间复杂度：O(n)
     * 空间复杂度：O()
     */
    int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }

    int getHeight2(TreeNode root) {
        if(root == null) return 0;
        return getHeight2(root.left) > getHeight2(root.right) ?
                getHeight2(root.left)+1 : getHeight2(root.right)+1;
    }

    /**
     * 检测值为value的元素是否存在
     */
    TreeNode find(TreeNode root, char val) {
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode ret = find(root.left,val);
        if(ret != null) {
            return ret;
        }
        ret = find(root.right,val);
        if(ret != null) {
            return ret;
        }
        return null;
    }

    /**
     * 是不是完全二叉树
     * @param root
     * @return
     */
    boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }

        while (!queue.isEmpty()) {
            TreeNode top = queue.peek();
            if(top != null) {
                return false;
            }
            queue.poll();
        }
        return true;
    }

    /**
     * 时间复杂度：O(min(M,N))
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        //p != null && q!= null && p.val == q.val
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    /**
     * 时间复杂度：O(m * n)
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if(root == null || subRoot == null) {
             return false;
         }
//        if(root == null && subRoot != null) {
//            return false;
//        }
//        if(root != null && subRoot == null) {
//            return false;
//        }
//        if(root == null && subRoot == null) {
//            return true;
//        }
        /*if(root.val != subRoot.val) {
            return false;  不能再这里出现。
        }*/
        //根节点和subroot是不是两颗相同的树
        if(isSameTree(root,subRoot)) {
            return true;
        }
        //subRoot是不是root的左子树
        if(isSubtree(root.left,subRoot)) {
            return true;
        }
        if(isSubtree(root.right,subRoot)) {
            return true;
        }
        return false;
    }


    //时间复杂度：O(n);
    public int height (TreeNode root) {
        if(root == null) {return 0;}
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return (leftHeight > rightHeight) ?
                (leftHeight+1) :(rightHeight+1);
    }

    /**
     时间复杂度：O(N^2)
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //时间复杂度：O(n);
    public int height2 (TreeNode root) {
        if(root == null) {return 0;}
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);

        if(leftHeight >= 0 &&  rightHeight >= 0 && Math.abs(leftHeight-rightHeight) <= 1) {
            return Math.max(leftHeight,rightHeight) + 1;
        }else{
            //说明不平衡
            return -1;
        }
    }

    /**
     时间复杂度：O(N)
     */
    public boolean isBalanced2(TreeNode root) {
        if(root == null) return true;
        return height2(root) >= 0;
    }


    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree != null) return false;
        if(leftTree != null && rightTree == null) return false;

        if(leftTree == null && rightTree == null) return true;

        if(leftTree.val != rightTree.val) return false;

        return isSymmetricChild(leftTree.left,rightTree.right) &&
                isSymmetricChild(leftTree.right,rightTree.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }

    /**
     * 层序遍历
     * @param root
     */
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();//这个值代表 当前层有多少个节点
            List<Integer> list = new ArrayList<>();
            while (size != 0) {
                TreeNode cur = queue.poll();
                //list.add(cur.val); 你在OJ写的时候  需要放开这个注释
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;//1 0
            }
            ret.add(list);
        }
        return ret;
    }

    /**
     * 最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }

        TreeNode leftT = lowestCommonAncestor(root.left,p,q);
        TreeNode rightT = lowestCommonAncestor(root.right,p,q);

        if(leftT != null && rightT != null) {
            return root;
        }else if(leftT != null) {
            return leftT;
        }else {
            return rightT;
        }
    }


    //root：根节点      node：指定的节点      stack：存放从根节点到指定节点的路径
    public boolean getPath(TreeNode root,TreeNode node,Stack<TreeNode> stack) {
        if(root == null || node == null) return false;
        stack.push(root);
        if(root == node) return true;
        boolean flg = getPath(root.left,node,stack);
        if(flg) {
            return true;
        }
        flg = getPath(root.right,node,stack);
        if(flg) {
            return true;
        }
        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        Stack<TreeNode> stack1 = new Stack<>();
        getPath(root,p,stack1);
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root,q,stack2);

        int size1 = stack1.size();
        int size2 = stack2.size();
        if(size1 > size2) {
            int size = size1-size2;
            while( size != 0) {
                //出第一个栈里面的元素
                stack1.pop();
                size--;
            }
            while(!stack1.isEmpty() && !stack2.isEmpty()) {
                //判断地址
                if(stack1.peek() == stack2.peek()) {
                    return stack1.pop();
                }else{
                    stack1.pop();
                    stack2.pop();
                }
            }
        }else{
            int size = size2-size1;
            while( size != 0) {
                //出第一个栈里面的元素
                stack2.pop();
                size--;
            }
            while(!stack1.isEmpty() && !stack2.isEmpty()) {
                //判断地址
                if(stack1.peek() == stack2.peek()) {
                    return stack1.pop();
                }else{
                    stack1.pop();
                    stack2.pop();
                }
            }
        }
        return null;
    }

    /**
     * 二叉搜索树 转换为排序的双向链表
     */

    TreeNode prev = null;

    public void inorder(TreeNode pCur) {
        if(pCur == null) return;
        inorder(pCur.left);

        //打印
        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        //System.out.print(pCur.val+" ");
        inorder(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null) return null;

        inorder(pRootOfTree);

        TreeNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

    /*public int preIndex = 0;

    public TreeNode createTreeByPandI(int[] preorder, int[] inorder,int inbegin,int inend) {

        if(inbegin > inend) {
            //如果满足这个条件  说明 没有左树 或者 右树了
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找到根在中序遍历的位置
        int rootIndex = findIndexOfI(inorder,inbegin,inend,preorder[preIndex]);
        if(rootIndex == -1) {
            return null;
        }
        preIndex++;
        //分别创建 左子树 和 右子树
        root.left = createTreeByPandI(preorder,inorder,inbegin,rootIndex-1);
        root.right = createTreeByPandI(preorder,inorder,rootIndex+1,inend);
        return root;
    }

    private int findIndexOfI(int[] inorder,int inbegin,int inend,int key) {

        for(int i = inbegin; i <= inend;i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;

        return createTreeByPandI(preorder,inorder,0,inorder.length-1);
    }*/


    /*public int postIndex = 0;

    public TreeNode createTreeByPandI(int[] inorder, int[] postorder,int inbegin,int inend) {

        if(inbegin > inend) {
            //如果满足这个条件  说明 没有左树 或者 右树了
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        //找到根在中序遍历的位置
        int rootIndex = findIndexOfI(inorder,inbegin,inend,postorder[postIndex]);
        if(rootIndex == -1) {
            return null;
        }
        postIndex--;
        //分别创建右子树 和  左子树
        root.right = createTreeByPandI(inorder,postorder,rootIndex+1,inend);

        root.left = createTreeByPandI(inorder,postorder,inbegin,rootIndex-1);
        return root;
    }

    private int findIndexOfI(int[] inorder,int inbegin,int inend,int key) {

        for(int i = inbegin; i <= inend;i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null) return null;
        postIndex = postorder.length-1;

        return createTreeByPandI(inorder,postorder,0,inorder.length-1);
    }*/

    public void treeToString(TreeNode t,StringBuilder sb) {
        if(t == null) return;
        sb.append(t.val);
        if(t.left != null) {
            sb.append("(");
            treeToString(t.left,sb);
            sb.append(")");
        }else {
            //t.left == null
            if(t.right == null) {
                return;
            }else{
                sb.append("()");
            }
        }

        if(t.right == null) {
            return;
        }else{
            sb.append("(");
            treeToString(t.right,sb);
            sb.append(")");
        }
    }

    public String tree2str(TreeNode root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        treeToString(root,sb);
        return sb.toString();
    }

    /**
     *
     * @param root
     */
    void preOrderNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

    void inOrderNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }
    }

    void postOrderNor(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            //如果当前节点的右子树被打印过 或者 遍历过  直接弹出了
            if (top.right == null || top.right == prev) {
                stack.pop();
                System.out.print(top.val+" ");
                prev = top;//记录一下 最近一次打印的节点
            } else {
                cur = top.right;
            }
        }
    }
}