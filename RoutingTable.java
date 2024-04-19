import java.util.Scanner;
public class RoutingTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j, x, y, n, d = 0, delay = 1000;
        int[][] edge;
        int[] c;
        int[][] cost;
        System.out.println("Enter the No.of nodes in graph: ");
        n = scanner.nextInt();
        edge = new int[n][n];
        c = new int[n];
        cost = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                System.out.println("Is there any edge from " + (i + 1) + " to " + (j + 1) + "? ");
                 d = scanner.nextInt();
                if (d == 1) {
                    edge[i][j] = 1;
                    edge[j][i] = 1;
                } else {
                    edge[i][j] = 0;
                    edge[j][i] = 0;
                }
            }
        }
        System.out.println("Which Routing table do you want to find the cost of which destination? ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        for (i = 0; i < n; i++) {
            if (edge[i][x - 1] == 1 || edge[x - 1][i] == 1) {
                System.out.println("Enter the cost of " + x + " node to its neighbor " + (i + 1) + ":");
                c[i] = scanner.nextInt();
                System.out.println("Enter the Routing table entry to " + (i + 1) + " to " + y + ": ");
                cost[i][y - 1] = scanner.nextInt();
                if (delay > (c[i] + cost[i][y - 1])) {
                    d = i + 1;
                    delay = c[i] + cost[i][y - 1];
                }
            }
        }
        System.out.println("Estimated cost from node " + x + " to " + y + " is " + delay + " via the node is " + d);
        scanner.close();
    }
}
/*
Enter the No.of nodes in graph: 
3
Is there any edge from 1 to 1? 
0
Is there any edge from 1 to 2?
1
Is there any edge from 1 to 3?
1
Is there any edge from 2 to 2?
0
Is there any edge from 2 to 3?
1
Is there any edge from 3 to 3?
0
Which Routing table do you want to find the cost of which destination?
1 3
Enter the cost of 1 node to its neighbor 2:
2
Enter the Routing table entry to 2 to 3:
5
Enter the cost of 1 node to its neighbor 3:
4
Enter the Routing table entry to 3 to 3:
0
Estimated cost from node 1 to 3 is 4 via the node is 3
 */