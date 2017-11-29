package MyTypes.Graphs;

import java.util.Collection;

interface GraphNode {
    String getID();
    Collection<GraphNode> getNextNodes();
    boolean addNext(GraphNode graphNode);
    boolean addAllNext(Collection<GraphNode> graphNodes);
}
