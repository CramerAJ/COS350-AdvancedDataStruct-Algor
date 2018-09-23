Evan Sampson, Katie Manzo, Andrew Cramer
Community Connector Calculator
COS350 Term Project
Spring 2016

Files:
1. AdjacencyMatrix.java
2. Edge.java
3. FloydWarshall.java
4. Main.java
5. test.java
6. routes.txt

NOTE: Enter "routes.txt" into the console in Main.java

-------------------------------------------------------------
AdjacencyMatrix.java

This class models adjacency matrices, which are used to implement
graphs. The matrix has a few manipulation methods, and was designed
to work with the Floyd-Warshall APSP algorithm.
-------------------------------------------------------------
Edge.java

Essentially just a triple, containing a parent vertex, child vertex,
and a weight for the edge.
-------------------------------------------------------------
FloydWarshall.java

The implementation of Floyd-Warshall APSP. Requires only (V, E) to 
run. By far the most difficult part of the code.
-------------------------------------------------------------
Main.java

The console application for computing APSP on the local bus routes.
Has potential for expansion, as long as the input files follow the
same format as routes.txt.
-------------------------------------------------------------
test.java

A simple test case from the textbook. Works as expected.
-------------------------------------------------------------
routes.txt

This file contains a list of the bus stops in orono, followed by
a list of the travel times for each bus stop. The travel times are
in the format "OnStop time OffStop".
