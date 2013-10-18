package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Vertex implements Comparable<Vertex> {

    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String argName) {
        name = argName;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

}

class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}

public class DijkstraOther {
    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);

                }

            }
        }
    }

    public static ArrayList<Vertex> getShortestPathTo(Vertex target) {
        ArrayList<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public String[] readFile(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        String line = "";
        while (input.hasNext()) {
            line = line.concat(input.nextLine());
        }
        String[] graph = line.split("");
        return graph;

    }

    public static void main(String[] args) throws FileNotFoundException {

        final String TEST = "/TestInput.txt";
        Scanner input = new Scanner(new File(TEST));
        String line = "";
        while (input.hasNext()) {
            line = line.concat(input.nextLine());
        }
        String[] graph = line.split(" ");

        for (int i = 0; i < graph.length; i++) {
            System.out.println(graph[i]);
        }

        Vertex[] verts = new Vertex[graph.length];
        Edge[] edges = new Edge[graph.length];
        Vertex v1 = new Vertex("");
        Vertex v2 = new Vertex("");
        Vertex source = new Vertex("");
        int count = 0;

        outerloop: for (int i = 0; i < (graph.length); i++) {

            if (graph[i].equals("-1")) {
                // do algorithm initialization here w/ source
            }
            if (i == 0) {
                verts[i] = new Vertex(graph[i]);
                count++;
            } else {
                innerloop: for (int j = count; j >= 0; j--) {
                    if (i / 3 == 0) {

                        if (graph[i].equals(verts[j].toString())) {
                            break innerloop;
                        } else if (j == 0) {
                            verts[count] = new Vertex(graph[i]);
                            v1 = verts[count];
                            count++;
                        }
                    }

                    if (i / 3 == 1) {

                        if (graph[i].equals(verts[j])) {
                            break innerloop;
                        } else if (j == 0) {
                            verts[count] = new Vertex(graph[i]);
                            v2 = verts[count];
                            count++;
                        }
                    }
                    if (i / 3 == 2) {

                    }
                }
            }

        }

        for (int i = 0; i < verts.length; i++) {
            System.out.println(verts[i]);
        }
    }
}