package training.dataStructureAlgorithm;

import training.dataStructureAlgorithm.operationOfTree.BinarySearchTree;

public class m_OperationOfBinarySearchTree {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();

        // 插入节点
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order Traversal (Sorted Order):");
        bst.inOrder();

        System.out.println("Pre-order Traversal:");
        bst.preOrder();

        System.out.println("Post-order Traversal:");
        bst.postOrder();

        System.out.println("\nSearch for 40: " + bst.search(40));
        System.out.println("Search for 90: " + bst.search(90));

        System.out.println("\nDelete 20:");
        bst.delete(20);
        bst.inOrder();

        System.out.println("\nDelete 30:");
        bst.delete(30);
        bst.inOrder();

        System.out.println("\nDelete 50:");
        bst.delete(50);
        bst.inOrder();
    }
}
