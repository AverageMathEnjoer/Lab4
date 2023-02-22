package Math;

import interfaces.PathFinder;

import java.util.Objects;

public abstract class Graph<V> {
    protected V[] vertices;
    protected Edge<V>[] edges;
    PathFinder vagabond;
    public static class Edge<V>{
        V start;
        V end;
        public Edge(V start, V end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start +
                    "——>" + end +
                    ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;
            Edge<?> edge = (Edge<?>) o;
            return start.equals(edge.start) && end.equals(edge.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
    public Graph(V[] vertices, Edge<V>[] edges){
        this.vertices = vertices;
        this.edges = edges;
    }
    public void show(){
        for(V v: vertices){
            for(Edge<V> e: edges){
                if(e.start == v){
                    System.out.printf(e.toString() + " ");
                }
            }
            System.out.printf("\n");
        }
    }
    public boolean connected(V start, V end){
        for(Edge<V> e: edges){
            if(e.start == start && e.end == end){
                return true;
            }
        }
        return false;
    }
}
