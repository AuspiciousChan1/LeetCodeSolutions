package MyTypes.Graphs;

import utils.Outputs;

import java.util.Collection;

interface GraphNode {

    default String getId(){
        Outputs.outputln("Default method : GraphNode.getId");
        return "Default method : GraphNode.getId";
    }

    default Object getInf(){
        Outputs.outputln("Default method : GraphNode.getInf");
        return "Default method : GraphNode.getInf";
    }

    default boolean setInf(){
        Outputs.outputln("Default method : GraphNode.setInf");
        return true;
    }

    default boolean addNextNode(String nextId){
        Outputs.outputln("Default method : GraphNode.addNextNode");
        return true;
    }

    default boolean addAllNextNodes(Collection<String> nextIds){
        Outputs.outputln("Default method : GraphNode.addAllNextNodes");
        return true;
    }

    default boolean removeNextNode(String nextId){
        Outputs.outputln("Default method : GraphNode.removeNextNode");
        return true;
    }
}
