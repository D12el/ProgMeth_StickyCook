# PROGMETH_STICKYCOOK
This STICKYCOOK game project was developed under a Programming Methodology course, utilizing the Java language, strong Object-Oriented Programming (OOP) principles and the JavaFX library for Java graphical user interface.

# How to Run the Game
The project includes an executable JAR file and the complete source code. The easiest way to run the game is using the compiled JAR.

Running the JAR File (Recommended)

The .jar file is the compiled, runnable version of the game.

1. Install Java: Ensure you have the Java Runtime Environment (JRE) (version 21 is typically recommended) installed on your system.
https://jdk.java.net/java-se-ri/21

2. Install JavaSDK for JavaFX lib: Ensure you have the JavaSDK (version 21 is typically recommended) installed on your system.
https://gluonhq.com/products/javafx/

3. Open your Command Prompt (CMD) or Terminal.

4. Navigate to the directory containing the JAR file.

5. Execute the following command:

Bash

- java --module-path "path_of_javaFX_sdk_lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media -jar StickyCooked.jar

# Document

You can find detailed project information and the full project structure in STICKY_COOK.pdf.

# Technology and Concepts

1. Programming Methodology and OOP Principles

- The code structure is meticulously organized to adhere to core OOP concepts, ensuring high maintainability and ease of future expansion:

- Encapsulation: Data security is prioritized, with internal class data protected and its access controlled strictly through public methods, commonly known as Getters and Setters.

- Abstraction: The design utilizes dedicated packages (such as logic, drawing, and input) to clearly separate different concerns and functionalities within the game system, presenting a clean interface to other parts of the program.

- Inheritance & Polymorphism: These principles are presumed to be used to efficiently define hierarchies for various game objects (e.g., ingredients, tools, characters). This allows diverse objects to share common traits while implementing specific behaviors unique to their type.

2. Core Java Libraries

- The game relies on the standard Java platform (JSE) and incorporates key libraries necessary for modern game development:

- Standard Java Library (JSE): This forms the foundation of the project, utilized for fundamental programming needs, including complex data structures, basic input/output (I/O) operations, and various utility functions.

- Graphics/UI Library: The game interface requires a robust graphics solution. The interface is likely built using one of Java's powerful built-in graphics libraries, such as Swing or JavaFX, which handle the complex tasks of creating the game window, rendering the canvas, and managing drawing operations.
