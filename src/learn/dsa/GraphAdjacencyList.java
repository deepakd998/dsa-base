package learn.dsa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjacencyList {
    private LinkedList<Integer> [] adj;
    private int v;
    public int e;
   public GraphAdjacencyList(int nodes){
     this.v=nodes;
     this.adj=new LinkedList[nodes];
     for(int i=0;i<v;i++){
         adj[i]=new LinkedList<>();
     }
    }
    public void addEdge(int i,int j){
       adj[i].add(j);
       adj[j].add(i);
       e++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(v+" vertices, "+e+" Edges"+"\n");
        for(int k=0;k<v;k++){
            sb.append(k+" :");
            for(int w:adj[k]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public void bfs(int s){
       boolean [] visited= new boolean[v];
        Queue<Integer> q= new LinkedList<>();
        visited[s]=true;
        q.offer(s);
        while (!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for(int w:adj[u]){
                if(!visited[w]){
                    visited[w]=true;
                    q.offer(w);
                }
            }
        }
    }

    public void dfs(int s){
        boolean [] visited= new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()){
           int u= stack.pop();
           if(!visited[u]){
               visited[u]=true;
               System.out.print(u+" ");
               for(int w:adj[u]){
                   if(!visited[w]){
                       stack.push(w);
                   }
               }
           }
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyList graph= new GraphAdjacencyList(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(2,4);
        graph.dfs(0);
    }

}
