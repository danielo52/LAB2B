
                                    ****** Inforamtion kring projektet *****
Att göra:
Städa upp kod:
    - Ta bort onödiga klasser/interfaces (oklart om sådana finns men dubbelkolla)
    - Ta bort onödiga variabler och metoder (d.v.s. sådant som inte används)
    - Sätt constructors i Volvo/Saab/Scania till protected (för att "förbättra" vårt Factory Pattern
    -




                    *** Things that could've/should've been Implemented in the Code but weren't ***

Note: these suggested changes were not implemented in the actual code due to: we came up with a better
solution after already implemented the current solution. We then had a limited amount of time, and had to
prioritize other things to change/implement in the code. (Might go without saying, but we'll mention it just in case.
A lot of these ideas (suggested changes) were thought of after we've already continued with the Assignments, and therefore
we did not take the time to go back to prior Assignments and make changes).

                                    *** These suggested changes include ***

--> The bed and turbo situation could have been simplified (read: improved) by using a Strategy Pattern
    (ex: interface: ITurbo, classes: hasTurbo & noTurbo implements ITurbo.
            LandVehicle: instance variable ITurbo turbo;
            Saab (parent): ITurbo turbo = new hasTurbo(); Volvo/Scania(parent): ITurbo turbo = new noTurbo();

-->

