# funds-application

 Aplikacja napisana na potrzeby procesu rekrutacyjnego.
 
 Strategie podziału implementujące Interfejs Strategy są parametrem konstruktora bazowej klasy FundsApplication.
 Klasa FundsManager wywołuje poszczególne komponenty (rozdział i przydzielanie kwot, kalkulacja procentów, kalkulacja reszty i formatowanie wyniku.
 
 Odpowiedzialności rodzieliłem na wyspecjalizowane klasy, ułatwiając szybkie dopasowanie do wymagań (np sposób zaokrąglania i formatowania wartości procentowych).
 
 Zdecydowałem zwracać wynik w postaci jednego obiektu zawierającego wszystkie dane przedstawione w tabeli wyników na karcie zadania (oprócz liczby początkowej). 
 
 Do wstrzykiwania zależności użyłem Dagger 2.



