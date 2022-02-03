# Launch Interceptor
A project repository for the first assignment for the course [DD2480 Software Engineering Fundamentals](https://www.kth.se/student/kurser/kurs/DD2480) at [KTH](https://www.kth.se/) (group 27, Spring semester 2022).
# Description
This [Java](https://www.java.com/fr/) program simulates an anti-ballistic missile system. It will decide whether an interceptor should be launched based upon radar tracking information and inferred Launch Interceptor Conditions (LICs).

Given these input information:
- **NUMPOINTS** The number of *planar data points* as an integer
- **X-COORDINATES** The x-coordinates of the points as an array of double
- **Y-COORDINATES** The y-coordinates of the points as an array of double
- **PARAMETERS** Parameters for LICs as an object [Parameter](src/main/java/assignment_1/Parameter.java)
- **LCM** Logical Connector Matrix as a [Connectors](src/main/java/assignment_1/Decide.java) matrix
- **PUV** Preliminary Unlocking Vector as an array of boolean

The method ```decideLaunch()``` in class [Decide](src/main/java/assignment_1/Decide.java) determines the launch decision, where the returned boolean value means *YES* if evaluated to ```true``` or *NO* if evaluated to ```false```.

The project is designed using [Maven](https://maven.apache.org/), the code is written in [Java](https://www.java.com/fr/) and the program is tested using [JUnit](https://junit.org/junit5/).

# Usage
## Installation
First of all, you will need [Java](https://www.java.com/fr/), see [this link](https://www.java.com/fr/download/manual.jsp) to install it. Then you will need to install [Maven](https://maven.apache.org/), check [this link](https://maven.apache.org/download.cgi). Finally you can clone the repository using the following command:

```git clone https://github.com/PersonligaPersson/DD2480_Group_27.git```

You can test the installation by running all the test using the following command:

```mvn test```

## Run
Firstly, you need to enter all the input parameters in the main function located in class [Decide](src/main/java/assignment_1/Decide.java). Then you can run the program using the command:

```mvn clean compile exec:java```

# Contributions

The workload was split evenly among the group members such that each group member was responsible for 4-6 functions of the program. The group also had (almost) daily meetings to make sure that the work ran smoothly for everyone. In addition to the assigned tasks, all group members contributed to the creation of issues and the reviewing of pull requests.

Amanda Strömdahl wrote the document describing our [way of working](Essence.pdf) and Bastien Faivre wrote this README.

## Contributors
- Arvid Gotthard (<gotthard@kth.se>)
- Max Persson (<maxper@kth.se>)
- Amanda Strömdahl (<astromd@kth.se>)
- Bastien Faivre (<faivre@kth.se>)
