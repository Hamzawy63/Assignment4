package eg.edu.alexu.csd.datastructure.linkedList.cs26.cs56;

public class singlyLinkedList
{

    class singlyLinkedListNode {
        Object value ;
        singlyLinkedListNode next;

        singlyLinkedListNode(Object value)
        {
            this.value =value;
            next = null;
        }

    }

    singlyLinkedListNode head = null;

    public void add(int index, Object element) {
        singlyLinkedListNode tmp = head;
        int i = 0;
        if (!(validIndex(index)) && (index != 0)) {
            System.out.println("Invlaid index");
            return;
        } else if (index == 0) {
            singlyLinkedListNode newElementNode = new singlyLinkedListNode(element);
            newElementNode.next = head;
            head = newElementNode;
        } else {
            while (tmp != null) {
                if (i == (index - 1)) /*then the next node is the required node to be replaced*/ {
                    singlyLinkedListNode newElementNode = new singlyLinkedListNode(element);
                    newElementNode.next = tmp.next;
                    tmp.next = newElementNode;
                    break; //mission completed
                }
                i++;
                tmp = tmp.next;
            }
        }

    }

    public Object get(int index) {
        if (!(validIndex(index))) {
            return null;
        } else {
            singlyLinkedListNode tmp = head;
            for (int i = 0; i <= index; i++, tmp = tmp.next) {
                if (i == index)
                    return tmp ==null ? null : tmp.value; /// cheek this fuck
            }
        }
        return null; /// will never be accesed
    }

    public void set(int index, Object element) {
        int i = 0;
        singlyLinkedListNode tmp = head;
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

    public void remove(int index) {
        int i = 0;
        singlyLinkedListNode tmp = head;
        if (!(validIndex(index))) {
            System.out.println("invalid index");
            return;
        } else {
            for (i = 0; i <= index; i++, tmp = tmp.next) {
                if (i == (index - 1)) {
                    tmp.next = tmp.next.next;
                    return;
                }

            }

        }
    }

    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (validIndex(fromIndex) && validIndex(toIndex)) {
            singlyLinkedList newSubList = new singlyLinkedList();
            singlyLinkedListNode tmp = head;
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
        singlyLinkedListNode tmp = head;
        while (tmp != null) {
            if (tmp.value == o)
                return true;
            tmp = tmp.next; /// out of if statement
        }
        return false;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public boolean validIndex(int index) {
        return !((index < 0 || index > size()));
    }

    public int size() {
        singlyLinkedListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public void clear() {
        head = null;
    }

    public void add(Object element) {
        if (head == null) {
            head = new singlyLinkedListNode(element);
        } else {
            singlyLinkedListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new singlyLinkedListNode(element);
        }

    }

    public void print() {
        singlyLinkedListNode ptr = head;
        if (head == null)
            System.out.println("Empty list");
        while (ptr != null) {
            System.out.print(ptr.value + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }


}
