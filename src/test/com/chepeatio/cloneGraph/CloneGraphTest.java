package test.com.chepeatio.cloneGraph;

import com.chepeatio.cloneGraph.CloneGraph;
import com.chepeatio.cloneGraph.UndirectedGraphNode;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/** 
* CloneGraph Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 27, 2015</pre> 
* @version 1.0 
*/ 
public class CloneGraphTest { 
    CloneGraph test = new CloneGraph();
    UndirectedGraphNode node0 = new UndirectedGraphNode(0);
    UndirectedGraphNode node1 = new UndirectedGraphNode(1);
    UndirectedGraphNode node2 = new UndirectedGraphNode(2);

    @Before
    public void before() throws Exception {
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);
    }

    /**
    *
    * Method: cloneGraph(UndirectedGraphNode node)
    *
    */
    @Test
    public void testCloneGraph() throws Exception {
        UndirectedGraphNode result = test.cloneGraph(node0);
        assertEquals(true, equalsGraph(result, node0));
    }

    private boolean equalsGraph(UndirectedGraphNode n1, UndirectedGraphNode n2) {
//        boolean eq = true;
//        eq = eq && (n1.label == n2.label);
        // Lack the solution to judge whether two graphs equals.
//        return eq;
        return n1.label == n2.label;
    }
}
