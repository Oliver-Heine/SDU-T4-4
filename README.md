# SDU-T4-4
Repository for 1. semesterprojekt - Gruppe T4-4¨

For at køre vores spil så skal du have installeret følgende:
---------------------------------------
* JavaFX 
* Java 11
* IntelliJ 
---------------------------------------

For at køre spillet vha. IDE'et så skal du konfigurerer følgende:
1. Markere mappen "resources" som en resource folder. Dette kan gøres i IntelliJ ved at gå under File->Project Structure->Modules->Sources *klik på mappen der hedder resources og mark as resources*   
2. Tilføj dit javafx library til dit IDE. Dette gøres i Project Structure i IntelliJ under libraries. Det kan gøres ved + ikonet, her skal du derefter klikke java og finde lib mappen som er inde i dit installeret javafx. Klik Apply og OK.
3. Tilføj VM options. Dette gøres ved Edit Configurations boksen, som er til venstre for run. Inde i det vindue skal du under "VM options" tilføje følgende:
--module-path tilføj/din/path/til/lib/mappen/i/dit/installeret/javafx --add-modules javafx.controls,javafx.fxml,javafx.media 

Nu er spillet klar til at køre!

Det eneste du mangler nu er at klikke run!
