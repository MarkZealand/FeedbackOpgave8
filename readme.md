# README – Loot Crate System med exceptions
Infinite Loopers:
- Mark
- Niklas

## Hvad projektet går ud på
Et system til at håndtere spillere og loot crates. Programmet opretter spillere og loot crates og kører derefter fire scenarier.

## Hvordan programmet er opdelt i metoder

**Player**
- Konstruktør
- `addCredits()` / `removeCredits()` – kaster `NegativeAmountException` ved negative beløb
- `showInfo()` – viser navn, credits og inventory

**LootCrate**
- Konstruktør – validerer `creditCost` og `lootItem`
- `openCrate(Player)` – kaster `NotEnoughCreditsException`, hvis spilleren mangler credits; tilføjer ellers item til inventory

**LootItem**
- Konstruktør
- Getters og `toString()`

**Exceptions (NegativeAmountException, NotEnoughCreditsException, PlayerNotFoundException)**
- Arver fra `RuntimeException`
- Tager en besked i konstruktøren

**LootCrateSystem (Main)**
- `main()` – starter programmet
- `createPlayers()` – opretter de faste spillere
- `createLootCrates()` – opretter de faste crates
- `scenarioOne()` til `scenarioFour()` – afprøver de fire cases
- `findPlayer(String)` – slår en spiller op og kaster `PlayerNotFoundException`, hvis den ikke findes

## Hvorfor denne opdeling
Hver klasse har ét ansvar: modellerne holder styr på data og logik, exceptions beskriver fejlene, og `LootCrateSystem` styrer de scenarier, der demonstrerer kravene.

## Eksempel på en metode med parameter
`openCrate(Player player)` tager en spiller som parameter og fratrækker credits samt tilføjer loot til spillerens inventory.

## Eksempel på en metode med returværdi
`findPlayer(String name)` returnerer en `Player`, hvis den findes – ellers kastes en exception.

## Hvilke løkker bruges, og hvorfor
Vi bruger en `for each` løkke i `findPlayer` til at gennemgå spillere og finde den rigtige.

## Ting vi har testet
- At en spiller kan åbne en crate og få item i inventory (scenario 1)
- At `NotEnoughCreditsException` kastes, når spilleren mangler credits (scenario 2)
- At `NegativeAmountException` kastes ved negative credits (scenario 3)
- At `PlayerNotFoundException` kastes, når spilleren ikke findes (scenario 4)

## En fejl eller udfordring vi stødte på
Det tog lidt tid at sætte sig helt ind i hvordan throw og throws koples sammen med checked og unchecked exceptions, og hvor man skal placere begge typer.
## Hvad vi har lært om klasser
At custom exceptions giver mere meningsfuld fejlhåndtering end generiske exceptions, og at checked vs. unchecked exceptions påvirker, hvordan kaldende kode skal håndtere fejlene.