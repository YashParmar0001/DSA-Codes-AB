package com.company.Recursion.Backtracking;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 0, 1}
        };

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        System.out.println(findPath(maze, visited, 0, 0));
    }

    // Explanation : 01:05:00
    // Time complexity : O[2^(n*m)]
    static boolean findPath(int[][] maze, boolean[][] visited, int i, int j) {

        // Base condition
        if (i >= maze.length || j >= maze[0].length || visited[i][j] || maze[i][j] == 0) {
            return false;
        }

        // If rat has reached the last position
        if (i == maze.length - 1 && j == maze[0].length - 1) {
            return true;
        }

        // Mark the cell as visited
        visited[i][j] = true;

        // Get answer from downside
        if (findPath(maze, visited, i + 1, j)) return true;

        // Get answer from right side
        if (findPath(maze, visited, i, j + 1)) return true;

        // If none of the above conditions are true that means we can't find any path from this cell so that we have -
        // - to mark this as unvisited and go back (backtrack) to previous cell and try to find a way from there

        // Mark this cell unvisited and backtrack
        visited[i][j] = false;

        // Backtrack
        return false;
    }
}
