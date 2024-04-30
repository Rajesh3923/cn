import java.util.Scanner;
public class ShortestPath {
  // Maximum number of nodes
  static final int MAX_NODES = 50;
  // Infinity value
  static final int INFINITY = 1000;
  // Number of nodes
  static int n;
  // Names of nodes
  static char[] name = new char[MAX_NODES];
  // Distance matrix
  static int[][] dist = new int[MAX_NODES][MAX_NODES];
  // Function to find the shortest path
  static int shortestPath(int s, int d, int[] path) {
    // Define a class to store state information
    class State {
      int predecessor;
      int length;
      int label;
    }
    State[] state = new State[MAX_NODES];

    // Initialize states
    for (int i = 0; i < n; i++) {
      state[i] = new State();
      state[i].predecessor = -1;
      state[i].length = INFINITY;
      state[i].label = 0;
    }
    // Set source node's length to 0 and label to 1
    state[s].length = 0;
    state[s].label = 1;
    int k = s;

    do {
      // Update lengths of adjacent nodes
      for (int i = 0; i < n; i++) {
        if (dist[k][i] != 0 && state[i].label == 0) {
          if (state[k].length + dist[k][i] < state[i].length) {
            state[i].predecessor = k;
            state[i].length = state[k].length + dist[k][i];
          }
        }
      }
      // Find node with minimum length and label it
      k = -1;
      int min = INFINITY;
      for (int i = 0; i < n; i++) {
        if (state[i].label == 0 && state[i].length < min) {
          min = state[i].length;
          k = i;
        }
      }
      if (k != -1) {
        state[k].label = 1;
      }
    } while (k != -1 && k != d);
    // Backtrack to find the shortest path
    int i = 0;
    k = d;
    do {
      path[i++] = k;
      k = state[k].predecessor;
    } while (k >= 0);
    // Return the length of the shortest path
    return i;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number of nodes:");
    n = scanner.nextInt();

    // Populate node names and distances
    System.out.println("Enter the distances between each node:");
    System.out.println("If there is no path, enter 0 as its distance");

    System.out.print("\t");
    for (int i = 0; i < n; i++) {
      name[i] = (char) ('A' + i);
      System.out.print(name[i] + "\t");
    }
    System.out.println("\n");

    for (int i = 0; i < n; i++) {
      System.out.print(name[i] + "\t");
      for (int j = 0; j < n; j++) {
        dist[i][j] = scanner.nextInt();
      }
    }

    // Input source and destination nodes
    System.out.println("\nEnter the source name:");
    char source = scanner.next().charAt(0);

    int sourceIndex = -1;
    for (int i = 0; i < n; i++) {
      if (name[i] == source) {
        sourceIndex = i;
        break;
      }
    }
    if (sourceIndex == -1) {
      System.out.println("No node with the given name.");
      return;
    }

    System.out.println("\nEnter the destination name:");
    char dest = scanner.next().charAt(0);

    int destIndex = -1;
    for (int j = 0; j < n; j++) {
      if (name[j] == dest) {
        destIndex = j;
        break;
      }
    }
    if (destIndex == -1) {
      System.out.println("No node with the given destination name.");
      return;
    }

    // Find and print the shortest path
    int[] path = new int[MAX_NODES];
    int pathLength = shortestPath(sourceIndex, destIndex, path);
    if (pathLength == 0 || path[0] != destIndex) {
      System.out.println("No path exists between the source and destination.");
    } else {
      System.out.print("The shortest path is: ");
      for (int i = pathLength - 1; i > 0; i--) {
        System.out.print(name[path[i]] + " -> ");
      }
      System.out.println(name[path[0]]);
    }

    scanner.close();
  }
}



// Output 
/* Enter the number of nodes:
5
Enter the distances between each node:
If there is no path, enter 0 as its distance
        A       B       C       D       E

A       0 4 0 0 0
B       4 0 1 2 0
C       0 1 0 5 0
D       0 2 5 0 3
E       0 0 0 3 0

Enter the source name:
C

Enter the destination name:
E
The shortest path is: C -> B -> D -> E */
