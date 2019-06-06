package graph;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList = new ArrayList<>();
    private boolean[][] adjMat;
    List<Vertex> visitedVertexList = new ArrayList<>();


    private int size;

    public Graph(int maxVertexCount) {
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * The same as {@link #addEdge(String, String)}
     * @param start
     * @param second
     * @param others
     */
    public void addEdges(String start, String second, String... others) {
        addEdge(start, second);
        for (String another : others) {
            addEdge(start, another);
        }
    }

    public void addEdge(String start, String finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    public void displayTrack() {
        for (int i = 0; i < size; i++) {
            System.out.print(visitedVertexList.get(i));
            System.out.println("-->");
        }
            System.out.println();
        }

    /**
     * англ. breadth-first search, BFS
     * @param startLabel
     */
    public void bfs(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);
        if (startIndex == -1 ) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel );
        }
        if (finishIndex == 1 ) {
            throw new IllegalArgumentException("Invalid finishLabel: " + finishLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();


        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, queue);

        Vertex finishVertex = vertexList.get(finishIndex);

        //Нужно все посещенные вершины записывать в массив
        //(те, которые удаляются из очереди после посещения)
        //не совсем ясно, как вывести путь
        while ( !queue.isEmpty()  ) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null ) {
                visitVertex(vertex, queue);
                if(vertex.getLabel().equals(finishLabel))
                    break;
            } else {
                queue.remove();
            }

        }

        resetVertexState();

    }

    private void resetVertexState() {
        for (int i = 0; i < size; i++) {
            vertexList.get(i).resetState();
        }
    }


    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int vertexIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < size; i++) {
            if (adjMat[vertexIndex][i] && !vertexList.get(i).wasVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

      private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        displayVertex(vertex);
        queue.add(vertex);
        vertex.setVisited();
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

}
