```
░  ░░░░  ░░        ░░░      ░░░        ░░  ░░░░░░░░  ░░░░░░░░░░░░░░░      ░░░░      ░░░  ░░░░  ░░       ░░░        ░░   ░░░  ░░░      ░░
▒  ▒  ▒  ▒▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒   ▒▒   ▒▒  ▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒    ▒▒  ▒▒  ▒▒▒▒▒▒▒
▓        ▓▓▓▓▓  ▓▓▓▓▓  ▓▓▓   ▓▓      ▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓  ▓▓        ▓▓       ▓▓▓▓▓▓  ▓▓▓▓▓  ▓  ▓  ▓▓  ▓▓▓   ▓
█   ██   █████  █████  ████  ██  ████████  ████████  ██████████████  ████  ██        ██  █  █  ██  ███████████  █████  ██    ██  ████  █
█  ████  ██        ███      ███        ██        ██        █████████      ███  ████  ██  ████  ██  ████████        ██  ███   ███      ██
```

# Wigell Camping Medlemsklubb och Uthyrningssystem

## Om Projektet

Wigell Camping är en konsolbaserad Java-applikation som modellerar en medlemsklubb för uthyrning av utrustning som fordon och campingutrustning. Applikationen är designad för att hantera medlemmar och uthyrningsobjekt på ett strukturerat och användarvänligt sätt.

## Teknisk Översikt

Applikationen är uppbyggd kring följande kärnklasser:

- **Member:** Representerar en medlem med unikt ID, namn, medlemsnivå (Student, Standard, Premium) och uthyrningshistorik.
- **Item (abstrakt klass):** Basklass för uthyrningsobjekt med underklasser som `Vehicle` (fordon) och `Gear` (utrustning).
- **Rental:** Kopplar en member till ett item under en specifik uthyrningsperiod.
- **PricePolicy (interface):** Definierar prisberäkningar med konkreta strategier som standard-, student- och premium-priser som reflekterar rabattstrukturer.
- **Inventory:** Hanterar tillgängliga fordon och utrustning i programminnet via listor.
- **MemberRegistry:** Ger samlad hantering av medlemslistan, med metoder för skapande, redigering, borttagning och sökning.
- **RentalService och MembershipService:** Innehåller affärslogik för uthyrningsprocesser, prisberäkningar och medlemsnivåhantering.
- **Konsolmeny:** Komplett menystruktur som inkluderar att lägga till, ändra, söka och ta bort medlemmar, visa, sortera och hantera inventory, utföra uthyrning och återlämning, samt summera intäkter.

## Uppfyllande av Inlämningsuppgiften

Applikationen bör uppfylla samtliga tekniska krav och bedömningskriterier i uppgiften:

- Körbar och användarinteraktiv konsolprogramvara som körs tills användaren väljer avsluta.
- Omfattande objektorienterad design med korrekt kapsling (`private` attribut och tillhörande `getters`/`setters`).
- Abstrakt basklass `Item` med minst två konkreta underklasser `Vehicle` och `Gear`.
- Implementerat `PricePolicy` interface med minst tre strategier (`StandardPricing`, `StudentPricing`, `PremiumPricing`).
- Effektiv användning av Java Collections (Listor, Maps) för att hantera medlemsregister och inventory.
- Robust felhantering för inmatningsfel och logiska fel i menyval och operationer.
- Tydliga och användarvänliga menygränssnitt med färgkodade utskrifter.
- Funktionalitet för att lägga till, redigera och ta bort medlemmar, inklusive validerat medlemsnivåval.
- Funktionalitet för hantering av fordon och utrustning med möjlighet att lägga till och ta bort inventory-objekt.
- Uthyrning och återlämning kopplade till specifika medlemmar med historikloggning.
- Prisberäkning baserad på medlemsnivå och uthyrningsperiod.
- Summering av intäkter från uthyrning presenterad i användargränssnittet.

## Installation och Körning

Programmet kräver Java 8 eller senare. För att köra applikationen:

1. Klona repot.
2. Kompilera koden med `javac`.
3. Starta programmet via `java Main` i terminalen.
4. Följ instruktionerna i den interaktiva konsolmenyn.

## Användning

Navigera i menyn för att:

- Logga in (enkel autentisering för demonstrativa ändamål).
- Hantera medlemmar (lägg till, redigera, ta bort).
- Visa och hantera inventory för fordon och utrustning.
- Utföra uthyrningar och återlämningar.
- Visa uthyrningshistorik.
- Summera och visa intäkter.

## Sammanfattning

Detta projekt speglar förhoppningsvis en fullständig och väldesignad lösning som är anpassad för kursuppgiften i objektorienterad programmering. Det bör demonstrera god användning av designprinciper, felhantering, användarvänlighet och bör uppfylla alla tekniska och kvalitetskrav för Godkänd (G) och Väl Godkänd (VG) betygsnivåer enligt uppgiftens specifikationer.

***
