class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        // Step 1: put the head of each list into the heap
        for(ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // Step 2: extract min and push next node from that list
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            tail.next = minNode;   
            tail = tail.next;      
            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}
