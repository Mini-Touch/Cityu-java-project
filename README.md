================================================================================
                    RPG CONSOLE ENGINE - README
================================================================================

1. PREREQUISITES
--------------------------------------------------------------------------------
- Java Development Kit (JDK) 11 or higher installed on your system.
- A terminal or command prompt.

2. HOW TO COMPILE
--------------------------------------------------------------------------------
Before running the program, you must compile the Java source files. 
Navigate to the root directory of the project (where the packages 'core', 
'entity', 'Item', and 'mechanics' are located) and run:

    javac Main.java

(Note: The compiler will automatically detect and compile all dependent classes 
in the sub-folders.)

3. HOW TO RUN
--------------------------------------------------------------------------------
After successful compilation, start the game by executing the Main class:

    java Main

4. GAMEPLAY CONTROLS
--------------------------------------------------------------------------------
The game is text-based and uses numeric input:
- Character Selection: Enter '1' for Warrior or '2' for Mage.
- Combat Actions:
    1: Physical Attack (Ends Turn)
    2: Open Backpack (Does NOT end turn)
    3: Rest/Restore (Ends Turn)
- Inventory Management:
    Select the number corresponding to an item to Use (Potion) or Equip (Weapon).
    Enter '0' to return to the combat menu.

5. TROUBLESHOOTING
--------------------------------------------------------------------------------
- "javac is not recognized": Ensure your Java bin folder is added to the 
  System PATH environment variable.
- "Error: Could not find or load main class Main": Ensure you are running the 
  command from the root directory and that Main.class was generated.

================================================================================
                         HAPPY ADVENTURING!
================================================================================
