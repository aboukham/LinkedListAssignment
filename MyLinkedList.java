package lab4;

public class MyLinkedList {
    public static class Node<Integer>{
        private int value;
        private Node<Integer> next;

        public Node(int n, Node<Integer> next) {
            this.value = n;
            this.next = next;
        }
    }

    private Node<Integer> head = null;
    private int     size = 0;
    public void add(int item){
        Node node = new Node<Integer>(item, head);
        head = node;
        size++;
    }

    public int size(){
        return size;
    }

    public boolean find(int item){
        Node var = head;
        for (int i = 0; i < size && var != null; i++){
            if (var.value == item)
                return true;
            var = var.next;
        }
        return false;
    }

    public int max(){
        int max = head.value;
        Node node = head;
        for (int i = 0; i < size && node != null; i++){
            if (max < node.value)
                max = node.value;
            node = node.next;
        }
        return max;
    }

    public int min(){
        int min = head.value;
        Node node = head;
        for (int i = 0; i < size && node != null; i++){
            if (min > node.value)
                min = node.value;
            node = node.next;
        }
        return min;
    }

    @Override
    public String toString() {
        String str = "";
        Node node = head;
        for (int i = 0; i < size() - 1 && node != null; i++){
            str += node.value + " -> ";
            node = node.next;
        }
        str += node.value;
        return str;
    }


    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.add(23);
        list.add(42);
        list.add(5);
        list.add(-12);

        System.out.println("---------------------------list of integers---------------------------------------------");
        System.out.println(list);

        System.out.println("--------------------------- size of list-----------------------------------------------");
        System.out.println(list.size());

        System.out.println("--------------------------- Find number in list ---------------------------------------");
        System.out.println(list.find(23));
        System.out.println(list.find(1));

        System.out.println("------------------ the maximum number in the list----------------------------------------");
        System.out.println(list.max());

        System.out.println("------------------ the minimum number in the list----------------------------------------");
        System.out.println(list.min());
    }

}
