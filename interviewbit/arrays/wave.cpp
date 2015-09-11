#include<vector>
#include<algorithm>
#include<iostream>

using namespace std;

class Solution {
    public:
        vector<int> wave(vector<int> v) {
            sort(v.begin(),v.end());
            int size = v.size();
            for (int i = 0; i < size; i+=2)
                swap(v[i],v[i+1]);
            return v;
        }
};

int main(){
    vector<int> a = {4,3,5,2,1,6};
    for (int i = 0; i < sizeof(a) ; i++)
        cout<<a[i] << " ";
    cout<<"\n";
    Solution sObj =  Solution();
    vector<int> ret =  sObj.wave(a);
    for (int i = 0; i < sizeof(ret) ; i++)
        cout<<ret[i] << " ";
    return 0;
}
