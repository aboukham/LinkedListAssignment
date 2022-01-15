package lab4;

public class DoublyLinkedList<E> {
    public static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E n, Node<E> next, Node<E> prev) {
            this.value = n;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int     size = 0;
    //var->head-->node1->node2->node3
    //   var
    public void addFirst(E item){
        Node var = new Node<E>(item, this.head, null);
        if (head == null)
            tail = var;
        else
            head.prev = var;
        head = var;
        size++;
    }

    public void addAfter(Node<E> node, E item){
        if (head == null || node == null)
            return;
        Node var1 = new Node<E>(item, node.next, node);
        if (node == tail)
            tail = var1;
        else
            node.next.prev = var1;
        node.next = var1;
        size++;
    }

    private E removeFirst(){
        if (head == null)
            return null;
        E temp = head.value;
        if (head.next == null)
            head = null;
        else {
            head.next.prev = null;
            head = head.next;
        }
        size--;
        return temp;
    }

    private E removeAfter(Node<E> node){
        if (node == null || node.next == null)
            return null;
        E temp = node.next.value;
        if (node.next.next == null)
            tail = node;
        else
            node.next.next.prev = node;
        node.next = node.next.next;
        size--;
        return temp;
    }

    private Node<E> getNode(int index){
        if (index < 0 || index >= size)
            return null;
        Node current = head;
        int i = 0;
        while (current != null){
            if (i == index)
                break;
            current = current.next;
            i++;
        }
        return current;
    }


    private E get(int index){
        if (getNode(index) == null)
            return null;
        else
            return getNode(index).value;
    }

    public void add(int index, E item){
        if (index < 0 || index > size)
            return ;
        if (index == 0)
            addFirst(item);
        Node current = head;
        int i = 0;
        while (current != null){
            if (i == index - 1)
                break;
            current = current.next;
            i++;
        }
        addAfter(current, item);
    }

    public boolean addLast(E item){
       if (tail != null) {
           addAfter(tail, item);
           return true;
       }else
            return false;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            return null;
        if (index == 0)
            return removeFirst();
        Node<E> current = head;
        int i = 0;
        while (current != null){
            if (i == index - 1)
                break ;
            current = current.next;
            i++;
        }
        return removeAfter(current);
    }

    public int size(){
        return size;
    }

    public String toString(){
        Node node = head;
        String str = "";
        for (int i = 0; i < size - 1; i++){
            str += node.value + " -> ";
            node = node.next;
        }
        str += node.value;
        return str;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList<Integer>();
        list.addFirst(23);
        list.addFirst(42);
        list.addFirst(5);
        list.addFirst(-12);
        list.addAfter(list.tail, 90);

        System.out.println("---------------------------list of integers---------------------------------------------");
        System.out.println(list);

        System.out.println(list.removeAfter(list.tail.prev));
        System.out.println("----------------------list of integers after removing the last one ---------------------");
        System.out.println(list);


        list.add(0, 70);
        System.out.println("----------------------list of integers after adding 70 at index 0-----------------------");
        System.out.println(list);

        list.addLast(119);
        System.out.println("----------------------list of integers after adding 119 at the end----------------------");
        System.out.println(list);
        System.out.println("------------------------------------The size of list------------------------------------");
        System.out.println(list.size);

        System.out.println(list.remove(2));
        System.out.println("----------------------list of integers after removing element at index 2----------------");
        System.out.println(list);

        System.out.println("------------------------------------The size of list------------------------------------");
        System.out.println(list.size);
    }

}
