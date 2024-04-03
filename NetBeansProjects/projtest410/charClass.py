import random

from dragClass import WingedDragon , NetherDragon , ObsidianDragon , GoldenDragon
while True :
    print (
        'Welcome to Dragon Slayer! Your job is to investigate all of the large caves in the land and slay any evil dragons you find in them. One of the dragons is friendly, however, and will help you on your quest! But, first, you need to pick a character type.'
    )
    print ( '1. Warrior\n2. Mage\n3. Druid' )

    # Character selection
    while True :
        choice = input ( 'Choose your character type (1-3): ' )
        if choice in [ '1' , '2' , '3' ] :
            break
        else :
            print ( 'Invalid input. Please choose a number from 1 to 3.' )

    # Instantiate character object
    if choice == '1' :
        character = Warrior ( )
    elif choice == '2' :
        character = Mage ( )
    elif choice == '3' :
        character = Druid ( )

    print ( f'You have selected {type ( character ).__name__} class.' )

# Character classes
class (Character):
    strength = 4
    defense = 2
    range = 1


class Mage :
    strength = 3
    defense = 2
    range = 3


class Druid :
    strength = 3
    defense = 3
    range = 1


# List of caves and dragons
caves = [ 'North' , 'East' , 'Southwest' , 'Southeast' , 'West' ]
dragons = [ IronDragon ( ) , WingedDragon ( ) , NetherDragon ( ) , ObsidianDragon ( ) , GoldenDragon ( ) ]
