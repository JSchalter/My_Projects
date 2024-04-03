# Game loop
# noinspection PyUnreachableCode
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

    # Shuffle dragons
    random.shuffle ( dragons )

    # Loop through caves
    for cave in caves :
        # Get a dragon from the shuffled list
        dragon = dragons.pop ( )

        # Encounter message
        print ( f'You enter the {cave} cave and encounter a {type ( dragon ).__name__} dragon!' )

        # Druid always attacks first
        if isinstance ( character , Druid ) :
            attacker = character
            defender = dragon
        else :
            attacker = dragon
            defender = character

        # Combat loop
        while True :
            # Calculate attack and defense values
            attacker_attack = attacker.strength
            defender_defense = defender.defense

            # Determine attack order based on range
            if attacker.range > defender.range :
                first_attacker = attacker
                second_attacker = defender
            else :
                first_attacker = defender
                second_attacker = attacker

            # First attack
            if first_attacker == attacker :
                print ( f'{type ( attacker ).__name__} attacks first!' )

                if attacker_attack > defender_defense :
                    print ( f'{type ( defender ).__name__} takes {attacker_attack - defender_defense} damage!' )

                    if isinstance ( defender , GoldenDragon ) :
                        character.strength += 1
                        character.defense += 1
                        character.range += 1
                        print ( 'The Golden Dragon boosts your Strength, Defense,and Range by 1 each!' )
                        defender.level += 1
                        defender.level += 1

                        if defender.level == 2 :
                            print ( f'{type ( defender ).name} has leveled up! Strength + 1, Defense + 1, Range + 1' )
                        defender.strength += 1
                        defender.defense += 1
                        defender.range += 1

                        if defender.level == 3 :
                            print ( f'{type ( defender ).name} has leveled up! Strength + 2, Defense + 2, Range + 2' )
                        defender.strength += 2
                        defender.defense += 2
                        defender.range += 2

                        if defender.level != 4 :
                            pass
                        else :
                            print ( f'{type ( defender ).name} has leveled up! Strength + 3, Defense + 3, Range + 3' )
                        defender.strength += 3
                        defender.defense += 3
                        defender.range += 3
                        break
    else :
        print ( f'{type ( defender ).name} blocks the attack!' )
else :
    print ( f'{type ( second_attacker ).name} attacks!' )

    if second_attacker == attacker :
        attacker_attack = attacker.strength
        defender_defense = defender.defense
        if attacker_attack > defender_defense :
            print ( f'{type ( defender ).name} takes {attacker_attack - defender_defense} damage!' )

            if isinstance ( defender , GoldenDragon ) :
                character.strength += 1
                character.defense += 1
                character.range += 1
                print ( 'The Golden Dragon boosts your Strength, Defense, and Range by 1 each!' )
                defender.level += 1

            if defender.level == 2 :
                print ( f'{type ( defender ).name} has leveled up! Strength + 1, Defense + 1, Range + 1' )
            defender.strength += 1
            defender.defense += 1
            defender.range += 1

            if defender.level == 3 :
                print ( f'{type ( defender ).name} has leveled up! Strength + 2, Defense + 2, Range + 2' )
            defender.strength += 2
            defender.defense += 2
            defender.range += 2

            if defender.level == 4 :
                print ( f'{type ( defender ).name} has leveled up! Strength + 3, Defense + 3, Range + 3' )
            defender.strength += 3
            defender.defense += 3
            defender.range += 3

        else :
            print ( f'{type ( defender ).name} blocks the attack!' )
    else :
        pass

    # Check if player is defeated
    if isinstance ( defender , Warrior ) and defender.level == 0 :
        print ( 'Game over! You were defeated by the dragon!' )

    # Check if player defeats all dragons
    if not dragons :
        print ( 'Congratulations! You defeated all of the dragons and saved the land!' )

# Play again option
while True :
    play_again = input ( 'Do you want to play again? (Y/N): ' ).upper ( )
    if play_again in [ 'Y' , 'N' ] :
        break
    else :
        print ( 'Invalid input. Please enter Y or N.' )
    if play_again == 'N' :
        1
    break