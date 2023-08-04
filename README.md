Test task for Deutsche Bank
Endpoints: POST: localhost:8080/signal - takes int value and executes code according to it.

The solution bases on Signal registry - it serves as a catalogued view of our signals and allows for an 
easy to maintain and use solution, but might require work separating it in the future, 
if it grows too large, or, especially if, separate signal categories are introduced.

Application can be launched with "mvn spring-boot:run" command.