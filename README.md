# Java SE Learning Repository

A comprehensive Java SE learning repository containing practical examples, exercises, and implementations of core Java concepts. This project serves as a structured learning path for mastering Java Standard Edition fundamentals and advanced topics.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Module Structure](#module-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Learning Path](#learning-path)
- [Key Features](#key-features)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Project Overview

This repository is designed as a comprehensive learning resource for Java SE, organized into distinct modules that cover everything from basic syntax to advanced concepts like multithreading, I/O operations, and GUI development. Each module contains practical examples, exercises, and detailed implementations with extensive Chinese comments for better understanding.

## 📁 Module Structure

### A. Java Basics (`A-java-basics/`)
**Foundation module covering core Java concepts**

#### Basic Tutorial (`tutorial/`)
- **Data Types & Operations**: Type conversion, casting, operators
- **Control Structures**: Conditional statements, loops, switch statements
- **Object-Oriented Programming**: Classes, objects, encapsulation, inheritance, polymorphism
- **Exception Handling**: Try-catch blocks, custom exceptions, error management
- **Collections Framework**: Lists, Maps, Sets, Stream API
- **Concurrency**: Basic multithreading, thread safety, Runnable interface
- **Advanced Features**: Enums, lambda expressions, functional interfaces

#### Advanced Tutorial (`tutorialAdvanced/`)
- **Advanced OOP**: Static/this keywords, inheritance patterns, polymorphism
- **Interface Design**: Interface implementation, adapter patterns
- **Inner Classes**: Member classes, anonymous classes
- **API Usage**: Built-in Java APIs and utilities
- **Collections Deep Dive**: Advanced collection operations
- **Method References**: Functional programming concepts
- **Exception Management**: Advanced exception handling patterns

### B. Data Structures & Algorithms (`B-DataStructureAlgorithem/`)
**Implementation of fundamental data structures and algorithms**

#### Array Operations
- Linear Search
- Binary Search
- Sorting Algorithms: Bubble Sort, Selection Sort, Insertion Sort, Quick Sort, Merge Sort

#### Data Structures
- **Linked Lists**: Implementation and operations
- **Stacks**: Static and dynamic stack implementations
- **Queues**: Linear and circular queue implementations
- **Trees**: Binary Search Tree operations

### C. GUI Programming (`C-GUI-Exercise/`)
**Java Swing-based graphical user interface development**

#### Features
- **Puzzle Game**: Complete 15-puzzle implementation with multiple themes
- **Swing Components**: Practical examples of Java Swing framework
- **Event Handling**: Keyboard and mouse event management
- **Resource Management**: Image loading and display

#### Game Features
- Multiple image themes (animals, sports)
- Keyboard controls (arrow keys)
- Step counter and game statistics
- Menu system with various options

### D. Java I/O (`D-Java-IO/`)
**File handling and input/output operations**

- **File Operations**: File reading, writing, and manipulation
- **NIO (New I/O)**: Non-blocking I/O operations
- **Byte Streams**: Binary data handling
- **Character Streams**: Text data processing
- **Apache Commons IO**: Third-party library integration

### E. Java Threading (`E-Java-thread/`)
**Comprehensive concurrency and multithreading concepts**

- **Basic Multithreading**: Thread creation and management
- **Synchronization**: Locks and thread safety mechanisms
- **Semaphores**: Resource access control
- **Thread Pools**: Efficient thread management
- **Thread Collaboration**: Inter-thread communication
- **Thread-Safe Collections**: Concurrent data structures
- **Fork-Join Framework**: Parallel processing
- **Visibility Problems**: Memory model and synchronization issues
- **Atomic Variables**: Lock-free programming

### F. Network Programming (`F-java-network-programming/`)
**Network communication and socket programming**

- Socket programming
- Client-server communication
- Network protocols implementation

### G. Annotations & Reflection (`G-Java-Annotation-Reflection/`)
**Advanced Java features for meta-programming**

- Custom annotation creation
- Reflection API usage
- Runtime class manipulation
- Dynamic proxy patterns

## 🛠 Prerequisites

- **Java Development Kit (JDK)**: Version 21 or higher
- **Apache Maven**: Version 3.6 or higher
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code with Java extensions
- **Basic Programming Knowledge**: Understanding of programming fundamentals

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd JavaSE-Learning
```

### 2. Build the Project
Each module is a separate Maven project. Navigate to the desired module and build:

```bash
cd A-java-basics
mvn clean compile
```

### 3. Run Examples
Execute specific Java classes:
```bash
mvn exec:java -Dexec.mainClass="training.tutorial.TestBasicJava"
```

### 4. Run Tests
```bash
mvn test
```

## 📚 Learning Path

### Beginner Level
1. Start with **A-java-basics/tutorial/** for fundamental concepts
2. Practice with basic examples: variables, operators, control structures
3. Learn OOP concepts: classes, objects, inheritance

### Intermediate Level
1. Explore **A-java-basics/tutorialAdvanced/** for advanced OOP
2. Study **B-DataStructureAlgorithem/** for algorithmic thinking
3. Practice with **D-Java-IO/** for file operations

### Advanced Level
1. Master **E-Java-thread/** for concurrent programming
2. Develop GUI applications with **C-GUI-Exercise/**
3. Learn network programming with **F-java-network-programming/**
4. Explore meta-programming with **G-Java-Annotation-Reflection/**

## ✨ Key Features

- **Structured Learning**: Progressive difficulty from basics to advanced topics
- **Practical Examples**: Real-world implementations and use cases
- **Comprehensive Comments**: Detailed Chinese explanations for better understanding
- **Maven Integration**: Professional build tool configuration
- **JUnit Testing**: Unit tests for code validation
- **Modern Java**: Uses Java 21 features and best practices
- **GUI Application**: Complete puzzle game implementation
- **Database Integration**: MySQL connector included for database operations

## 🧪 Testing

The project includes comprehensive testing with JUnit 5:

```bash
# Run all tests
mvn test

# Run tests with coverage
mvn test jacoco:report
```

## 📄 Project Configuration

- **Java Version**: 21
- **Build Tool**: Maven
- **Testing Framework**: JUnit 5
- **Database**: MySQL (connector included)
- **IDE Configuration**: IntelliJ IDEA and Eclipse project files included

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-concept`)
3. Add your implementations with proper documentation
4. Include tests for new functionality
5. Commit your changes (`git commit -m 'Add new learning concept'`)
6. Push to the branch (`git push origin feature/new-concept`)
7. Create a Pull Request

## 📝 Code Style Guidelines

- Use meaningful variable and method names
- Include comprehensive comments (preferably in Chinese for learning purposes)
- Follow Java naming conventions
- Write unit tests for new implementations
- Organize code in appropriate packages

## 🎓 Learning Outcomes

Upon completing this learning path, you will have mastered:

- Core Java syntax and object-oriented programming principles
- Data structures and algorithm implementation
- GUI application development with Swing
- File I/O and stream operations
- Concurrent programming and thread management
- Network programming fundamentals
- Advanced Java features like reflection and annotations
- Professional development practices with Maven and testing

## 📞 Support

If you encounter any issues or have questions about the learning materials:

1. Check the extensive comments within the code files
2. Review the module-specific documentation
3. Create an issue in the repository for bugs or improvements
4. Contribute your own examples and improvements

---

**Note**: This repository is primarily designed for Chinese-speaking learners, with extensive Chinese comments throughout the codebase to facilitate understanding of complex Java concepts. 