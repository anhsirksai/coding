#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int main() {

    vector<int>  myvec;
    vector<int> mysecvec(20);
    for ( int i = 0; i < 10; ++i )
         mysecvec[i] = 10 - i;
    mysecvec.at(10) = 11;
    cout<<mysecvec.at(10)<<endl;
//    mysecvec = [2,3,4,5,6,7,8,9];
    vector<int> mythirdvec(mysecvec.begin(),mysecvec.begin()+3);
    int myints[] = {16,2,77,29};
    vector<int> myfourthvec(myints, myints + sizeof(myints) / sizeof(int) );

    vector<int> myfifthvec(4,100);
    vector<int>::iterator s;
    for (s= myfifthvec.begin(); s!=myfifthvec.end();s++)
        cout<<*s<<endl;

    vector<int>::iterator i;
    for(i=mysecvec.begin(); i!=mysecvec.end();i++)
        cout<<*i<<endl;
    return 0;
}
