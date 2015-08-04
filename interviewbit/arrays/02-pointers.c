#include<iostream>
using namespace std;
int main() {
    int a[3] = {10,9,8};
    cout <<"a is same as printing content of pointer "<< a <<endl;
    cout<< "a[1] is same as *a i.e value pointed by pointer" << a[1] << endl;
    cout << "&a[1] is same as printing contents " << &a[1] <<endl;
    int b[2][3] = {{1,2,3},{4,5,6}};
    std::cout << "1-d arrary of three integers" << b[0] << std::endl;
    cout<< *b[0] << endl << *b;
    // B[i][j] = *(B[i]+j) = *(*(B+i) +j)
    // Always remember the horizontal representation of arrays while thining about memory.
    // Multidimentional arrays === Multiple Layers. Hence number of * increase per level.
    return 0;
}

