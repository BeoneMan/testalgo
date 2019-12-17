package test_06_linkedlist.test01;

/**
 * 哨兵模式
 * 用单链表实现LRU缓存列表
 */
public class LRUBaseLinkedList<T> {
    //链表默认容量
    private static final Integer DEFAULT_CAPACITY = 10;
    //链表容量
    private int capacity;
    //链表长度
    private int length;
    //链表头部
    private Node<T> head;

    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
        this.head = new Node<>();
        this.length = 0;
    }

    public void add(T element) {
        if (head.getNext() == null) {
            head.setNext(new Node(element, null));
            length++;
            return;
        } else {
            Node preNode = findPreNode(element);
            if (preNode == null) {
                if (length >= capacity) {
                    deleteEleAtEnd();
                }
            } else {
                deleteNode(preNode);
            }
            addEleAtHead(element);
        }
    }

    private void addEleAtHead(T element) {
        Node headNext = head.getNext();
        Node newNode = new Node(element, headNext);
        head.setNext(newNode);
        length++;
    }

    private void deleteNode(Node preNode) {
        Node deleteNode = preNode.getNext();
        preNode.setNext(preNode.getNext().getNext());
        deleteNode = null;
        length--;

    }

    private void deleteEleAtEnd() {
        if (head.getNext() == null) return;
        Node p = head;
        while (p.getNext().getNext() != null) {
            p = p.getNext();
        }
        Node endNode = p.getNext();
        endNode = null;
        p.setNext(null);
        length--;
    }

    //查找元素的前一个node结点，如果有则返回
    private Node findPreNode(T element) {
        Node p = head;
        while (p.getNext() != null) {
            if (element.equals(p.getNext().getElement())) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }


    private class Node<T> {
        private T element;
        private Node next;

        public Node() {
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void printAll() {
        Node p = head;
        while (p.getNext() != null) {
            System.out.print(p.getNext().getElement() + "  ");
            p = p.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>(5);
        list.printAll();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.printAll();

        list.add(10);
        list.printAll();
    }
}
