                                                      A small Text Editor
The Small Text Editor is a simple editor. It opens, saves, closes, and deletes the files. 
How to run this Application
1.	Download and open the solution in IntelliJ or any other IDE
2.	Let all the packages installed
3.	Run the Program from Main found in src/TextEditor/Main.java


Technical Implementation Details


The JavaFX library and the FXML templating syntax are both used. The templates are kept in the /src directory. There is one TextEditor.fxml file that contains the majority of the template code. Custom CSS is used to style the template in the src directory.
This application follows the MVC design pattern. When the user runs the application, it will open a text window with a menu bar that includes the options file, Edit, Format, and about. Users may create new files and save them from the file menu. In the file menu, users may also open saved text files.
 

![image](https://user-images.githubusercontent.com/105322671/167732726-44441bf4-391e-42dc-94de-b6f69d831b33.png)


Main Class: The main class is found in /src/TextEditor/Main.java
