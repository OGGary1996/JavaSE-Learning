package training.tutorialAdvanced.c_collections.a_collection;

import java.util.LinkedList;
import java.util.List;

public class e_LinkedList {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        /*
        1. LinkedList是一个双向链表，底层是一个Node节点的链表结构；
        2. 每个Node节点包含一个数据域和两个指针域，分别指向前一个节点和后一个节点；
        3. LinkedList的插入和删除操作效率较高，因为只需要修改指针域即可；
        底层实现顺序：
        1. 创建一个空的LinkedList对象，此时Node<E> first = null；Node<E> last = null；E item = null；
        2. 调用add方法，此时会将第一个Node<E> last（此时为null）赋值给 Node<E> l
        3. 创建一个Node节点，数据域E item为第一个元素，第一个节点为Node<E> l，根据上一步，此时为null；
        4. 将上一步创造的节点的后节点域指向null；此时这个节点的前后节点域都为null；只包含了数据域；
        5. 将这个节点赋值给LinkedList的尾节点last；
        6.1 此时进行判断，如果刚刚创建的节点的头节点Node<E> l为null，则将这个整个节点赋值给LinkedList的头节点first；
        6.2 如果刚刚创建的节点的头节点Node<E> l 不为null，则将这个整个节点赋值给这个节点的后节点域；
        7. 此时完成了第一个节点的创建；此时的状态为LinkedList的Node<E> first指向了刚才创建的节点，Node<E> last也指向了刚才创建的节点；
        8. 添加第二个节点；此时再次将上一步的Node<E> last赋值给Node<E> l；表示此时将刚才创建的节点作为现在要创建的节点的前节点；
        9. 然后创建一个心的Node节点，数据域E item为第二个元素，前节点域指向上一步的Node<E> l；后节点域指向null；
        10. 将现在新创建节点赋值给LinkedList的尾节点last；
        11.1 此时进行判断，如果现在创建的节点的前阶段是null，则将这个节点赋值给LinkedList的头节点first；
        11.2 如果现在创建的节点的前节点不为null，则将现在创建的结点赋值给上一步创建的节点的后节点；表示现在创建的节点是上一步创建的节点的后节点；

        12. 重复以上步骤，直到所有元素都添加到LinkedList中；
        */
    }
}
