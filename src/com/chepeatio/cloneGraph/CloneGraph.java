package com.chepeatio.cloneGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/10/25.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null)
            return null;

        List<UndirectedGraphNode> listUGN = new ArrayList<>();
        UndirectedGraphNode result = utilCloneGraph(node, listUGN);
        return result;
    }

    public UndirectedGraphNode utilCloneGraph(UndirectedGraphNode node, List<UndirectedGraphNode> listNode) {
        UndirectedGraphNode result = null;
        for (UndirectedGraphNode lnode : listNode) {
            if (node.label == lnode.label) {
                result = lnode;
                break;
            }
        }
        if (result == null) {
            result = new UndirectedGraphNode(node.label);
            listNode.add(result);
            int size = node.neighbors.size();
            for (int i=0; i<size; i++) {
                result.neighbors.add(utilCloneGraph(node.neighbors.get(i), listNode));
            }
        }
        return result;
    }
}
