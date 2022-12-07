import java.util.ArrayList;

public class Node {
    private long value;
    private Node parent;
    private String id;
    private ArrayList<Node> children;

    public Node(long value, Node parent, String id, ArrayList<Node> children) {
        this.value = value;
        this.parent = parent;
        this.id = id;
        this.children = children;
    }

    public void increment(long valToAdd, Node currentNode){
        while(currentNode!=null){
            currentNode.value+=valToAdd;
            currentNode=currentNode.getParent();
        }
    }

    public long getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
    public void addAsSon(Node node){
        this.children.add(node);
    }

    public String getId() {
        return id;
    }
}
