## How to run the program

1. Ensure you have Java and Gradle installed on your system. I am using JDK11 with gradle 8. If using IntelliJ IDEA you
   can import .idea file directly from project root, and it will automatically set up project for you
2. Navigate to the project directory. Make sure to change file paths using FilePaths class inside \src\main
   Also input files are present under \src\resources
3. Build the project using Gradle:
   ```sh
   gradle build
   ```
   
   Run project using
   ```
   gradle run
   ```
   
   Test using
   ```
   gradle test
   ```
4. Make sure to compile all the classes other than Run main file Main.java
5. You can directly run using run icon if using IntelliJ IDEA

## Assumptions

1. Even mentioned in the assignment that predefined words does not contain duplicates. I am using a HashSet to make the
   code more robust and prone to errors or duplicate words
2. Since we want matches to be case-insensitive, converting all words to lowercase
3. Predefined words cannot be empty or have spaces so trimmed them
4. Ignoring a word from predefined words file if a match is not found.
   eg - if 'detect' is not found in input file (it's count is 0), I am not including it in the end result to print it as
   0 (ignoring all such 0 values)
5. Assuming the words to match are only letters, numbers, underscores (matching all ascii chars apart from these and
   splitting them to get words)
6. While printing purposefully did not use 256 char gap (max predefined word length is 256) as it looks ugly


## What has been tested
1. The program reads the predefined words from a file.
2. The program reads the input text file and counts the occurrences of each predefined word.
3. The match is case-insensitive and does not count substrings.
4. JUnit tests have been added to verify the functionality of the predefined words loading and match counting.

Additional tests include:
1. Loading predefined words.
2. Counting matches in the input file.
3. Handling empty predefined words.
4. Handling empty input files.
5. Case insensitivity.
6. No matches found.
7. Match count with duplicate words.
8. Handling special characters.
9. Handling maximum word length.
10. Handling words exceeding the maximum length.


## Tests

predefined_words.txt

   ```sh
   name
   detect
   ai
   ```

input.txt

```sh
Detecting first names is tricky to do even with AI.
How do you say a street name is not a first name?
```

case-insensitive input

```sh
Detecting FIRST NAMES is tricky to do even with AI.
How do you say a STREET NAME is not a FIRST NAME?
```

special chars input

```sh
Detecting first names is tricky to do, even with AI!
How do you say a street-name is not a first-name?
```

max word length input

```sh
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
```
