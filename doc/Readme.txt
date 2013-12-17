DynamicProxy Pattern:

A Static Proxy wraps the target subject so that it can add functionalities for the client without 
changing the actual subject. Example: you use a remote proxy to 'call' web services.
However, this means that for each subject, you will need to create a Proxy class. Dynamic Proxy
gives you the ability to use Java reflection to be able to inspect the 'caller' and take actions
based on the method name or arguments passed. This enforces the AOP (Aspect-Oriented Programming)
paradigm because you can separate the cross-cutting concerns: e.g. business logic vs logging.

In this example, the main Interface is the Calculator and is implemented by CalculatorImpl.
Whenever a client calls the add method, we want to log that action. Adding and Logging are two
different concerns that should not be handled by the Calculator implementation. Using a LoggingProxy,
we can 'intercept' the client call to add, do the logging then pass the request thru to the subject
(which is the CalculatorImpl).

See the the uml.ucls for the UML diagram.
Run Main.java to see the example in action.