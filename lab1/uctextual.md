# Caso d'Uso: LOGIN
## Breve Descrizione: 
Permesso di accesso al servizio non solo come utenti visitatori del sito 
## Attori primari: 
- Utente Registrato
- Utente Premium
## Attori secondari: 
Nessuno
## Precondizioni: 
- Trovarsi nella pagina web di StreamEveryThing
- Essere utenti registrati, eventualmente premium 
## Sequenza degli eventi principale:
1. L'utente apre la pagina web StreamEveryThing 
2. L'utente clicca sull'icona di login
3. L'utente inserisce i dati d'accesso  
    3.1 L'utente inserisce username dove richiesto  
    3.2 L'utente inserisce password dove richiesto
4. L'utente preme invio per confermare l'accesso
5. Verifica che le credenziali siano state accettate
## Postcondizioni: 
- Possibilità di visualizzare film/serie TV  
- Possibilità di visualizzare film/serie TV premium solo se si è un utente premium
- Possibilità di effettuare il download dei contenuti solo se si è un utente premium
## Sequenza degli eventi alternativa:
- Se l'utente non è ancora registrato, clicca il link apposito che lo porta alla pagina di registrazione
- Se l'utente decide di effettuare il login con Google, clicca il tasto apposta è si apre la finestra per il login con Google
- Se l'utente decide di effettuare il login con Facebook, clicca il tasto apposta è si apre la finestra per il login con Facebook


# Caso d'Uso 2: RICERCA NEL CATALOGO
## Breve Descrizione:  
Possibilità di ricercare film/serie TV per titolo, regista, attori e tramite diversi filtri
## Attori primari: 
- Tutti gli utenti
## Attori secondari: 
Nessuno
## Precondizioni:
Trovarsi nella pagina web di StreamEveryThing
## Sequenza degli eventi principale:
1. L'utente apre la pagina web StreamEveryThing 
2. L'utente clicca sull'icona di ricerca
3. L'utente digita Titolo/Regista/Attori del film/serie TV che sta cercando
4. L'utente, se necessario, filtra e/o ordina i risultati in base a data di uscita/titolo
## Postcondizioni:
- La pagina mostra i risultati basandosi sui dati inseriti dall'utente
- Possibilità di modificare i filtri/l'ordine
- Possibilità di effettuare una nuova ricerca
## Sequenza degli eventi alternativa:
Nessuna