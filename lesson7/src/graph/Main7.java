package graph;

public class Main7 {

    public static void main(String[] args) {
        testBfs();
    }

    private static void testBfs() {
        //Из Москвы в Воронеж
        //Должно получиться Мск-Тула-Липецк-Воронеж
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Липецк", "Москва");
        graph.addEdges("Липецк", "Тула", "Воронеж");
        graph.addEdges("Рязань", "Тамбов", "Москва");
        graph.addEdges("Тамбов", "Рязань", "Саратов");
        graph.addEdges("Саратов", "Тамбов", "Воронеж");
        graph.addEdges("Калуга", "Орел", "Москва");
        graph.addEdges("Орел", "Калуга", "Курск");
        graph.addEdges("Курск", "Орел", "Воронеж");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");

        graph.bfs("Москва", "Воронеж");

        graph.display();
    }

}
