package com.chepeatio.cloneGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Che Peatio on 2015/10/25.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
