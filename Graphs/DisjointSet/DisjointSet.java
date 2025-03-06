package DisjointSet;

import java.util.*;
public class DisjointSet {
    // This class initializes with rank and Parent Array 
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    // The constructor initializes the rank and parent array with 0 and i respectively
    // Rank of All nodes initially will be 0
    // Parent of all nodes initially will be the node itself
    DisjointSet(int n){
        for(int i = 0; i<=n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    // This method finds the ultimate parent while doing path compression //
    public int find(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ultimateParent = find(parent.get(node));
        parent.set(node,ultimateParent);
        return parent.get(node);
    }
    // This method unions two nodes based on their rank 
    public void unionByRank(int x , int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY) return;
        if(rank.get(parentX) < rank.get(parentY)){ // Attaching smaller tree X to Y
            parent.set(parentX,parentY);
        }else if(rank.get(parentY) < rank.get(parentX)){  // Attaching smaller tree Y to X
            parent.set(parentY, parentX);
        }else{
            // This runs when rank of both the parents are same
            // In this case we can attach any tree to any tree
            // After attaching we increase the rank of the parent which is attached
            parent.set(parentY, parentX);
            int rankX = rank.get(parentX);
            rank.set(parentX, rankX + 1);
        }
    }
    // This method unions two nodes based on their size
    public void unionBySize(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX == parentY) return;
        if (size.get(parentX) < size.get(parentY)) { // Attaching smaller tree X to Y
            parent.set(parentX, parentY);
            size.set(parentY, size.get(parentY) + size.get(parentX));
        } else {
            parent.set(parentY, parentX); // Attaching smaller tree Y to X
            size.set(parentX, size.get(parentX) + size.get(parentY));
        }
    }
    // This method checks whether two nodes are connected or not i.e they are in the same component or not
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    // This method counts the number of components 
    public int countComponents(int n){
        int count = 0;
        for(int i = 0; i<n; i++){
            if(parent.get(i) == i){ // if node is a parent of itself then it is a component
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);
        ds.unionByRank(0, 2);
        ds.unionByRank(4, 2);
        ds.unionByRank(3, 1);
        if (ds.find(4) == ds.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
        if (ds.find(1) == ds.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
