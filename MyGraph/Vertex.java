import java.util.Map;

public class Vertex <V>{
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices; //with weights

    public void addAdjacentVertex(Vertex<V> destination, double weight){
        adjacentVertices.put(destination, weight);
    }

    Vertex(V data){

    }
    Vertex(){

    }





    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<Vertex<V>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }
}