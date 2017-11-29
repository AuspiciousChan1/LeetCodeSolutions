package MyTypes.Graphs;

import java.util.Collection;
import java.util.Set;

public interface Graph {
    Set<String> getIdSet();
    GraphNode getNode(String id);
    String addNode(Collection<GraphNode> next, Collection<GraphNode> previous);
}
