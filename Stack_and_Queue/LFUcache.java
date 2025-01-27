import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUcache {
    class LFUCache {
    private int capacity, minFrequency;
    private Map<Integer,Node> nodeMap;
    private Map<Integer,LinkedHashSet<Node>> frequencyMap;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFrequency=minFrequency;
        this.nodeMap=new HashMap<>();
        this.frequencyMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node newNode=nodeMap.get(key);
        updateFrequency(newNode);
        return newNode.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(nodeMap.containsKey(key)){
            Node node=nodeMap.get(key);
            node.value=value;
            updateFrequency(node);
        }else{
            if(nodeMap.size()==capacity){
                evictLFU();
            }
            Node newNode=new Node(key,value);
            nodeMap.put(key,newNode);
            addToFrequencyMap(newNode,1);
            minFrequency=1;
        }
    }
    private void updateFrequency(Node node){
        int curr=node.frequency;
        frequencyMap.get(curr).remove(node);
        if(frequencyMap.get(curr).isEmpty() && curr==minFrequency){        
            minFrequency++;
        }
        node.frequency++;
        addToFrequencyMap(node,node.frequency);
    }
    private void evictLFU() {
        LinkedHashSet<Node> minFreqSet = frequencyMap.get(minFrequency);
        Node nodeToEvict = minFreqSet.iterator().next();
        minFreqSet.remove(nodeToEvict);
        if (minFreqSet.isEmpty()) {
            frequencyMap.remove(minFrequency);
        }
        nodeMap.remove(nodeToEvict.key);
    }
    private void addToFrequencyMap(Node node, int frequency) {
        frequencyMap.computeIfAbsent(frequency, k -> new LinkedHashSet<>()).add(node);
    }
    private class Node{
        int key,value,frequency;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.frequency=1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
