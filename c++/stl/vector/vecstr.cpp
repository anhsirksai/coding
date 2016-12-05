#include<bits/stdc++.h>
using namespace std;
int main()
{
    vector<string>  s = {"This is a test string"};
    for(int i = 0; i < s.size(); i++){
        for(auto n : s[i] ){
           if(isspace(n))
               cout<<"\n";
           else
            cout<<n << " ";
        }
    }
    return 0;

}
