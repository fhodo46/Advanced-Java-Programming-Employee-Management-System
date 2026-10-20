This program is used to effectively store, arrange, and manage personnel data.

**Main components of the project**

**1) Splash class** - Shows a general view of how an employee management system looks like in terms of its entry, where the user (the administrator) is introduced with the application and what he/she anticipates before entering the application.

**2) Login class** - A login for the admin, where he has the possibility to log in with the username and password (these are prepared in the database and only he has access to the correct username and password from the database), and a button where he can log in the app

**3) Conn class** - Establishes the connection with the MySQL Workbench database with the aid of JDBC (Java Database Connectivity) and after connection the statement is used by application programs to dynamically prepare an SQL statement for execution MySQL Workbench will ask for a password before entering in. The MySQL Workbench will have the database name and the tables “login” (which has the admin’s data) and employee (which has the employee’s data), the part where the query can be written and the output part.

**4) Home class** - This class serves as the point where we can choose options to add, view, update, delete employees, and the user can logout if he wants.

**5) AddEmployee class** - Here the user will add an employee with the important details, such as the name (which should be unique each time the user adds one), surname, salary, phone number, date of birth, and education.
