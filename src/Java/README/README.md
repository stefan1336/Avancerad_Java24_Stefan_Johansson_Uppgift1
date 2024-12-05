# Virtuell Biluthyrning

## Det här projektet ger användaren en möjlighet att hyra en bil i en virituell miljö

## Lite olika funktioner
- Man kan välja att hyra 3 olika typer av bilar
- Varje bilsort har ett visst antal specifika bilmodeller
- Varje bilsort har en specifik metod användaren kan välja på:
    - Som att lägga till något lyxigt när du åker Limousine, Ladda din elbil eller Sätta på taket på din Sportbil
- Se specifika detaljer angående din bil
- Få ett kvitto på ditt Köp
- Se en bild på din Bil i Consolen

## Installation
Klona repot i bash
git clone https://github.com/stefan1336/Avancerad_Java24_Stefan_Johansson_Uppgift1

## Arkitektur

- Main: Här körs programmet
- Vehicle: Abstract basklass för alla typer av bilar
- Convertible: Subklass för Convertible
- Electric: Subklass för Elbilar
- Limousine: Subklass för Limousiner
- Rentable: Interface för att definera kontraktet för de olika biltyperna
- Garage: Container för tillgängliga fordon
- VehicleController: Mellanhand mellan användare och olika bilmodeller
- User: Representerar användaren av systemet

