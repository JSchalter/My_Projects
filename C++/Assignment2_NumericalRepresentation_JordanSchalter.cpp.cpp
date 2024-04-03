/*==========================================================

 Title:       Assignment 2 - Numerical Representation
 Course:      CIS 2252
 Author:      <Jordan Schalter>
 Date:        < 05/28/2022 >
 Description: Accepts two inputs based on the rules provided for the project. If the input numbers range falls between 1 and 9 it will output in lowercase
 its word reepresentation. If the range exceeds 9 and the number is even then the output is "even" - If the range exceeds 9, and the number is odd, then the
 output is "odd" - The final assupmtion is that the 1st input < 2nd input.

 ==========================================================
*/
#include<iostream>
using namespace std;

    
void showResult(int num);
       
int main(){
    int num1, num2; //user input variables
    cin >> num1; //accept first user input variable
    cin >> num2; //accept second user input variable

    showResult(num1); //show first result to console
    showResult(num2); //show second result to console
    return 0;

}

//method to take user input and output value into a word represention of the input, also, 
//determains if range is greater than nine and if the number is even or odd  

void showResult(int num) {
    string words[10] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    if(num >=1 && num <= 9) // check to see if the user input falls between range 1-9
        cout << words[num - 1] << endl; //grabs the word from array and prints to console
    else if(num > 9 && num % 2 == 0)
        cout << "even\n"; // if the user input is greater than 9 and is even - prints "even"
    else if(num > 9 && num % 2 != 0)
        cout << "odd\n"; //if the user input is greater than 9 and is odd - prints "odd"
    else
        cout << "error\n";

}//end program


