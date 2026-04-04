class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
int m,n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        m=heights.length;
        n=heights[0].length;
        boolean[][] p=new boolean[m][n];
        boolean[][] a=new boolean[m][n];

        for(int i=0;i<n;i++){
          dfs (0,i,p, heights);
            dfs(m-1,i, a, heights);
        }
        for(int i=0;i<m;i++){
            dfs(i, 0, p, heights);
            dfs(i, n - 1, a, heights);
        }
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(p[i][j]&&a[i][j])res.add(Arrays.asList(i,j));
        }
       }
       return res;
    }
    private void dfs(int i,int j,boolean[][] p,int[][] heights){
        p[i][j]=true;
        for(int[] d:dirs){
            int nr=i+d[0];
            int nc=j+d[1];
             if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
             if(p[nr][nc]||heights[nr][nc]<heights[i][j])continue;
             dfs(nr,nc,p,heights);
        }
    }
}


































