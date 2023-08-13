#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

const int NODE_MAX = 5000;

struct Node {
    int data;
    Node* next;

    Node(int data) : data(data), next(nullptr) {}
};

class LinkedList {
    Node* head;
    Node* tail;
    vector<Node*> nodeArr;
    int nodeCnt;

public:
    LinkedList() : head(nullptr), tail(nullptr), nodeCnt(0) {
        nodeArr.resize(NODE_MAX, nullptr);
    }

    Node* getNewNode(int data) {
        nodeArr[nodeCnt] = new Node(data);
        return nodeArr[nodeCnt++];
    }

    void insert(int idx, const vector<int>& nums) {
        int st = 0;
        if (idx == 0) {
            if (head != nullptr) {
                Node* newNode = getNewNode(nums[0]);
                newNode->next = head;
                head = newNode;
            }
            else {
                head = getNewNode(nums[0]);
            }
            idx = 1;
            st = 1;
        }

        Node* cur = head;
        for (int i = 1; i < idx; i++) {
            cur = cur->next;
        }

        for (int i = st; i < nums.size(); i++) {
            Node* newNode = getNewNode(nums[i]);
            newNode->next = cur->next;
            cur->next = newNode;
            cur = newNode;
        }

        if (cur->next == nullptr) {
            tail = cur;
        }
    }

    void remove(int idx, int cnt) {
        Node* cur = head;
        if (idx == 0) {
            for (int i = 0; i < cnt; i++) {
                cur = cur->next;
            }
            head = cur;
            return;
        }

        for (int i = 1; i < idx; i++) {
            cur = cur->next;
        }
        Node* anchor = cur;

        for (int i = 0; i < cnt; i++) {
            cur = cur->next;
        }
        anchor->next = cur->next;

        if (anchor->next == nullptr) {
            tail = anchor;
        }
    }

    void add(int data) {
        Node* cur = tail;
        Node* newNode = getNewNode(data);
        cur->next = newNode;
        tail = newNode;
    }

    void print() {
        int cnt = 10;
        Node* cur = head;
        while (cnt-- > 0) {
            cout << cur->data << " ";
            cur = cur->next;
        }
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int T = 10;

    for (int t = 1; t <= T; t++) {
        LinkedList list;
        cout << "#" << t << " ";

        int N;
        cin >> N;

        vector<int> initArr(N);
        for (int i = 0; i < N; i++) {
            cin >> initArr[i];
        }
        list.insert(0, initArr);

        int M;
        cin >> M;

        for (int i = 0; i < M; i++) {
            char cmd;
            cin >> cmd;

            int x, y;
            vector<int> temp;
            switch (cmd) {
            case 'I':
                cin >> x >> y;
                temp = vector<int>(y);
                for (int j = 0; j < y; j++) {
                    cin >> temp[j];
                }
                list.insert(x, temp);
                break;
            case 'D':
                cin >> x >> y;
                list.remove(x, y);
                break;
            case 'A':
                cin >> y;
                for (int j = 0; j < y; j++) {
                    int data;
                    cin >> data;
                    list.add(data);
                }
                break;
            }
        }

        list.print();
        cout << "\n";
    }

    return 0;
}
