## How to run the program

1. Ensure you have Java and Gradle installed on your system. I am using JDK11 with gradle 8. If using IntelliJ IDEA you
   can import .idea file directly from project root, and it will automatically set up project for you
2. Navigate to the project directory.
3. Build the project using Gradle:
   ```sh
   gradle build

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
