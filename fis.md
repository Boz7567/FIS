

# Caso d'Uso: Registrazione Utente 

## Breve Descrizione:  
L’utente effettua la registrazione alla piattaforma StreamEveryThing, L'utente puo scegliere il servizio gratuito o quello premium; quest'ultimo consente la visione completa del catalogo e il download dei contenuti.

## Attori primari:  
Utente (non registrato ) 

## Attori secondari:  
Sistema di pagamento (carta di credito o PayPal)  

## Precondizioni:  
L’utente non è ancora registrato al sistema e ha accesso al sito web di StreamEveryThing.  

## SCENARIO:  
1. L’utente seleziona “Registrati” nella home page.  
2. Il sistema mostra il modulo di registrazione.  
3. L’utente inserisce nome, cognome e indirizzo e-mail oppure accede tramite Google/Facebook.
4. Il sistema chiede di scegliere il tipo di servizio: gratuito o premium.  
5. L’utente seleziona “Premium”.  
6. Il sistema richiede il metodo di pagamento (carta o PayPal).  
7. L’utente inserisce i dati di pagamento.  
8. Il sistema verifica la validità dei dati e conferma la registrazione.  
9. L’utente riceve una mail di conferma.  

## Postcondizioni:  
L’utente risulta registrato come “Utente Premium” e può accedere a tutte le funzionalità della piattaforma.  

## Alternative possibili:  
- Nel punto 6: Se l’utente sceglie il servizio gratuito → il sistema completa la registrazione senza pagamento.  
- Nel punto 8: Se il pagamento fallisce → il sistema mostra un errore e chiede di riprovare.  

---

# Abbonamento Premium  

## Breve Descrizione:  
L’utente Premium visualizza un film o una serie TV disponibile nel catalogo completo.  

## Attori primari:  
Utente Premium  

## Attori secondari:  
Sistema di streaming  

## Precondizioni:  
L’utente è autenticato e ha un abbonamento Premium attivo.  

## Scenario:  
1. L’utente accede al proprio account.  
2. Il sistema mostra la home con il catalogo completo.  
3. L’utente seleziona un titolo.  
4. Il sistema mostra la scheda del titolo (descrizione, durata, pulsanti “Guarda ora” e “Download”).  
5. L’utente preme “Guarda ora”.  
6. Il sistema avvia lo streaming del contenuto scelto.  

## Postcondizioni:  
Il film/serie TV è visualizzato correttamente dall’utente Premium.  

## Scenari possibili (alternative):  
- Nel punto 5 L’utente seleziona “Download” → il sistema avvia il download del file.  
- Nel punto 6 Se la connessione è interrotta o c'è un problema durante il download→ il sistema mostra un messaggio d’errore.  
