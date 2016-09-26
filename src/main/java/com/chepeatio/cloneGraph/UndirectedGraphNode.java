package com.chepeatio.cloneGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/10/25.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
