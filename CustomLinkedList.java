public class CustomLinkedList {

    protected Node start;
    protected Node end;
    public int size;

    // No arg Constructor
    public CustomLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    // Method to check if list is empty
    public boolean isEmpty() {
        return start == null;
    }

    // Method to get size of list
    public int getSize() {
        return size;
    }

    // Method to add an element in List
    public void add(int val) {
        Node nptr = new Node(val, null);
        size++;
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            end.setLink(nptr);
            end = nptr;
        }
    }

    // Method to remove an element from tail
    public void removeTailElement() {
        Node s = start;
        Node t = start;
        while (s != end) {
            t = s;
            s = s.getLink();
        }
        end = t;
        end.setLink(null);
        size--;
        return;
    }

    // Remove all elements those are greater than provided element
    public void removeElementsGreaterThanTo(int element) {
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }

        Node ptr = start;
        Node prev = null;

    	// Identify all the head nodes if those are greater than provided value
        while (ptr.getData() > element) {
            start = ptr.getLink();
            ptr = start;
        }

        // Delete occurrences other than head
        while (ptr != null) {
            // Search for the key to be deleted, keep track of the
            // previous node as we need to change Link to next node
            while (ptr != null && ptr.getData() <= element) {
                prev = ptr;
                ptr = ptr.getLink();
            }

            // If key was not present in linked list
            if (ptr == null) return;

            // Unlink the node from linked list
            prev.setLink(ptr.getLink());

            //Update ptr for next iteration of outer loop
            ptr = prev.getLink();
        }
    }

    // Method to show elements
    public void show() {
        System.out.println("Linked List = ");
        if (size == 0) {
            System.out.print("List is empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.println(start.getData());
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.println(ptr.getData());
            ptr = ptr.getLink();
        }
        System.out.println(ptr.getData());
    }

    // Creating an inner class 'Node'
    class Node {
        protected int data;
        protected Node link;

        // No arg. Constructor
        public Node() {
            link = null;
            data = 0;
        }

        // 2 arg Constructor
        public Node(int d, Node n) {
            this.data = d;
            link = n;
        }
        public void setLink(Node node) {
            link = node;
        }
        public void setData(int d) {
            data = d;
        }
        public Node getLink() {
            return link;
        }
        public int getData() {
            return data;
        }
    }
}
