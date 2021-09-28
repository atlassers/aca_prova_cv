# Academy-cloud

#### Http Server
##### Installazione
* Installare [Node js](https://nodejs.org/it/download)
* Andare nella cartella del progetto (in questo caso **<path>/academy-cloud/html**)
* Eseguire il comando `npm install http-server`
 </br>Questo comando creerà una cartella node_modules all'interno del progetto
* Eseguire il comando `http-server -a localhost -p 8000 -c-1`
 </br>Questo comando farà partire il live server, che risolverà il problema del CORS.
 </br>Se non funziona, scrivere `npx http-server -a localhost -p 8000 -c-1`
* A questo punto, nel browser basterà andare al link [http://localhost:8000](http://localhost:8000)

#### Dashboard (esempio)
https://support-cdn.route4me.com/2020/04/43674186-21144-1.png