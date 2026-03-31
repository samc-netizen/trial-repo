<div align="center">

# Library Management System
### Java-Based Console Application

![Java](https://img.shields.io/badge/Language-Java-blue?style=for-the-badge&logo=java&logoColor=white)
![Platform](https://img.shields.io/badge/Platform-Console-lightgrey?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)

---

| Author | University | Course |
|--------|------------|--------|
| Sumit Kumar Chandwani | VIT Bhopal University | Programming in Java |

</div>

---

## About This Project

This project is a Java-based Library Management System designed to automate common library operations such as adding books, searching, issuing, and returning books. 

The system replaces manual record-keeping with a structured, file-based approach, improving efficiency, accuracy, and usability.

---

## Problem Statement

Manual library management systems are inefficient, prone to errors, and difficult to maintain. Tracking issued books and calculating fines manually can lead to inconsistencies and data loss.

---

## Proposed Solution

This project provides a console-based application that allows users to:
- Add new books
- Search for books using flexible matching
- Issue and return books
- Calculate fines for late returns
- Store and retrieve data using file handling

---

## Key Features

- Book addition and storage  
- Case-insensitive and partial search functionality  
- Book issuing system with availability tracking  
- Return system with fine calculation  
- Persistent data storage using file handling  
- Menu-driven user interface  

---

## Project Structure

```

Library-Management-System/
│
├── LibraryManagementSystem.java   → Main application code
├── books.txt                      → Data storage file
└── README.md                      → Project documentation

```

---

## System Design

### Classes Used
- `Book` → Stores book details  
- `Library` → Handles all operations  
- `LibraryInterface` → Defines core methods  

### Flow of Execution

```

User Input → Menu Selection → Operation Execution → File Update → Output Display

```

---

## Technologies Used

- Java Programming Language  
- Object-Oriented Programming (OOP)  
- File Handling  
- Exception Handling  

---

## How to Run

### Step 1: Compile the program
```

javac LibraryManagementSystem.java

```

### Step 2: Run the program
```

java LibraryManagementSystem

```

---

## Sample Usage

```

1 → Add Book
2 → Search Book
3 → Issue Book
4 → Return Book
5 → Display Books
6 → Exit

```

---

## Improvements in Search Functionality

The search feature has been enhanced to:
- Ignore case differences
- Handle extra spaces
- Support partial matching using `contains()`

This ensures better usability and accuracy in locating books.

---

## Challenges Faced

- Managing file input and output correctly  
- Ensuring data persistence across executions  
- Handling user input errors  
- Implementing efficient search logic  

---

## Learning Outcomes

- Practical understanding of object-oriented programming  
- Implementation of interfaces and modular design  
- Use of file handling for persistent storage  
- Handling exceptions in real-world applications  

---

## Future Enhancements

- Graphical User Interface (GUI) using JavaFX  
- Database integration (MySQL)  
- User authentication system  
- Due date tracking with automatic fine calculation  

---

## Conclusion

The Library Management System demonstrates how Java can be effectively used to build real-world applications. It improves efficiency, reduces manual effort, and provides a scalable foundation for further enhancements.

---

<div align="center">

Developed as part of academic coursework  
VIT Bhopal University

</div>
