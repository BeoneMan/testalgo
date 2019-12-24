package test_08_stack.test;

public class StackBaseOnLinkedList {
    private Node top;
    private int size;

    public void push(String value) {
        Node newNode = new Node(value, top);
        top = newNode;
        size++;
    }

    public Node pop() {
        if (top != null) {
            Node ret = top;
            top = top.next;
            size--;
            return ret;
        }
        return null;
    }

    public void clear() {
        top = null;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

    public int getSize() {
        return size;
    }

    public static class Node {
        private Node next;
        private String data;

        public Node() {
        }

        public Node(String data, Node next) {
            this.next = next;
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }


    public static void main(String[] args) {
        StackBaseOnLinkedList list = new StackBaseOnLinkedList();
        list.push("1");
        list.push("2");
        list.push("3");
        list.printAll();
        System.out.println("个数为：" + list.getSize());
        list.pop();
        list.pop();
        list.pop();
        list.printAll();
        System.out.println("个数为：" + list.getSize());
    }
}
