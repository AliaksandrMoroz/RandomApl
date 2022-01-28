# Random application
## Introduction
This application was developed by Team No. 12
Developers: Alexander Moroz, Vasily Shelkov, Viktor Sazhin, Yaroslav Detsky.
Random application is a program with which you can add participants to the list, generate and receive random questioners and responders, set scores and display a general list.

## Run your JavaFX app via IntelliJ  
1. Run your DataBaseConnection and set your url, user and password of your DB Server in pom.xml file.
```Java  
<configuration>
   <driver>com.mysql.cj.jdbc.Driver</driver>
   <url>jdbc:mysql://localhost:3306/sys</url>
   <user>root</user>
   <password>root</password>
   ...
<configuration>
   ```
3. Click **[Maven]** -> **[clean]** -> **[install]**  
4. Click **[Maven]** -> **[Plugins]** -> **[javafx]** -> **[javafx:run]**
5. Or use this command in Terminal
```shell
mvn clean install javafx:run
```
You will see this window if you do all these steps correctly.
![Main Menu](D:\RandomApl\screens\MainMenu.PNG)

## Add students
You can add student in this pole. You should set Lastname, Name and number of team.
![Add student](D:\RandomApl\screens\AddStudent.PNG)
1. Open icon Add student
2. Choose pole
3. Write in this pole Lastname, name and team of student
4. Press button Add Student

If you want to add more students - repeat all this steps again.
5. Press Return to move in Main Menu

## Delete Student
You can delete student
![Delete student](D:\RandomApl\screens\DeleteStudent.PNG)
1. Open icon Delete student
2. Choose pole
3. Write in this pole Lastname and name
4. Press button Delete Student

If you want to delete more students - repeat all this steps again.
5. Press Return to move in Main Menu

## Set student
In this, you can change Lastname, name and team in student if you write incurred date.
![Set Student](D:\RandomApl\screens\SetStudent.PNG)
1. Open icon Set Student
2. Choose first pole
3. Write in this pole Lastname, name and team
4. Choose second pole
5. Write in this pole new Lastname, name and team of student
6. Press Save Student button

If you want to set another student in your database - repeat all this steps again.
7. Press Return to move in Main Menu

##Show all student
In this, you can see table students
![Show all Student](D:\RandomApl\screens\ShowStudent.PNG)

In this table you can see all students. In column Question you can see ball of student. And in column Answer and Bonus mark too.
If you see in this column "x" it's means that this student don't ask or answer.
Press Return to move in Main Menu

## Clear Marks
In this you can clean all marks in table students.
If you press a button "ClearMarks" you can see this massage.
![ClearMarks](D:\RandomApl\screens\ClearMarks.PNG)

## Random students
In this you can see main function of our application. You can have random student who ask question and who answer in this question.
![Random student](D:\RandomApl\screens\RandomStudent.PNG)
In this icon you can see a pole who ask and who answers. 
If turn on in flag "Good Question" is a student ask a good question and in his column press "1" ball in Question.
If turn on in flag "Good Answer" it's mean that student who answer a question we set "1" ball in column Answer of this student.
If you turn on in flag "Bonus Mark" it's mean that we add a bonus "1" ball to column "Bonus mark" of this student.
And if you turn off in any flag it's mean that we set "0" in any column of students what you choose.
**RUN RANDOM**
1. Press button Start
2. Choose flag "Good ..." if a student ask/answer good question or not. Do how are mean.
3. Press button Next
4. Repeat step 2.

And when all student ask or answer press Return to move in Main Menu.

##Stack
In this project we use:
* JavaFx 17.0.2
* JDK 11
* Maven
* MySQL
* FlyWay to connect and create a table in db
