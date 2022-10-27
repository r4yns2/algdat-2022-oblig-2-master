# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Eirik Jørgensen, s358857, s358857@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å lage en metode for å finne antallet verdier i en liste. Dette gjøres ved å sette en markør ved hode peker og telle antall noder helt til siste hale peker som viser null. 
I tilegg har jeg laget metoden for å se om en liste er tom. Dette vises ved å se om hode er lik hale, som vil være null. Samtidig se på antallet, om det er 0.  
Har også laget en metode som lager en liste ved bruk av inn variabelen. 

I oppgave 2 så har jeg laget en tostring metode og en omvendtString metode. Disse oppretter og sender en string i retur med listen i ascending order eller descending order. 
Legg inn metoden er også opprettet, her setter metoden en verdi inn i listen. Dette gjelder da på slutten av listen. 

Oppgave 3 
Her har jeg laget mange metoder. FinnNode metoden går gjennom listen og finner verdien til noden som blir sendt inn. Hent metoden gjør det samme som finnnode metoden, bare med indekskontroll. Oppdater metoden trekker ut verdien til en node og erstatter den med ny verdi. Her laget jeg en egen metode siden det ikke fantes fra før. 
Sublisten jeg har laget oppretter en ny liste hvor du kan lete etter verdier ved bruk av fra - til kontroll. Det er mulig å finne verdier basert på intervallet. 

Oppgave 4 
Metoden indeksTil returnerer posisjonen til den verdien som blir sendt inn. Den leter gjennom listen og returnerer enten indeksen til verdien eller -1 hvis det ikke finnes. Metoden inneholder returnerer bare true eller false om en verdi finnes i listen. 

Oppgave 5
Dette var en litt vanskelig oppgave som kreve bye betenkning. Først ser vi etter null verdier, Deretter ser om listen er tom, samt om tallet skal ha indeks 0. Skal tallet legges bakerst oppdaterer vi bare hale peker og forrige/neste pekere. Hvis verdien skal midt i listen må vi oppdatere alle pekere frem og tilbake til alle noder. 

Oppgave 6
Her har jeg også opprettet en egen metode for lettere bruk og oversiktlighet. FjernNode ser etter om noden som skal fjernes ligger først og om listen har 1 verdi. Det samme om verdien som er til slutt skal fjernes. Det var også litt vanskelig å kode disse da en må ha tunga rett i munn når det kommer til alle pekere som skal oppdateres. 

Oppgave 8
Her har jeg kodet konstruktør og fått iteratoren til å returnere en instans av dobbeltlenketlisteiterator. 
Next metoden fungerer slik at den samler på verdien til "denne" i en temp variabel ettersom du ikke kan returnere en verdi og deretter kjøre metoden videre etter return statement. Etter verdien er lagret flyttes "denne" pekeren til neste node. Denne metoden sjekker også om det finnes flere elementer i listen ved bruk av hasNext og om endringer samsvarer med iteratorendringer. 
Vil gjerne legge til at denne oppgaven ikke fullfører test grunnet at nullstill() metoden i oppgave 7 har noen tester liggende i oppgave 8 testene. 
Dette gjør at min test feiler ettersom jeg ikke har kodet nullstill(). 