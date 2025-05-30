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
    CREATE TABLE [User]
	(
        UserID INT IDENTITY(1,1) PRIMARY KEY,
        Username NVARCHAR(100) NOT NULL UNIQUE,
        FirstName NVARCHAR(100) NOT NULL,
        LastName NVARCHAR(100) NOT NULL,
		PasswordHash NVARCHAR(255) NOT NULL,
		Email NVARCHAR(255) NOT NULL UNIQUE,
        RoleID INT NOT NULL,
        CreatedAt DATETIME DEFAULT GETDATE(),
        UpdatedAt DATETIME DEFAULT GETDATE(),
        FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
    )
END
GO

IF NOT EXISTS (SELECT * FROM [User] WHERE Username = 'admin')
BEGIN
    INSERT INTO [User]
	(
		Username,
		FirstName,
		LastName,
		PasswordHash,
		Email,
		RoleID
	)
    VALUES
	(
        'admin',
		'admin',
		'admin',
        '$2a$12$Rk.FhE0mvRwKPqgvJCCc0OeNErCr9wHrk3CJKYwDDNRH3UvWr2y6G',
        'admin@admin.com',
        (SELECT RoleID FROM Role WHERE RoleName = 'Admin')
    )
END
GO


CREATE OR ALTER PROCEDURE uspCreateUser
	@UserId INT OUTPUT,
    @Username NVARCHAR(100),
	@FirstName NVARCHAR(100),
	@LastName NVARCHAR(100),
    @PasswordHash NVARCHAR(255),
    @Email NVARCHAR(255)
AS
BEGIN
    INSERT INTO [User]
	(
		Username,
		FirstName,
		LastName,
		PasswordHash,
		Email,
		RoleID
	)
    VALUES
	(
		@Username,
		@FirstName,
		@LastName,
		@PasswordHash,
		@Email,
		(SELECT RoleID FROM Role WHERE RoleName = 'User')
		);

		SET @UserID = SCOPE_IDENTITY()
END;
GO

CREATE OR ALTER PROCEDURE uspSelectUserWithId
    @UserID INT
AS
BEGIN
    SELECT * FROM [User]
    WHERE UserID = @UserID;
END;
GO

CREATE OR ALTER PROCEDURE uspSelectUserWithUsername
    @Username NVARCHAR(100)
AS
BEGIN
 SELECT
        u.UserID,
        u.Username,
        u.PasswordHash,
        u.Email,
        u.FirstName,
        u.LastName,
        u.CreatedAt,
        u.UpdatedAt,
        r.RoleName
    FROM [User] u
    JOIN [Role] r ON u.RoleID = r.RoleID
    WHERE u.Username = @Username;
END;
GO

CREATE OR ALTER PROCEDURE uspUpdateUserWithId
    @UserID INT,
    @Username NVARCHAR(100),
	@FirstName NVARCHAR(100),
	@LastName NVARCHAR(100),
    @PasswordHash NVARCHAR(255),
    @Email NVARCHAR(255),
    @RoleID INT
AS
BEGIN
    UPDATE [User]
    SET
        Username = @Username,
		FirstName = @FirstName,
		LastName = @LastName,
        PasswordHash = @PasswordHash,
        Email = @Email,
        RoleID = @RoleID,
        UpdatedAt = GETDATE()
    WHERE UserID = @UserID;
END;
GO

CREATE OR ALTER PROCEDURE uspDeleteUserWithId
    @UserID INT
AS
BEGIN
    DELETE FROM [User]
    WHERE UserID = @UserID;
END;
GO

select * from [User]

