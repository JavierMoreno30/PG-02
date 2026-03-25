package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NqueenProblemTest {
    @Test
    void solveNQueensTest(){
        NqueenProblem nqueenProblem = new NqueenProblem();
        System.out.println("Problema de las N reinas para n=4:");
        System.out.println(nqueenProblem.solveNqueens(4));
        System.out.println("Problema de las N reinas para n=8:");
        System.out.println(nqueenProblem.solveNqueens(8));
    }

}