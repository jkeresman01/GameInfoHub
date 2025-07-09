## 🎮 Game Info Hub ##

Game Info Hub is a Java-based desktop application that allows users to explore and manage a collection of video games and related articles. The application connects to a SQL Server database (managed via SSMS) to store, retrieve, and organize game data.

## Preview ##
![image](https://github.com/user-attachments/assets/024153c3-dae1-49cf-bfbe-7dd0ba3a36b6)


![image](https://github.com/user-attachments/assets/0f929eaa-c79b-4daa-9e01-a9cf0f1cd05d)


## Database design ## 

![image](https://github.com/user-attachments/assets/5ed2ca26-7698-475b-8978-0e8522662f04)


## Project structure

```bash
GameInfoHub/                              # Game Info Hub project root (Maven multi-module)
├── Backups/                              # Backup scripts and exports
│   ├── RSS/                              # Exported RSS backup
│   └── SQL/                              # DB schema and procedures (DDL, SPs, etc.)
|
├── SQL/                                  # Initial DDL script for schema setup
│   └── DDLInitScript.sql
|
├── DAO/                                  # Data Access Module
│   ├── dal/                              # DAO interfaces and factory
│   │   └── sql/                          # SQL implementations using JDBC
│   ├── mapper/                           # Maps result sets to model objects
│   └── model/                            # Domain models (Article, Game, User, etc.)
|
├── GameInfoHubManager/                   # Main desktop application (GUI)
│   ├── parser/
│   │   └── rss/                          # RSS feed parsing logic
│   ├── payload/                          # DTOs for user input and updates
│   ├── service/                          # Core services (Article, Game, User, etc.)
│   ├── session/                          # Manages session/user state
│   ├── validator/
│   │   └── user/                         # Validation for user registration, login, update
│   └── view/
│       ├── designer/                     # GUI form designer classes
│       └── model/                        # Swing table models for view rendering
|
├── Utilities/                            # Common utility classes and factories
│   ├── factory/                          # Factory methods (e.g., ParserFactory)
│   └── utilities/                        # Generic helpers (BCrypt, file, HTML, icons, etc.)
|
├── LICENSE
├── pom.xml                               # Parent Maven POM
└── README.md
```

## Getting Started

1. Clone the Repository

```bash
git clone https://github.com/jkeresman01/GameInfoHub
```

2. Set Up SQL Server Database  

Open SQL Server Management Studio (SSMS)  
Run the provided SQL script (`DDLInitScript.sql`) to create the necessary tables and other nonsense. 
Configure your database connection in the  `db.prorties` (e.g., URL, username, password)

3. Run the Application  
Compile and run the thing.  
Login or register to start exploring game conten

## Requirements ##

 - Java JDK 21+

 - SQL Server and SSMS

- JDBC Driver for SQL Server

