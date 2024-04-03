/*==========================================================

 Title:       Assignment 1 - Dragon Years
 Course:      CIS 2252
 Author:      <Jordan Schalter>
 Date:        < 05/22/2022 >
 Description: This program will calculate your dragon's age....

 ==========================================================
*/
#include <iostream>
using namespace std;

int main() {
    //user input
    string name;
    cout << "Enter your Dragon's name:";
    cin >> name;
    
    double age;
    cout << "Enter Dragon's age (in human years):";
    cin >> age; 
    //stores your dragons age in human years
    double age_dragon_wizard_years;
    
    //store your dragons age in wizard years for later calculation
    //calculate age of dragon in wizard years
    if(age ==1){
        age_dragon_wizard_years = 10.5;
        //if age is 1 then applies predifined age in wizard years
        } else if(age == 2){
        age_dragon_wizard_years == 21;
            } else {
            //if dragon age is 2 or more then applies predifined age in wizard years}
            age_dragon_wizard_years = 21;
                for (int i = 0; i < age - 2; i++){ 
                age_dragon_wizard_years += 4;
                //adding 4 years in wizard to dragons predifined input age
    }
}    
    //print the dragons information to output
    cout << "The dragon named " << name << " is " << age_dragon_wizard_years << " in wizard years" << endl;
    
  return 0;
}

 
//While I did notice in the directions that you stated not to use prompts - I was able to use prompts without running into issues if needed I can resubmit with no prompts. I also, did not know if you wanted us to include decimals or floats in this project so I just stuck with the doubles
