USE [master]
GO
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'IGNGamesRSSFeed')
BEGIN
    CREATE DATABASE [IGNGamesRSSFeed]
END
GO

USE [IGNGamesRSSFeed]
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Developer')
BEGIN
    CREATE TABLE Developer (
        DeveloperID INT IDENTITY(1,1) PRIMARY KEY,
        Name NVARCHAR(255) NOT NULL UNIQUE
    )
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Platform')
BEGIN
    CREATE TABLE Platform (
        PlatformID INT IDENTITY(1,1) PRIMARY KEY,
        Name NVARCHAR(100) NOT NULL UNIQUE
    )
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Genre')
BEGIN
    CREATE TABLE Genre (
        GenreID INT IDENTITY(1,1) PRIMARY KEY,
        Name NVARCHAR(100) NOT NULL UNIQUE
    )
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Game')
BEGIN
    CREATE TABLE Game (
        GameID INT IDENTITY(1,1) PRIMARY KEY,
        Title NVARCHAR(500) NOT NULL,
        ReleaseDate DATE NULL,
        DeveloperID INT NULL,
        Description NVARCHAR(MAX),
        Link NVARCHAR(1000),
        FOREIGN KEY (DeveloperID) REFERENCES Developer(DeveloperID)
    )
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'GamePlatform')
BEGIN
    CREATE TABLE GamePlatform (
        GameID INT NOT NULL,
        PlatformID INT NOT NULL,
        PRIMARY KEY (GameID, PlatformID),
        FOREIGN KEY (GameID) REFERENCES Game(GameID),
        FOREIGN KEY (PlatformID) REFERENCES Platform(PlatformID)
    )
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'GameGenre')
BEGIN
    CREATE TABLE GameGenre (
        GameID INT NOT NULL,
        GenreID INT NOT NULL,
        PRIMARY KEY (GameID, GenreID),
        FOREIGN KEY (GameID) REFERENCES Game(GameID),
        FOREIGN KEY (GenreID) REFERENCES Genre(GenreID)
    )
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Review')
BEGIN
    CREATE TABLE Review (
        ReviewID INT IDENTITY(1,1) PRIMARY KEY,
        GameID INT NOT NULL,
        Score DECIMAL(3,1) NULL,
        ReviewText NVARCHAR(MAX),
        Reviewer NVARCHAR(255),
        ReviewDate DATETIME DEFAULT GETDATE(),
        FOREIGN KEY (GameID) REFERENCES Game(GameID)
    )
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Role')
BEGIN
    CREATE TABLE Role (
        RoleID INT IDENTITY(1,1) PRIMARY KEY,
        RoleName NVARCHAR(50) NOT NULL UNIQUE
    )
END
GO

IF NOT EXISTS (SELECT * FROM Role WHERE RoleName = 'Admin')
BEGIN
    INSERT INTO Role (RoleName) VALUES ('Admin')
END
IF NOT EXISTS (SELECT * FROM Role WHERE RoleName = 'User')
BEGIN
    INSERT INTO Role (RoleName) VALUES ('User')
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'User')
BEGIN
    CREATE TABLE [User] (
        UserID INT IDENTITY(1,1) PRIMARY KEY,
        Username NVARCHAR(100) NOT NULL UNIQUE,
        Password NVARCHAR(255) NOT NULL,
        Email NVARCHAR(255) NOT NULL,
        RoleID INT NOT NULL,
        CreatedAt DATETIME DEFAULT GETDATE(),
        UpdatedAt DATETIME DEFAULT GETDATE(),
        FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
    )
END
GO

IF NOT EXISTS (SELECT * FROM [User] WHERE Username = 'admin')
BEGIN
    INSERT INTO [User] (Username, Password, Email, RoleID)
    VALUES (
        'admin',
        'admin',
        'admin@admin.com',
        (SELECT RoleID FROM Role WHERE RoleName = 'Admin')
    )
END
GO
