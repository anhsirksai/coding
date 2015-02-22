#include<bits/stdc++.h>
using namespace std;

void display(vector<int>& v) {
    vector<int>::iterator i;
    for(i = v.begin(); i!=v.end();i++)
         cout<<*i<<endl;
    }

int main() {
    int count = 0;
    int c = 0;
    int size = 0;
    int rem = 0;
    vector<int> v;

    cin>>size;

    for(int i = 0; i < size; i++)
    {
        count = 0;
        cin>>c;
        while(c > 0)
        {
            rem = 0;
            rem = c%10;
            c = c/10;
            if(rem == 4)
                count = count + 1;
        }
        v.push_back(count);
    }
    display(v);

    return 0;
}



