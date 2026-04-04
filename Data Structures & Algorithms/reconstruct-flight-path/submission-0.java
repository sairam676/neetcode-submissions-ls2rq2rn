class Solution {
    Map<String,PriorityQueue<String>> graph=new HashMap<>();
    List<String> result=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
      for(List<String> t:tickets){
        graph.putIfAbsent(t.get(0),new PriorityQueue<>());
        graph.get(t.get(0)).offer(t.get(1));
      }  
      dfs("JFK");
      return result;
    }
    private void dfs(String src){
        PriorityQueue<String> pq=graph.get(src);
        while(pq!=null&&!pq.isEmpty()){
            String next=pq.poll();
            dfs(next);
        }
        result.add(0,src);
    }
}
