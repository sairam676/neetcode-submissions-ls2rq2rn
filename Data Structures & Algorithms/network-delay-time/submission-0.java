class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] t:times){
            graph.get(t[0]).add(new int[]{t[1],t[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int time=curr[0];
            int node=curr[1];
            if(time>dist[node])continue;
            for(int[] nei:graph.get(node)){
                int next=nei[0];
                int wt=nei[1];
                if(dist[node]+wt<dist[next]){
                    dist[next]=dist[node]+wt;
                    pq.offer(new int[]{dist[next],next});
                }

            }
        }
        int maxT=0;
        for(int i=1;i<=n;i++){
if(dist[i]==Integer.MAX_VALUE)return -1;
maxT=Math.max(maxT,dist[i]);
        }
return maxT;
    }
}
