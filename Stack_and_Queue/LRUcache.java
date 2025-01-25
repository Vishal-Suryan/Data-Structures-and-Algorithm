import java.util.HashMap;
import java.util.Map;

public class LRUcache {
    class LRUCache {
    Map<Integer,Node> map=new HashMap<>();
    int capacity;
    Node head =new Node(0,0);
    Node tail =new Node(0,0);
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }   
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return node.val;
        }else{
            return -1;
        }
    } 
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteNode(map.get(key));
        }
        if(map.size()==capacity){
            deleteNode(tail.prev);
        }
        insertAfterHead(new Node(key,value));
    }
    private void deleteNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertAfterHead(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    class Node{
        Node next,prev;
        int val,key;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
}
}
