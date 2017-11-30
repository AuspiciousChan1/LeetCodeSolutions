package MyTypes.Graphs;

import java.util.Collection;
import java.util.Set;

public interface Graph {
    Set<String> getIdSet();
    void destroyGraph(Graph graph);
    String locateVex();
    Object getVex();

}
