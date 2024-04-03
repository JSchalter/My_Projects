/*==========================================================

 Title:     Assignment 4 - C++ Care Unit
 Course:  	CIS 2252
 Author:  	<Jordan Schalter>
 Date:    	<06/25/2022 >
 Description: This program will calculate the BMI using two inputs of weight in kilograms and one input of height in feet 
 (that will be convertered to meters). Then, it will swap the values of the two weights and calculate the BMI again within the main function..

 ==========================================================
*/

#include <iostream>
using namespace std;

//Calculations
double BMIcalculator(double w) {
    return w / (1.8 * 1.8);
}

double BMIcalculator(double w, double h) {
    return w / (h * h);
}

double conversionMeters(double h) {
    return h / 3.281;
}
//End calculations 

int main() {
    //DO NOT MODIFY MAIN()!!!
    
    double w1, w2, h;
    cin >> w1 >> w2 >> h;

    float index1 = BMIcalculator(w1);
    float index2 = BMIcalculator(w2, conversionMeters(h));

    cout << index1 << " " << index2 << endl;

    swap(w1, w2);

    index1 = BMIcalculator(w1);
    index2 = BMIcalculator(w2, conversionMeters(h));
    cout << index1 << " " << index2 << endl;
}
//End main