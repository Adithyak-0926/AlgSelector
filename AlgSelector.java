package DataStructures;

import java.util.List;

public class AlgSelector {
    int[][] adjacencyMatrix;
    static int starness;
    static float cliqueness;
    static int chainness;
    static int cycleness;
    public AlgSelector(int[][] mat){
        this.adjacencyMatrix = mat;
    }

    public void SelectAlgorithm() {

        Star star = new Star(adjacencyMatrix);
        starness = star.getStarCount();

        Cliques cliques = new Cliques(adjacencyMatrix.length, adjacencyMatrix);
        cliqueness = cliques.getCliqueCount();

        ChainAndCycle chainAndCycle = new ChainAndCycle();
        List<Integer> chainnessAndCycleness =  chainAndCycle.getChainAndCycleCount(adjacencyMatrix);
        chainness = chainnessAndCycleness.get(0);
        cycleness = chainnessAndCycleness.get(1);

        int scoreOfChainCycle = chainness + cycleness;
        float scoreOfStarClique = cliqueness + starness;

        System.out.println("starness is " + starness);
        System.out.println("cliqueness is " + cliqueness);
        System.out.println("chainness is " + chainness);
        System.out.println("cycleness is " + cycleness);

        System.out.println("Score of chain/cycle is " + scoreOfChainCycle);
        System.out.println("Score of star/clique is " + scoreOfStarClique);

        if(scoreOfStarClique > scoreOfChainCycle){
            System.out.println("Select new algorithm A*+hsum");
        }
        else {
            System.out.println("Select traditional algorithm DPcpp");
        }
    }

}
