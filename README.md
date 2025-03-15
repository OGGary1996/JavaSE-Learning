# Puzzle Game

An interactive puzzle game application based on Java Swing, offering various image themes and game features.

## Project Overview

This puzzle game is a classic 15-puzzle implementation where players need to move blocks to restore the complete image. The game provides multiple image themes, including animal and sports themes, allowing players to choose different images according to their preferences.

## Features

- **Multiple Image Themes**: Various animal and sports-themed images for players to choose from
- **Keyboard Control**: Use arrow keys to move puzzle blocks
- **Preview Function**: Press the A key to preview the complete image
- **Step Counter**: Records the number of steps needed to complete the puzzle
- **Menu Options**: 
  - Change Picture
  - Restart Game
  - Close Game
  - View Author Information

## Technology Stack

- Java
- Swing GUI Framework
- Maven Build Tool

## System Requirements

- Java 9 or higher
- Maven 3.6 or higher



## Game Controls

- **Arrow Keys**: Move puzzle blocks
- **A Key**: Display complete image preview
- **Menu Bar**:
  - "Change Picture": Switch puzzle images
  - "Restart": Restart the game
  - "Close": Exit the game
  - "Author": Display author information

## Project Structure

```
GUIExercise/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── puzzleGame/
│   │   │   │   ├── App.java                # Application entry point
│   │   │   │   ├── ui/
│   │   │   │   │   ├── GameFrame.java      # Main game interface
│   │   │   │   │   └── RegisterFrame.java  # Registration interface
│   │   ├── resources/
│   │   │   ├── puzzleGame/
│   │   │   │   ├── gameImage/              # Game image resources
│   │   │   │   │   ├── animal1/            # Animal theme images
│   │   │   │   │   ├── animal2/
│   │   │   │   │   └── ...
│   │   │   │   │   ├── sport1/             # Sports theme images
│   │   │   │   │   ├── sport2/
│   │   │   │   │   └── ...
├── pom.xml                                 # Maven configuration file
└── README.md                               # Project documentation
```

## Development Roadmap

- [ ] Add user login and registration functionality
- [ ] Implement game difficulty selection
- [ ] Add timer functionality
- [ ] Implement leaderboard system
- [ ] Support custom image uploads

## Contribution Guidelines

1. Fork the project
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Create a Pull Request
