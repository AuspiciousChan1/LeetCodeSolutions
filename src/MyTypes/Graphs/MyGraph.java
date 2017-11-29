package MyTypes.Graphs;

import java.security.spec.MGF1ParameterSpec;
import java.util.*;


public class MyGraph implements Graph{
    class MyGraphNode implements GraphNode{

        private String id;
        private ArrayList<GraphNode> next;

        public MyGraphNode(String id){
            this.id = id;
            next = new ArrayList<>();
        }

        @Override
        public String getID() {
            return this.id;
        }

        @Override
        public Collection<GraphNode> getNextNodes() {
            return this.next;
        }

        @Override
        public boolean addNext(GraphNode graphNode) {
            if(graphNode != null){
                this.next.add(graphNode);
                return true;
            }
            return false;
        }

        @Override
        public boolean addAllNext(Collection<GraphNode> graphNodes) {
            if(graphNodes != null){
                this.next.addAll(graphNodes);
                return true;
            }
            else {
                return false;
            }

        }
    }

    private HashMap<String, GraphNode> nodesMap;

    public MyGraph(){
        this.nodesMap = new HashMap<>();
    }

    @Override
    public Set<String> getIdSet() {
        return this.nodesMap.keySet();
    }

    @Override
    public GraphNode getNode(String id) {
        return this.nodesMap.get(id);
    }

    @Override
    public String addNode(Collection<GraphNode> next, Collection<GraphNode> previous) {
        String id;
        do{
            id = UUID.fromString(System.currentTimeMillis() + Math.random() + "") + "";
        }
        while (this.nodesMap.keySet().contains(id));

        GraphNode newNode = new MyGraphNode(id);
        newNode.addAllNext(next);
        for (GraphNode p : previous) {
            p.addNext(newNode);
        }
        return id;
    }
}
