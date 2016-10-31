#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int main()
{
    //vector<string>  myVector1;
    //myVector1[1] = "(";
    //myVector1[2] = "[";
    //myVector1[3] = "{";
    //myVector1[4] = "]";
    //myVector1[5] = "}";
    //myVector1[6] = ")";
    //myVector1[7] = "{";

    vector<int>  myVector;
    myVector[0] = 0;
    myVector[1] = 1;
    myVector[2] = 2;
    myVector[3] = 3;
    myVector[4] = 4;
    myVector[5] = 5;
    myVector[6] = 6;
    myVector[7] = 7;
    
    //vector<string>:: iterator s;
    vector<int>:: iterator s;
    for(s = myVector.begin(); s!=myVector.end();s++)
    {
        cout<<*s<<endl;

//        if(*s == "(")
//        {
//            cout<<"sai";
//        }
    }

    return 0;

}
