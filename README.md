Duel Game

You will have two characters. Each character will start with 100 health, a random defense power (between 10 and 15), and a random attack power (between 15 and 20).

In addition to this, each can have a special ability that has a 25% chanche of activation. It is decided randomly what ability the character has. The abilities are as follows:
1. If the character is attacked, it will take only half damage
2. If the character attacks, it will attack with 50% more power
3. If an attack takes the character to under 30 health, it will heal itself by 5

You can either randomly select one ability at the start of the game, that the characetr will have throughout the entire game, or on each round a new ability can be selected randomly.

The task is to simulate a fight between the chracters.

1. It will be selected randomly which characetr starts the fight
2. Round 1: The selected character attacks the other one by it’s attack power. The attacked characeter will decrease the attack by it’s defense power and then this value will be subtracted from it’s health.
3. The roles are reversed and the other character attacks now. The fight will go on until one character gets to 0 health.

The messages printed by the game should be something like:


You will have two characters. Each character will start with 100 health, a random defense power (between 10 and 15), and a random attack power (between 15 and 20).

In addition to this, each can have a special ability that has a 25% chanche of activation. It is decided randomly what ability the character has. The abilities are as follows:
1. If the character is attacked, it will take only half damage
2. If the character attacks, it will attack with 50% more power
3. If an attack takes the character to under 30 health, it will heal itself by 5

You can either randomly select one ability at the start of the game, that the characetr will have throughout the entire game, or on each round a new ability can be selected randomly.

The task is to simulate a fight between the chracters.

1. It will be selected randomly which characetr starts the fight
2. Round 1: The selected character attacks the other one by it’s attack power. The attacked characeter will decrease the attack by it’s defense power and then this value will be subtracted from it’s health.
3. The roles are reversed and the other character attacks now. The fight will go on until one character gets to 0 health.

The messages printed by the game should be something like:

Character 1: power = xx, defense = xx
Character 2: power = xx, defense = xx

Round 1:
Character 1 attacks
Character 2 activates ability 1
Character 2 has 95 health

Round 2:
Character 2 attacks
No ability activated
Character 1 has now 90 health

And so on until only one character remains with health above 0.
At the end the message: “Character 1/2 won” will be printed

My recommendation is to write this in NodeJs with TypeScript, but any other language is ok.


Warning! the game has a bug. If both players select ability number 3 and the atack power and defense power is the same for both charaters the game enters a loop because the hp of both players stays at 100 hp.


