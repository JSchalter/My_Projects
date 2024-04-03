class Character:
    int:
    strength: int = 4
    defense: int = 2
    range: int = 1

Creature(){
}

Creature(string s1, int i1){
    name=s1;
quantity=i1;
type="unknown";
}
void setName(string s){
    name=s;
}
void setQuantity(int i){
if(i<0){
    quantity=abs(i);
}
else quantity=i;
}
void setType(string s){
    type=s;
}
string getType(){
return type;
}
string getName(){
return name;
}
int getQuantity(){
return quantity;
}
void printStatement(){
cout<<"There's "<<quantity<<" creatures named "<<name<<endl;
}

};

class Phoenix:Creature:
        string color;
public:

Phoenix():
    setType("Phoenix");
}
void printStatement(){
    cout<<"There's "<<getQuantity()<<" "<<color<<" "<< getType()<<"es named "<<getName()<<endl;
}
void setColor(string s){
    color=s;
}
string getColor(){
return color;
}
};

class Basilisk:public Creature{
    public:
        Basilisk(){
        setQuantity(1);
setType("Basilisk");
}
void printStatement(){
    cout<<"There's "<< getQuantity()<<" "<<getType()<<" named "<< getName()<<endl;
}
};

int main(){
    int i;
//create empty array of size 3 for storing name
string nameArr[3];

// Write loop here to record user input as names
// and set third name to “Clover”
for(i=0;i<2;i++){
cin>>nameArr[i];

}
nameArr[2]="Clover";

Creature c(nameArr[0], 2);
//print statement from class
    c.printStatement();

    Phoenix p;
    //sets name, quantity and color
    p.setName(nameArr[1]);
    p.setQuantity(3);
    p.setColor("golden");
//print statement from class
    p.printStatement();

    Basilisk b;
//sets name
b.setName(nameArr[2]);
//prints statement from class
    b.printStatement();


}
