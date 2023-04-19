package Graph;

public class Vertex {
    private String label;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public String getLabel() {
        return label;
    }

}
