class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int time=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(visited[r][c])continue;
            visited[r][c]=true;
            if(r==n-1&&c==n-1)return time;
            for(int[] d:dirs){
                int nr=d[0]+r;
                int nc=d[1]+c;
                if(nr>=0&&nc>=0&&nr<n&&nc<n&&!visited[nr][nc]){
                    int newTime=Math.max(time,grid[nr][nc]);
                    pq.add(new int[]{newTime,nr,nc});
                }
            }
        }
        return -1;
    }
}
