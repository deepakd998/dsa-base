package learn.dsa;

import java.util.Arrays;

public class GraphMatrix {
    int V;
    int E;
    int [] [] graph;

    public GraphMatrix(int node) {
        this.V=node;
        this.graph = new int [node] [node];
    }
    public void add(int i,int j){
        this.graph[i][j]=1;
        this.graph[j][i]=1;
        E++;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(V+" vertices, "+E+" Edges"+"\n");
        for(int v=0;v<V;v++){
            sb.append(v+" :");
            for(int w:graph[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GraphMatrix graph= new GraphMatrix(4);
        graph.add(0,1);
        graph.add(1,2);
        graph.add(2,3);
        graph.add(3,0);
        System.out.println(graph);
    }
}
