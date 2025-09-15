class Twitter {
    private static int timestamp = 0;
    private class Tweet{
        int id;
        int time;
        Tweet next;
        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    private class User{
        int id;
        Set<Integer> followees;
        Tweet tweetHead;
        User(int id){
            this.id = id;
            followees = new HashSet<>();
            follow(id);
            tweetHead = null;
        }
        void follow(int followeeId){
            followees.add(followeeId);
        }
        void unfollow(int followeeId){
            if(followeeId != this.id){
                followees.remove(followeeId);
            }
        }
        void post(int tweetId){
            Tweet newTweet = new Tweet(tweetId, timestamp++);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }
    private Map<Integer,User> userMap;
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    private User getUser(int userId){
        userMap.putIfAbsent(userId, new User(userId));
        return userMap.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        User u = getUser(userId);
        u.post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        Set<Integer> followees = userMap.get(userId).followees;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for(int f : followees){
            Tweet t = userMap.get(f).tweetHead;
            if(t != null) pq.add(t);
        } 
        int n = 0;
        while(!pq.isEmpty() && n < 10){
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if(t.next != null){
                pq.add(t.next);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        User u = getUser(followerId);
        getUser(followeeId);
        u.follow(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */