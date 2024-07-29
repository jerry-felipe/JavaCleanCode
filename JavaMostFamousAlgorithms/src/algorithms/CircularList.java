package algorithms;

public class CircularList {
    private int currentData;
    private CircularList nextData;

    public CircularList() {
        this.currentData = 0;
        this.nextData = this;
    }

    public CircularList(int value) {
        this.currentData = value;
        this.nextData = this;
    }

    public CircularList insertData(int value) {
        CircularList node = new CircularList(value);
        if (this.nextData == this) {
            node.nextData = this;
            this.nextData = node;
        } else {
            CircularList temp = this.nextData;
            node.nextData = temp;
            this.nextData = node;
        }
        return node;
    }

    public int deleteData() {
        if (this.nextData == this) {
            System.out.println("\nOnly one node...");
            return 0;
        }
        CircularList node = this.nextData;
        this.nextData = this.nextData.nextData;
        node = null;
        return 1;
    }

    public void traverse() {
        traverse(this);
    }

    public void traverse(CircularList node) {
        if (node == null) {
            node = this;
        }
        System.out.println("Forward Direction...");
        CircularList startNode = node;
        do {
            System.out.println(node.currentData);
            node = node.nextData;
        } while (node != startNode);
    }

    public int getNodes() {
        return getNodes(this);
    }

    public int getNodes(CircularList node) {
        if (node == null) {
            node = this;
        }
        int count = 0;
        CircularList startNode = node;
        do {
            count++;
            node = node.nextData;
        } while (node != startNode);
        System.out.println("\nCurrent Node Value : " + node.currentData);
        System.out.println("\nTotal nodes :" + count);
        return count;
    }

    public static void main(String[] args) {
        CircularList node1 = new CircularList(100);
        node1.deleteData();
        CircularList node2 = node1.insertData(200);
        node1.deleteData();
        node2 = node1.insertData(200);
        CircularList node3 = node2.insertData(300);
        CircularList node4 = node3.insertData(400);
        CircularList node5 = node4.insertData(500);
        node1.getNodes();
        node3.getNodes();
        node5.getNodes();
        node1.traverse();
        node5.deleteData();
        node2.traverse();
        node1.getNodes();
        node2.getNodes();
        node5.getNodes();
    }
}
