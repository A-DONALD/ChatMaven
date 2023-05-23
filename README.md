# ChatMaven

<div align="left">

![Maven-Central](https://img.shields.io/badge/MavenCentral-3.9.1-success)
![Java](https://img.shields.io/badge/Java-17-red)

</div>

---

### What is the project goal ?

_with Java program_
we need to create a TCP server on your local machine and/or clients with a specified port.
This is the basic interaction with Sockets between server-clients using the Socket API of JAVA.

### How to use it ?

1. First of all, you have to **clone the repository** with the command
   ```
   git clone https://github.com/A-DONALD/ChatMaven.git
   ```

2. The next step is to **run the application**: you can execute the file _run.sh_

3. If the _run.sh_ doesn't work or if you want to execute in command line:

   - Build the project with the command
   ```
   mvn package
   ```
   
   - Execute the jar file: _1.1-SNAPSHOT represent project version_
   ```
   java -jar target/Chat-1.1-SNAPSHOT.jar
   ```

4. Then, you will have to choose what is this terminal for (Server or Client) by selecting the correct number.
5. Then select a port number, which is the port that will be used for the socket (Server or Client).

You can easily follow the instructions you can see on the terminal.


**Versions history:**

|      Version       |             Date            |         Java version         |     Apache Maven version    |
|--------------------|-----------------------------|------------------------------|-----------------------------|
| **1.1**            | 23/05/2023                  | Java 8                       | 3.9.1                       |

-----
