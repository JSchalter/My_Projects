/*==========================================================

 Title:       Assignment 3 - Numerical Reversal
 Course:      CIS 2252
 Author:      <Jordan & Schalter>
 Date:        < 06/10/2022 >
 Description: This program shows a solution involving numerical reversal. Input 1st number to represent the size of the array
 and then input numbers (seperated by spaces) which represent the array and reverse them in the output.

 ==========================================================
*/

#include<iostream>
using namespace std;

//enter number size for the array and accept numbers (seperated by spaces) for reversal
int main() {
    int n;
    cin>>n;
    int a[n];
    for (int i=0; i<n;i++)
    {
        cin>>a[i];
    }
    //Reverse user input and print out new number order     
    for(int i=n-1;i>=0;i--)
    {
        cout<<a[i]<<" ";
    }
   return 0; 
}
//end main
