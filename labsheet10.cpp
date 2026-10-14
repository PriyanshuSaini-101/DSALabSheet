// #include <iostream>
// #include <list>
// using namespace std;

// class HashTable {
//     int size;
//     list<int>* table;

// public:
//     HashTable(int s) {
//         size = s;
//         table = new list<int>[size];
//     }

//     void insert(int key) {
//         int index = key % size;
//         table[index].push_back(key);
//     }

//     void display() {
//         for (int i = 0; i < size; i++) {
//             cout << i << ": ";
//             for (int x : table[i])
//                 cout << x << " -> ";
//             cout << "NULL\n";
//         }
//     }
// };

// int main() {
//     HashTable h(5);

//     h.insert(10);
//     h.insert(15);
//     h.insert(7);
//     h.insert(20);
//     h.insert(12);

//     cout << "Open Hashing:\n";
//     h.display();

//     return 0;
// }



// Q 2 


// #include <iostream>
// #include <vector>
// #include <queue>
// using namespace std;

// void DFS(int v, vector<vector<int>>& graph, vector<bool>& visited) {
//     visited[v] = true;
//     cout << v << " ";

//     for (int x : graph[v])
//         if (!visited[x])
//             DFS(x, graph, visited);
// }

// void BFS(int start, vector<vector<int>>& graph) {
//     vector<bool> visited(graph.size(), false);
//     queue<int> q;

//     q.push(start);
//     visited[start] = true;

//     while (!q.empty()) {
//         int v = q.front();
//         q.pop();

//         cout << v << " ";

//         for (int x : graph[v]) {
//             if (!visited[x]) {
//                 visited[x] = true;
//                 q.push(x);
//             }
//         }
//     }
// }

// int main() {
//     vector<vector<int>> graph = {
//         {1, 2},
//         {0, 3},
//         {0, 3},
//         {1, 2}
//     };

//     vector<bool> visited(4, false);

//     cout << "DFS: ";
//     DFS(0, graph, visited);

//     cout << "\nBFS: ";
//     BFS(0, graph);

//     return 0;
// }


#include <iostream>
#include <algorithm>
using namespace std;

struct Edge {
    int u, v, w;
};

int parent[10];

int find(int x) {
    if (parent[x] == x)
        return x;
    return parent[x] = find(parent[x]);
}

void unite(int a, int b) {
    parent[find(a)] = find(b);
}

void kruskal(Edge e[], int n, int V) {
    sort(e, e + n, [](Edge a, Edge b) {
        return a.w < b.w;
    });

    for (int i = 0; i < V; i++)
        parent[i] = i;

    int cost = 0;

    cout << "Kruskal MST: ";

    for (int i = 0; i < n; i++) {
        if (find(e[i].u) != find(e[i].v)) {
            unite(e[i].u, e[i].v);
            cout << "(" << e[i].u << "-" << e[i].v << ") ";
            cost += e[i].w;
        }
    }

    cout << "\nCost = " << cost << endl;
}

void prim(int graph[5][5], int V) {
    int key[5], parent[5];
    bool used[5] = {};

    for (int i = 0; i < V; i++)
        key[i] = 999;

    key[0] = 0;
    parent[0] = -1;

    for (int c = 0; c < V; c++) {
        int u = -1;

        for (int i = 0; i < V; i++)
            if (!used[i] && (u == -1 || key[i] < key[u]))
                u = i;

        used[u] = true;

        for (int v = 0; v < V; v++)
            if (graph[u][v] && !used[v] && graph[u][v] < key[v]) {
                key[v] = graph[u][v];
                parent[v] = u;
            }
    }

    int cost = 0;

    cout << "Prim MST: ";

    for (int i = 1; i < V; i++) {
        cout << "(" << parent[i] << "-" << i << ") ";
        cost += graph[i][parent[i]];
    }

    cout << "\nCost = " << cost << endl;
}

int main() {
    Edge e[] = {
        {0,1,2},
        {0,3,6},
        {1,2,3},
        {1,3,8},
        {2,3,5}
    };

    int graph[5][5] = {
        {0,2,0,6,0},
        {2,0,3,8,0},
        {0,3,0,5,7},
        {6,8,5,0,9},
        {0,0,7,9,0}
    };

    kruskal(e, 5, 4);
    prim(graph, 5);

    return 0;
}