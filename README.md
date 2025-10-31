```
░  ░░░░  ░░        ░░░      ░░░        ░░  ░░░░░░░░  ░░░░░░░░░░░░░░░      ░░░░      ░░░  ░░░░  ░░       ░░░        ░░   ░░░  ░░░      ░░
▒  ▒  ▒  ▒▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒   ▒▒   ▒▒  ▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒    ▒▒  ▒▒  ▒▒▒▒▒▒▒
▓        ▓▓▓▓▓  ▓▓▓▓▓  ▓▓▓   ▓▓      ▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓  ▓▓        ▓▓       ▓▓▓▓▓▓  ▓▓▓▓▓  ▓  ▓  ▓▓  ▓▓▓   ▓
█   ██   █████  █████  ████  ██  ████████  ████████  ██████████████  ████  ██        ██  █  █  ██  ███████████  █████  ██    ██  ████  █
█  ████  ██        ███      ███        ██        ██        █████████      ███  ████  ██  ████  ██  ████████        ██  ███   ███      ██
```
Wigell Camping Medlemsklubb och Uthyrningssystem
Översikt

Wigell Camping är en fullt konsolbaserad Java-applikation som modellerar en medlemsklubb med uthyrning av utrustning såsom fordon och campingutrustning. Applikationen möjliggör hantering av medlemmar, uthyrningsobjekt och uthyrningsprocesser på ett intuitivt och strukturerat sätt.
Funktioner

    Medlemskapshantering: Skapa, redigera, ta bort och visa medlemmar med medlemsnivåer (Student, Standard, Premium) och historik.

    Utrustningshantering: Underhåll av fordon och campingutrustning (tält, ryggsäckar etc.) i inventory.

    Uthyrning och återlämning: Processera uthyrningar och återlämningar kopplade till specifika medlemmar med löpande historikloggning.

    Prisstrategier: Prisberäkning anpassad efter medlemsnivåer via implementerade PricePolicy-strategier.

    Användarvänligt menygränssnitt: Menysystem med färgkodade utskrifter för ökad tydlighet och enkel navigering.

    Felhantering: Robust skydd mot ogiltig input och logiska fel för stabil användarupplevelse.

    Intäktsrapportering: Summering av intäkter från uthyrningar via användargränssnittet.

Teknisk Arkitektur

    Objektorienterad design med tydliga klasser för domänmodeller (Member, Item, Vehicle, Gear, Rental).

    Användning av designmönster som singleton för delade resurser (Inventory, MemberRegistry) och strategi för prisberäkning (PricePolicy interface och dess implementationer).

    Java Collections framework (Listor och Maps) för lagring av inventarielistor och medlemshantering.

    Separation av affärslogik (RentalService, MembershipService) från UI och datahantering.

    Konsolbaserad inmatnings- och utskriftshantering med Scanner och ANSI-färgkodning för feedback.

Komma igång
Förutsättningar

    Java JDK installerat (version 8 eller senare rekommenderas)

    Terminal/kommandoradsmiljö


Användning

    Logga in med användarnamn och lösenord (lösenord för test är 0000).

    Navigera i menysystemet för att hantera medlemmar, inventory, hyra ut och återlämna utrustning.

    Följ instruktionerna som visas i konsolen för att utföra valda operationer.