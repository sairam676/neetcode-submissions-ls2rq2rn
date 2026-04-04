class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;
        int[] parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        for(int[] e:edges){
            int a =e[0];
            int b=e[1];
            int pu=find(parent,a);
            int pv=find(parent,b);
            if(pu==pv)return new int[]{a,b};
            parent[pu]=pv;
        }
        return new int[0];
            }
            private int find(int[] parent,int x){
                if(parent[x]!=x){
                    parent[x]=find(parent,parent[x]);
                }
                return parent[x];
            }
}
