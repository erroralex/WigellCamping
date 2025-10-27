```
░  ░░░░  ░░        ░░░      ░░░        ░░  ░░░░░░░░  ░░░░░░░░░░░░░░░      ░░░░      ░░░  ░░░░  ░░       ░░░        ░░   ░░░  ░░░      ░░
▒  ▒  ▒  ▒▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒   ▒▒   ▒▒  ▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒    ▒▒  ▒▒  ▒▒▒▒▒▒▒
▓        ▓▓▓▓▓  ▓▓▓▓▓  ▓▓▓   ▓▓      ▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓  ▓▓        ▓▓       ▓▓▓▓▓▓  ▓▓▓▓▓  ▓  ▓  ▓▓  ▓▓▓   ▓
█   ██   █████  █████  ████  ██  ████████  ████████  ██████████████  ████  ██        ██  █  █  ██  ███████████  █████  ██    ██  ████  █
█  ████  ██        ███      ███        ██        ██        █████████      ███  ████  ██  ████  ██  ████████        ██  ███   ███      ██
```

Inlämningsuppgift objektorienterad programmering:

Bakgrund:
Du har fått en provanställning på Wigellkoncernen och som första uppdrag ska du bygga
en konsolbaserad Java-applikation som modellerar en medlemsklubb med uthyrning av
utrustning. (t.ex. fordon, verktyg, sportprylar eller liknande)
Tekniska krav

Klasser som ska finnas i applikationen:
• Member (id, namn, status/level, historik)
• Item (abstract)  Subklasser som ex. Vehicle, Tool, SportGear eller liknandeberoende på ditt val av applikation. 
Var och en av klasserna ska innehålla sina unika attribut och metoder enligt det vi pratat om.
• Rental (kopplar member och item för en viss tidsperiod)
• PricePolicy (interface) + konkreta strategier, ex. standard, student, premium.
• Inventory och MemberRegistry (hanteras i minnet via List, Map eller Set)
• RentalService och MembershipService ska innehålla affärslogiken
• Konsolmeny: lägg till/sök/ändra medlemmar. Lista/filtrera items. Boka/avsluta uthyrning. Summera intäkter


Bedömningskriterier

G
Körbar applikation som körs tills användaren väljer att avsluta
Korrekt uppförda klasser samt användande av objekt och metoder
Item som basklass + minst två konkreta subklasser. PricePolicy som interface + minst
två implementationer
Privata attribut samt nödvändiga getters/setters. Enkel ansvarsdelning mellan
klasser/logik samt huvudprogrammet
Collections ska användas där det är lämpligt
Mindre kompletteringar får förekomma

VG
Samtliga krav på G är uppfyllda. Dessutom finns en robust felhantering på metoder där
så är lämpligt. Det finns även en hög kodkvalitet med väl namngivna klasser och
metoder. Uppgiften ska lämnas in innan deadline. Mindre kompletteringar får
förekomma


Planerade uppgifter:

~~□ Skapa Member-klass~~

~~□ Skapa Item abstrakt basklass~~

~~□ Skapa minst två konkreta subklasser av Item~~

~~□ Skapa Rental-klass~~

~~□ Skapa PricePolicy interface~~

~~□ Implementera minst två prisstrategier~~

~~□ Skapa Inventory-klass~~

~~□ Skapa MemberRegistry-klass~~

~~□ Skapa RentalService~~

~~□ Skapa MembershipService~~

□ Implementera konsolmeny - lägg till/sök/ändra medlemmar

□ Implementera konsolmeny - lista/filtrera items

~~□ Implementera konsolmeny - boka uthyrning~~

~~□ Implementera konsolmeny - avsluta uthyrning~~

□ Implementera konsolmeny - summera intäkter

~~□ Använd privata attribut med getters/setters~~

□ Säkerställ ansvarsdelning mellan klasser och huvudprogram

~~□ Använd Collections där lämpligt~~

□ Säkerställ att applikationen körs tills användaren avslutar

□ Testa att allt fungerar korrekt

□ Mindre kompletteringar får förekomma


□ -----Extra för VG-----

□ Implementera robust felhantering

□ Säkerställ hög kodkvalitet med välnamngivna klasser och metoder

□ Lämna in innan deadline

□ Mindre kompletteringar får förekomma
