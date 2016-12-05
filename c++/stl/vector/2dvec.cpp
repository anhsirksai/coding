#include<bits/stdc++.h>

using namespace std;

int main(){
    vector<vector<int>> sdv;


    for(int i =0;i<3;i++){
        vector<int> temp;
        for(int j = 0;j<3;j++){
            temp.push_back((i+1)+(j+1));
        }
        sdv.push_back(temp);
    }

    for(const auto &row:sdv){
        for(const auto &s:row) cout<< s << " ";
        cout<<endl;
    }

    int n,m,x,y;
    cin >> n >> m;
    int a[n][m];

    for(auto i:n){
        for(auto j:m){
        cin>>a[i][j];
        }
    }
    
    for(auto i:n){
        for(auto j:m){
            cout<< a[i][j] << " ";
        }
        cout<<endl;
    }

    return 0;

}
