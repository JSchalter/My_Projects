/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/
#include<iostream>
#include<fstream>
#include<iomanip>
using namespace std;
class ctm{
    public:
    string ctype;
    float amm;
    float cfactor;
    float ammInD;
    float tax;
    float tAmm;
    ctm(){
        ctype = "";
        amm = 0;
    }
    void intro(){
        while(1){
            int t;cin>>t;
            if(t == 1){
               ctype = "Yuan";
               cfactor = 6.77;
               break;
            }
            else if(t == 2){
                ctype = "Euro";
                cfactor = 0.98;
                break;
            }
            else if(t == 3){
                ctype = "Pounds";
                cfactor = 0.83;
                break;
            }
            cout<<"Invalid Entry, Please enter a number between 1-3:\n";
        }
        
    }
    
};
class amount: public ctm{
    public:
    void calculations(){
        cin>>amm;
        ammInD = amm/cfactor;
        tax = ammInD*0.05;
        tAmm = ammInD + tax;
    }
};
class rc:public amount{
    public:
    void rctype(){
        ofstream MyFile("filename.txt");
        MyFile<<fixed;
        MyFile<<setprecision(2);
        MyFile<<amm<<" "<<ctype<<"\n";
        MyFile<<ammInD<<" "<<"dollars\n";
        MyFile<<tax<<" dollars\n";
        MyFile<<tAmm<<" dollars\n";
        MyFile.close();
        cout<<fixed;
        cout<<setprecision(2);
        cout<<amm<<" "<<ctype<<"\n";
        cout<<ammInD<<" "<<"dollars\n";
        cout<<tax<<" dollars\n";
        cout<<tAmm<<" dollars\n";
    }
};
int main(){
    rc obj;
    obj.ctm::intro();
    obj.amount::calculations();
    obj.rctype();
}