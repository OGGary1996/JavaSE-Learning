package training.dataStructureAlgorithm.operationOfTree;

// 通过Linked List实现Binary Search Tree

public class BinarySearchTree {
    // initialize
        // create inner class Node, which has left and right child
   private class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
        // create root node
    Node root;


    // insert implementation
         /* insert a new node
          * 每次insert都将新的node作为一个root node。
         */
    public void insert(int data){
        root = insertRec(root, data);
        System.out.println("Insert " + data + " successfully!");
    }
        // recursive insert to find the right position
    private Node insertRec(Node root, int data){
        if (root == null){
            return new Node(data);
        }
        if (data < root.data){
            // 将左子树作为当前root节点，继续与左子树中的下层比较
            // 直到其中一个root.left = null,在这个null的地方创建一个node，并返回这个node。
            root.left = insertRec(root.left,data);
        }else if (data > root.data){
            // 将右子树作为当前root节点，继续与右子树中的下层比较
            // 直到其中一个root.right = null,在这个null的地方创建一个node，并返回这个node。
            root.right = insertRec(root.right,data);
        }
        // 回溯到最上层，返回root
        return root;
    }


    // search implementation
        // search a node
    public boolean search(int data){
        return searchRec(root, data); // 从root开始搜索
    }
        // recursive search to find the right node
    private boolean searchRec(Node root, int data){
        if (root == null){ // 如果root为空，说明没有找到
            System.out.println("The node is not found!");
            return false;
        }
        if (root.data == data){ // 如果root的data等于要找的data，说明找到了
            System.out.println("The node is found!");
            return true;
        }
        if (data < root.data){
            // 如果要找的data小于root的data，说明要找的node在左子树中
            return searchRec(root.left, data);
        }else{
            // 如果要找的data大于root的data，说明要找的node在右子树中
            return searchRec(root.right, data);
        }
    }


    // delete implementation
        // delete a node
    public void delete(int value) {
        root = deleteRec(root, value);
    }
        // 递归实现删除
    private Node deleteRec(Node root, int data) {
        if (root == null) return root; // 空树，直接返回

        if (data < root.data) { // 在左子树中删除
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) { // 在右子树中删除
            root.right = deleteRec(root.right, data);
        } else { // 找到要删除的节点
            // 情况 1：无子节点或只有一个子节点
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 情况 2：有两个子节点
            root.data = findMin(root.right); // 用右子树的最小值替代
            root.right = deleteRec(root.right, root.data); // 删除替代节点
        }
        return root;
    }
        // 查找最小值（用于删除操作）
    private int findMin(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            root = root.left;
            minValue = root.data;
        }
        return minValue;
    }


    // 前序遍历
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }
    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // 中序遍历
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // 后序遍历
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }
    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

}

