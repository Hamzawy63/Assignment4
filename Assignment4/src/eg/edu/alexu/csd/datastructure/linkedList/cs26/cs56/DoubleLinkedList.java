package eg.edu.alexu.csd.datastructure.linkedList.cs26.cs56;

public class DoubleLinkedList {

    class doubleLinkedListNode {
        Object value;
        doubleLinkedListNode prev;
        doubleLinkedListNode next;

        doubleLinkedListNode(Object value)
        {
            this.value =value;
            next = null;
            prev=null;

        }
    }
    doubleLinkedListNode head = null;

    public void add(int index, Object element) {
        doubleLinkedListNode tmp = head;
        int i = 0;
        if (!(validIndex(index)) && (index != 0)) {
            System.out.println("Invlaid index");
            return;
        } else if (index == 0) {
            doubleLinkedListNode newElementNode = new doubleLinkedListNode(element);
            newElementNode.next = head;
            newElementNode.prev = null;
            if (head != null)
                head.prev = newElementNode;
            head = newElementNode;
        } else {
            while (tmp != null) {
                if (i == (index - 1)) /*then the next node is the required node to be replaced*/ {
                    doubleLinkedListNode newElementNode = new doubleLinkedListNode(element);
                    newElementNode.next = tmp.next;
                    tmp.next = newElementNode;
                    newElementNode.prev = tmp;
                    if (newElementNode.next != null)
                        newElementNode.next.prev =newElementNode ;
                    break; //mission completed
                }
                i++;
                tmp = tmp.next;
            }
        }

    }

    public void add(Object element) {
        doubleLinkedListNode new_node = new doubleLinkedListNode(element);
        doubleLinkedListNode last = head;

        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        new_node.prev = last;
    }

    public Object get(int index) {
        if (!(validIndex(index))) {
            return null;
        } else {
            doubleLinkedListNode tmp = head;
            for (int i = 0; i <= index; i++, tmp = tmp.next) {
                if (i == index)
                    return tmp.value;
            }
        }
        return null; /// will never be accesed
    }

    public void set(int index, Object element) {
        int i = 0;
        doubleLinkedListNode tmp = head;
        if (!(validIndex(index))) {
            System.out.println("invalid index");
            return;
        } else {
            for (i = 0; i <= index; i++, tmp = tmp.next) {
                if (i == index) {
                    tmp.value = element;
                    return;
                }
            }
        }
    }


    public void clear() {
        head = null;
    }


    public boolean isEmpty() {
        return head == null;
    }


    public void remove(int index) {
        int i = 0;
        doubleLinkedListNode tmp = head;
        if (!(validIndex(index))) {
            System.out.println("invalid index");
            return;
        } else {
            for (i = 0; i <= index; i++, tmp = tmp.next) {
                if (i == (index - 1)) {
                    tmp.next = tmp.next.next;
                    tmp.next.prev=tmp;
                    return;
                }
            }
        }
    }

    public int size() {
        doubleLinkedListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (validIndex(fromIndex) && validIndex(toIndex)) {
            DoubleLinkedList newSubList = new DoubleLinkedList();
            doubleLinkedListNode tmp = head;
            int j = 0;
            for (int i = 0; i < size(); i++, tmp = tmp.next)
                if (i >= fromIndex) {
                    if (i == toIndex)
                        return (ILinkedList) newSubList; /// fucking casting
                    else {
                        newSubList.add(j++, tmp.value);
                    }
                }

        } else {
            return null;
        }
        return null;
    }

    public boolean contains(Object o) {
        doubleLinkedListNode tmp = head;
        while (tmp != null) {
            if (tmp.value == o)
                return true;
            tmp = tmp.next; /// out of if statement
        }
        return false;
    }

    public boolean validIndex(int index) {
        return !((index < 0 || index > size()));
    }

    public void print() {
        doubleLinkedListNode ptr = head;
        if (head == null)
            System.out.println("Empty list");
        while (ptr != null) {
            System.out.print(ptr.value + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
