#include<stdio.h>
// C program to demonstrate that array elements are stored
// contiguous locations
int main()
{
  // an array of 10 integers.  If arr[0] is stored at
  // address x, then arr[1] is stored at x + sizeof(int)
  // arr[2] is stored at x + sizeof(int) + sizeof(int)
  // and so on.
  int arr[5], i;
 
  printf("Size of integer in this compiler is %u\n", sizeof(int));
 
  for (i=0; i<5; i++)
  {
    // The use of '&' before a variable name, yields
    // address of variable.
    printf("Address arr[%d] is %u\n", i, &arr[i]);
  }

  for (int j = 20; j <=25;j++)
  {
      printf("sai %d", &j);
  }
 
  return 0;
}
