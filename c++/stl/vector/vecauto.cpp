#include<bits/stdc++.h>

using namespace std;

int main(){
    vector<int> v = {11,2,13,4,15,6,7,8,9};
    int a[6]={5,4,6,3,7,2};
    for(auto i=v.begin();i<v.end();++i){
        auto n = std::next(i,1);
        auto p = std::prev(i,1);
        cout<< *p << " "<<*i <<" " << *n << endl;    
    }

    sort(v.begin(),v.begin()+5);
    //sprt(v.begin(),v.end());
    for(auto i:v){
        cout<<i << endl;
    }

    //sort(begin(a),end(a));
    sort(begin(a),begin(a)+3);
    for(auto i:a){
        cout<<i<< " ";
    }

    //strings
        string bc = "saikrishna";
            
            for(auto i:bc){
                    cout<<i << " "; // This prints : "s a i k r i s h n a"
                }
    //bitwise.
    int bita = 42;
    int bitb = 27;
    cout << "bitwise xor "<< (bita^bitb);
    cout << endl;
    cout <<"negation " << (~bita) <<endl;

    //ceil.
    cout << ceil(-12.3) << " ceil" << endl;

    cout << "natural log " <<log(2) <<  endl;
    cout << "base 10 log" << log10(2) <<endl ;

    return 0;
}
