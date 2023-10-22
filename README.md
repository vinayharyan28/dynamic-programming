# dynamic-programming

_Dynamic programming is powerful problem-solving technique used in computer science and mathematics to solve complex problems by breaking them down into simpler, Overlapping sub problems.
It is particularly useful for optimization problems where you want to find the best solution among a set of possible solution.
Dynamic programming can significantly improve the efficiency of algorithms by avoiding redundant calculations and storing adn reusing intermediate results.
Dynamic Programming is mainly an optimization over plain recursion.
Wherever we see a recursive solution that has repeated call for the same inputs, we can optimize it using Dynamic Programming.
The idea is to simply store the results of sub problems so that we do not have to recompute them when needed later.
This simple optimization reduces time complexities from exponential to polynomial_

1. **Principle of Dynamic Programming:**
    _Dynamic programming follows the principle of optimality, which means that an optimal solution to a problem can be constructed from optimal solutions of its sub problems. By solving and storing the result of sub problems, dynamic programming avoids redundant work when solving larger problems._
2. **Types of problems solved with Dynamic Programming:**
    _Dynamic programming is commonly used to solve problems such as finding the shortest path, optimizing resource allocation, sequence alignment, text comparison, and many other optimization task.
    It's widely applied in fields like computer science, operations research, and economics._
3. **Basic Steps in Dynamic Programming:**
   1. _**Define the problem:**_ _Clearly define the problem and identify the parameters or variables involved._
   2. _**Identify the base case:**_ _Determine the simplest sub problem(s) that can be solved directly and provide the answer._
   3. _**Define the recurrence relation:**_ _Express the solution to a larger problem in terms of solutions to smaller sub problems. This is often done using a recursive formula._
   4. _**Apply memoization or tabulation:**_ _Store the results of solved sub problems to avoid re computation._
   5. _**Solve the original problem:**_ _Use the results of sub problems to solve the original problem optimally._

4. **Memoization and Tabulation:**
    _These are two common techniques used in dynamic programming to store and retrieve intermediate results._
   1. _**Memoization:**_  _In this approach, you use a data structure (often a dictionary or array) to store the results of sub problems as they are solved. Before solving a sub problem, you check if you've already solved it, and if so, you return the stored result._
   2. _**Tabulation:**_ _Tabulation involves building a table (often a 2D array) and filling it in a bottom-up manner, starting with the base cases. This ensures that you solve each sub problem only once and build your solution iteratively._

5. **Dynamic Programming Terminology:**
   1. _**Optimal substructure:**_ _The property that an optimal solution to a problem contains optimal solutions to its sub problems._
   2. _**Overlapping sub problems:**_ _When a problem can be broken down into sub problems that are solved independently but have common sub-sub problems._
   3. _**Top-down vs. bottom-up:**_ _Top-down dynamic programming begins with the original problem and recursively breaks it down into sub problems. Bottom-up starts with the base cases and builds the solution iteratively._

6. **Examples of Dynamic Programming Algorithms:**
   1. _**Fibonacci Sequence:**_ _Computing the nth Fibonacci number using dynamic programming to avoid redundant calculations._
   2. _**Knapsack Problem:**_ _Finding the most valuable combination of items to fit into a knapsack with limited capacity._
   3. _**Shortest Path Algorithms:**_ _Finding the shortest path in a graph, like Dijkstra's or Floyd-Warshall algorithm._

