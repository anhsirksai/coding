#include<bits/stdc++.h>
using namespace std;

vector<vector<int> > performOps(vector<vector<int> > &A) {
    vector<vector<int> > B;
    B.resize(A.size());
    for (int i = 0; i < A.size(); i++) {
        B[i].resize(A[i].size());
        for (int j = 0; j < A[i].size(); j++) {
            B[i][A[i].size() - 1 - j] = A[i][j];
        }
    }
    return B;
}

int main(){

//    int C[][4] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//    vector<vector<int> > A = (C,C + sizeof(C)/sizeof(C[0][0]));
//    vector<vector<int> > A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

    vector<vector<int> > A;
    int loopvar = 0;
    while(loopvar <3)
    {
        vector<int> temp(4,0);
        A.push_back(temp)
    }

    int da[3][4] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    while(loopvar <3)
    {
        vector<int> temp(4,0);
        for (int j =0; j <4; j++)
        {
            temp[j] = da[loopvar][j];
        }
        A.push_back(temp)
    }

    

    vector<vector<int> > B = performOps(A);
    for (int i = 0; i < B.size(); i++) {
        for (int j = 0; j < B[i].size(); j++) cout<<B[i][j]<<" ";
    }

    return 0;
}

