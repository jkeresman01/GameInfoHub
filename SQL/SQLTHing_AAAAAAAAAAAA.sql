DROP DATABASE GameArticles2
GO

CREATE DATABASE GameArticles2
GO

USE GameArticles2
GO

-- TABLES

CREATE TABLE [Role] (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(50) NOT NULL UNIQUE
)
GO

CREATE TABLE Gender (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(20) NOT NULL UNIQUE
)
GO

CREATE TABLE [User] (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Username NVARCHAR(100) NOT NULL UNIQUE,
    PasswordHash NVARCHAR(255) NOT NULL,
    FirstName NVARCHAR(100),
    LastName NVARCHAR(100),
    Email NVARCHAR(100),
    PicturePath NVARCHAR(255),
    CreatedAt DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    UpdatedAt DATETIME2,
    IsActive BIT NOT NULL DEFAULT 1,
    RoleId INT NOT NULL,
    GenderId INT NOT NULL,
    FOREIGN KEY (RoleId) REFERENCES Role(Id),
    FOREIGN KEY (GenderId) REFERENCES Gender(Id)
)
GO

CREATE TABLE Game (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(255) NOT NULL,
    ReleaseDate DATE
)
GO

CREATE TABLE Genre (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL UNIQUE
);
GO

CREATE TABLE Platform (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL UNIQUE
)
GO

CREATE TABLE Developer (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL UNIQUE
);
GO

CREATE TABLE Category (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL UNIQUE
)
GO


CREATE TABLE Article (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Title NVARCHAR(255) NOT NULL,
    Link NVARCHAR(500),
    Description NVARCHAR(MAX),
    PublishedDateTime DATETIME2,
    PicturePath NVARCHAR(255)
)
GO

CREATE TABLE Comment (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Title NVARCHAR(255),
    Content NVARCHAR(MAX) NOT NULL,
    CreatedAt DATETIME2 DEFAULT SYSDATETIME(),
    UserId INT NOT NULL,
    GameId INT NOT NULL,
    FOREIGN KEY (UserId) REFERENCES [User](Id),
    FOREIGN KEY (GameId) REFERENCES Game(Id)
)
GO

CREATE TABLE Report (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Title NVARCHAR(255),
    Content NVARCHAR(MAX) NOT NULL,
    CreatedAt DATETIME2 DEFAULT SYSDATETIME(),
    UserId INT NOT NULL,
    ArticleId INT NOT NULL,
    FOREIGN KEY (UserId) REFERENCES [User](Id),
    FOREIGN KEY (ArticleId) REFERENCES Article(Id)
)
GO

CREATE TABLE FavoriteArticle (
    UserId INT NOT NULL,
    ArticleId INT NOT NULL,
    PRIMARY KEY (UserId, ArticleId),
    FOREIGN KEY (UserId) REFERENCES [User](Id),
    FOREIGN KEY (ArticleId) REFERENCES Article(Id)
)
GO

CREATE TABLE FavoriteGame (
    UserId INT NOT NULL,
    GameId INT NOT NULL,
    PRIMARY KEY (UserId, GameId),
    FOREIGN KEY (UserId) REFERENCES [User](Id),
    FOREIGN KEY (GameId) REFERENCES Game(Id)
)
GO


CREATE TABLE GameGenre (
    GameId INT NOT NULL,
    GenreId INT NOT NULL,
    PRIMARY KEY (GameId, GenreId),
    FOREIGN KEY (GameId) REFERENCES Game(Id),
    FOREIGN KEY (GenreId) REFERENCES Genre(Id)
)
GO

CREATE TABLE GamePlatform (
    GameId INT NOT NULL,
    PlatformId INT NOT NULL,
    PRIMARY KEY (GameId, PlatformId),
    FOREIGN KEY (GameId) REFERENCES Game(Id),
    FOREIGN KEY (PlatformId) REFERENCES Platform(Id)
)
GO

CREATE TABLE GameDeveloper (
    GameId INT NOT NULL,
    DeveloperId INT NOT NULL,
    PRIMARY KEY (GameId, DeveloperId),
    FOREIGN KEY (GameId) REFERENCES Game(Id),
    FOREIGN KEY (DeveloperId) REFERENCES Developer(Id)
)
GO

CREATE TABLE ArticleCategory (
    ArticleId INT NOT NULL,
    CategoryId INT NOT NULL,
    PRIMARY KEY (ArticleId, CategoryId),
    FOREIGN KEY (ArticleId) REFERENCES Article(Id),
    FOREIGN KEY (CategoryId) REFERENCES Category(Id)
)
GO

CREATE TABLE ArticleGame (
    ArticleId INT NOT NULL,
    GameId INT NOT NULL,
    PRIMARY KEY (ArticleId, GameId),
    FOREIGN KEY (ArticleId) REFERENCES Article(Id),
    FOREIGN KEY (GameId) REFERENCES Game(Id)
)
GO

-- INDEXES

CREATE UNIQUE INDEX IX_User_Username ON [User](Username);
CREATE INDEX IX_User_RoleId ON [User](RoleId);
CREATE INDEX IX_User_GenderId ON [User](GenderId);

CREATE INDEX IX_Game_Name ON Game(Name);
CREATE INDEX IX_Game_ReleaseDate ON Game(ReleaseDate);

CREATE UNIQUE INDEX IX_Genre_Name ON Genre(Name);

CREATE UNIQUE INDEX IX_Platform_Name ON Platform(Name);

CREATE UNIQUE INDEX IX_Developer_Name ON Developer(Name);

CREATE UNIQUE INDEX IX_Category_Name ON Category(Name);

CREATE INDEX IX_Article_Title ON Article(Title);
CREATE INDEX IX_Article_PublishedDateTime ON Article(PublishedDateTime);

CREATE INDEX IX_GameGenre_GenreId ON GameGenre(GenreId);

CREATE INDEX IX_GamePlatform_PlatformId ON GamePlatform(PlatformId);

CREATE INDEX IX_GameDeveloper_DeveloperId ON GameDeveloper(DeveloperId);

CREATE INDEX IX_ArticleCategory_CategoryId ON ArticleCategory(CategoryId);

CREATE INDEX IX_ArticleGame_GameId ON ArticleGame(GameId);

CREATE INDEX IX_Comment_UserId ON Comment(UserId);
CREATE INDEX IX_Comment_GameId ON Comment(GameId);


CREATE INDEX IX_Report_UserId ON Report(UserId);
CREATE INDEX IX_Report_ArticleId ON Report(ArticleId);

CREATE INDEX IX_FavoriteArticle_ArticleId ON FavoriteArticle(ArticleId);

CREATE INDEX IX_FavoriteGame_GameId ON FavoriteGame(GameId);

-- DEFAULT ROLES AND GENDERS
INSERT INTO Gender (Name) VALUES ('MALE'), ('FEMALE'), ('OTHER');
INSERT INTO Role (Name) VALUES ('Administrator'), ('User');
GO

-- STORE PROCEDURES

-- USER

CREATE OR ALTER PROCEDURE uspCreateUser
    @Username NVARCHAR(50),
    @FirstName NVARCHAR(50),
    @LastName NVARCHAR(50),
    @PasswordHash NVARCHAR(255),
    @Email NVARCHAR(100),
    @PicturePath NVARCHAR(255),
    @Gender NVARCHAR(20),
    @UserId INT OUTPUT
AS
BEGIN
    DECLARE @RoleId INT = (SELECT Id FROM [Role] WHERE Name = 'User');
    DECLARE @GenderId INT = (SELECT Id FROM Gender WHERE Name = @Gender);

    INSERT INTO [User] (
        Username, FirstName, LastName, PasswordHash, Email,
        PicturePath, RoleId, GenderId, IsActive, CreatedAt, UpdatedAt
    )
    VALUES (
        @Username, @FirstName, @LastName, @PasswordHash, @Email,
        @PicturePath, @RoleId, @GenderId, 1, GETDATE(), GETDATE()
    );

    SET @UserId = SCOPE_IDENTITY();
END
GO

CREATE OR ALTER PROCEDURE uspUpdateUserWithId
    @UserId INT,
    @Username NVARCHAR(50),
    @FirstName NVARCHAR(50),
    @LastName NVARCHAR(50),
    @PasswordHash NVARCHAR(255),
    @PicturePath NVARCHAR(255),
    @Email NVARCHAR(100)
AS
BEGIN
    DECLARE @RoleId INT = (SELECT Id FROM Role WHERE Name = 'User');

    UPDATE [User]
    SET Username = @Username,
        FirstName = @FirstName,
        LastName = @LastName,
        PasswordHash = @PasswordHash,
        PicturePath = @PicturePath,
        Email = @Email,
        RoleId = @RoleId,
        UpdatedAt = GETDATE()
    WHERE Id = @UserId;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteUserWithId
    @UserId INT
AS
BEGIN
    DELETE FROM [User] WHERE Id = @UserId;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteAllUsers
AS
BEGIN
    DELETE FROM [User];
END
GO

CREATE OR ALTER PROCEDURE uspSelectUserWithId
    @UserId INT
AS
BEGIN
    SELECT 
        u.Id,
        u.Username,
        u.PasswordHash,
        u.FirstName,
        u.LastName,
        u.Email,
        r.Name AS RoleName,
        g.Name AS GenderName,
        u.IsActive,
        u.PicturePath,
        u.CreatedAt,
        u.UpdatedAt
    FROM [User] u
    JOIN Role r ON u.RoleId = r.Id
    JOIN Gender g ON u.GenderId = g.Id
    WHERE u.Id = @UserId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectUserWithUsername
    @Username NVARCHAR(50)
AS
BEGIN
    SELECT 
        u.Id,
        u.Username,
        u.PasswordHash,
        u.FirstName,
        u.LastName,
        u.Email,
        r.Name AS RoleName,
        g.Name AS GenderName,
        u.IsActive,
        u.PicturePath,
        u.CreatedAt,
        u.UpdatedAt
    FROM [User] u
    JOIN Role r ON u.RoleId = r.Id
    JOIN Gender g ON u.GenderId = g.Id
    WHERE u.Username = @Username;
END
GO

CREATE OR ALTER PROCEDURE uspSelectAllUsers
AS
BEGIN
    SELECT 
        u.Id,
        u.Username,
        u.PasswordHash,
        u.FirstName,
        u.LastName,
        u.Email,
        r.Name AS RoleName,
        g.Name AS GenderName,
        u.IsActive,
        u.PicturePath,
        u.CreatedAt,
        u.UpdatedAt
    FROM [User] u
    JOIN Role r ON u.RoleId = r.Id
    JOIN Gender g ON u.GenderId = g.Id;
END
GO

CREATE OR ALTER PROCEDURE uspExistsUserWithUsername
    @Username NVARCHAR(50),
    @Exists BIT OUTPUT
AS
BEGIN
    SET @Exists = CASE WHEN EXISTS (
        SELECT 1 FROM [User] WHERE Username = @Username
    ) THEN 1 ELSE 0 END;
END
GO

CREATE OR ALTER PROCEDURE uspExistsUserWithEmail
    @Email NVARCHAR(100),
    @Exists BIT OUTPUT
AS
BEGIN
    SET @Exists = CASE WHEN EXISTS (
        SELECT 1 FROM [User] WHERE Email = @Email
    ) THEN 1 ELSE 0 END;
END
GO

CREATE OR ALTER PROCEDURE uspActivateProfileForUserWithId
    @UserId INT
AS
BEGIN
    UPDATE [User] SET IsActive = 1 WHERE Id = @UserId;
END
GO

CREATE OR ALTER PROCEDURE uspDeactivateProfileForUserWithId
    @UserId INT
AS
BEGIN
    UPDATE [User] SET IsActive = 0 WHERE Id = @UserId;
END
GO

-- Article

CREATE OR ALTER PROCEDURE uspCreateArticle
    @Title NVARCHAR(255),
    @Link NVARCHAR(1000),
    @Description NVARCHAR(MAX),
    @PubDate DATETIME,
    @PicturePath NVARCHAR(500),
    @ArticleId INT OUTPUT
AS
BEGIN
    INSERT INTO Article (Title, Link, Description, PublishedDateTime, PicturePath)
    VALUES (@Title, @Link, @Description, @PubDate, @PicturePath);

    SET @ArticleId = SCOPE_IDENTITY();
END
GO

CREATE OR ALTER PROCEDURE uspUpdateArticleWithId
    @ArticleId INT,
    @Title NVARCHAR(255),
    @Link NVARCHAR(1000),
    @Description NVARCHAR(MAX),
    @PubDate DATETIME,
    @PicturePath NVARCHAR(500)
AS
BEGIN
    UPDATE Article
    SET Title = @Title,
        Link = @Link,
        Description = @Description,
        PublishedDateTime = @PubDate,
        PicturePath = @PicturePath
    WHERE Id = @ArticleId;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteArticleWithId
    @ArticleId INT
AS
BEGIN
    DELETE FROM Article WHERE Id = @ArticleId;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteAllArticles
AS
BEGIN
    DELETE FROM Article;
END
GO

CREATE OR ALTER PROCEDURE uspSelectArticleWithId
    @ArticleId INT
AS
BEGIN
    SELECT Id, Title, Link, Description, PublishedDateTime, PicturePath
    FROM Article
    WHERE Id = @ArticleId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectAllArticles
AS
BEGIN
    SELECT Id, Title, Link, Description, PublishedDateTime, PicturePath
    FROM Article;
END
GO

CREATE OR ALTER PROCEDURE uspSelectArticlesByTitle
    @Title NVARCHAR(255)
AS
BEGIN
    SELECT Id, Title, Link, Description, PublishedDateTime, PicturePath
    FROM Article
    WHERE Title = @Title;
END
GO

CREATE OR ALTER PROCEDURE uspSelectArticlesByCategoryName
    @CategoryName NVARCHAR(255)
AS
BEGIN
    SELECT a.Id, a.Title, a.Link, a.Description, a.PublishedDateTime, a.PicturePath
    FROM Article a
    JOIN ArticleCategory ac ON a.Id = ac.ArticleId
    JOIN Category c ON ac.CategoryId = c.Id
    WHERE c.Name = @CategoryName;
END
GO

CREATE OR ALTER PROCEDURE uspSelectArticlesByGameId
    @GameId INT
AS
BEGIN
    SELECT a.Id, a.Title, a.Link, a.Description, a.PublishedDateTime, a.PicturePath
    FROM Article a
    JOIN ArticleGame ag ON a.Id = ag.ArticleId
    WHERE ag.GameId = @GameId;
END
GO

CREATE OR ALTER PROCEDURE uspExistsArticleWithLink
    @Link NVARCHAR(1000),
    @Exists BIT OUTPUT
AS
BEGIN
    SET @Exists = CASE WHEN EXISTS (
        SELECT 1 FROM Article WHERE Link = @Link
    ) THEN 1 ELSE 0 END;
END
GO

CREATE OR ALTER PROCEDURE uspAddCategoryToArticle
    @ArticleId INT,
    @CategoryId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM ArticleCategory WHERE ArticleId = @ArticleId AND CategoryId = @CategoryId
    )
    BEGIN
        INSERT INTO ArticleCategory (ArticleId, CategoryId)
        VALUES (@ArticleId, @CategoryId);
    END
END
GO

CREATE OR ALTER PROCEDURE uspRemoveCategoryFromArticle
    @ArticleId INT,
    @CategoryId INT
AS
BEGIN
    DELETE FROM ArticleCategory WHERE ArticleId = @ArticleId AND CategoryId = @CategoryId;
END
GO

CREATE OR ALTER PROCEDURE uspAddGameToArticle
    @ArticleId INT,
    @GameId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM ArticleGame WHERE ArticleId = @ArticleId AND GameId = @GameId
    )
    BEGIN
        INSERT INTO ArticleGame (ArticleId, GameId)
        VALUES (@ArticleId, @GameId);
    END
END
GO

CREATE OR ALTER PROCEDURE uspRemoveGameFromArticle
    @ArticleId INT,
    @GameId INT
AS
BEGIN
    DELETE FROM ArticleGame WHERE ArticleId = @ArticleId AND GameId = @GameId;
END
GO

--	CATEGORY

CREATE OR ALTER PROCEDURE uspCreateCategory
    @Name NVARCHAR(100),
    @CategoryId INT OUTPUT
AS
BEGIN
    INSERT INTO Category (Name)
    VALUES (@Name);

    SET @CategoryId = SCOPE_IDENTITY();
END
GO

CREATE OR ALTER PROCEDURE uspUpdateCategoryWithId
    @CategoryId INT,
    @Name NVARCHAR(100)
AS
BEGIN
    UPDATE Category
    SET Name = @Name
    WHERE Id = @CategoryId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectCategoryWithId
    @CategoryId INT
AS
BEGIN
    SELECT Id, Name
    FROM Category
    WHERE Id = @CategoryId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectAllCategories
AS
BEGIN
    SELECT Id, Name
    FROM Category;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteAllCategories
AS
BEGIN
    DELETE FROM Category;
END
GO


-- GENRE -- 

CREATE PROCEDURE uspCreateGenre
    @Name NVARCHAR(100),
    @GenreId INT OUTPUT
AS
BEGIN
    INSERT INTO Genre (Name)
    VALUES (@Name);

    SET @GenreId = SCOPE_IDENTITY();
END
GO


CREATE PROCEDURE uspUpdateGenreWithId
    @GenreId INT,
    @Name NVARCHAR(100)
AS
BEGIN
    UPDATE Genre
    SET Name = @Name
    WHERE Id = @GenreId;
END
GO


CREATE PROCEDURE uspSelectGenreWithId
    @GenreId INT
AS
BEGIN
    SELECT Id, Name
    FROM Genre
    WHERE Id = @GenreId;
END
GO


CREATE PROCEDURE uspSelectAllGenres
AS
BEGIN
    SELECT Id, Name
    FROM Genre;
END
GO

CREATE PROCEDURE uspDeleteAllGenres
AS
BEGIN
    DELETE FROM Genre;
END
GO


-- Platform


CREATE PROCEDURE uspCreatePlatform
    @Name NVARCHAR(100),
    @PlatformId INT OUTPUT
AS
BEGIN
    INSERT INTO Platform (Name)
    VALUES (@Name);

    SET @PlatformId = SCOPE_IDENTITY();
END
GO

CREATE PROCEDURE uspUpdatePlatformWithId
    @PlatformId INT,
    @Name NVARCHAR(100)
AS
BEGIN
    UPDATE Platform
    SET Name = @Name
    WHERE Id = @PlatformId;
END
GO

CREATE PROCEDURE uspSelectPlatformWithId
    @PlatformId INT
AS
BEGIN
    SELECT Id, Name
    FROM Platform
    WHERE Id = @PlatformId;
END
GO

CREATE PROCEDURE uspSelectAllPlatforms
AS
BEGIN
    SELECT Id, Name
    FROM Platform;
END
GO

CREATE PROCEDURE uspDeleteAllPlatforms
AS
BEGIN
    DELETE FROM Platform;
END
GO


-- DEVELOPER

CREATE PROCEDURE uspCreateDeveloper
    @Name NVARCHAR(100),
    @DeveloperId INT OUTPUT
AS
BEGIN
    INSERT INTO Developer (Name)
    VALUES (@Name);

    SET @DeveloperId = SCOPE_IDENTITY();
END
GO

CREATE PROCEDURE uspUpdateDeveloperWithId
    @DeveloperId INT,
    @Name NVARCHAR(100)
AS
BEGIN
    UPDATE Developer
    SET Name = @Name
    WHERE Id = @DeveloperId;
END
GO

CREATE PROCEDURE uspSelectAllDevelopers
AS
BEGIN
    SELECT Id, Name
    FROM Developer;
END
GO

CREATE PROCEDURE uspDeleteAllDevelopers
AS
BEGIN
    DELETE FROM Developer;
END
GO

-- Game

CREATE OR ALTER PROCEDURE uspCreateGame
    @Name NVARCHAR(255),
    @ReleaseDate DATE,
    @GameId INT OUTPUT
AS
BEGIN
    INSERT INTO Game (Name, ReleaseDate)
    VALUES (@Name, @ReleaseDate);

    SET @GameId = SCOPE_IDENTITY();
END
GO

CREATE OR ALTER PROCEDURE uspUpdateGameWithId
    @Id INT,
    @Name NVARCHAR(255),
    @ReleaseDate DATE
AS
BEGIN
    UPDATE Game
    SET Name = @Name,
        ReleaseDate = @ReleaseDate
    WHERE Id = @Id;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteGameWithId
    @Id INT
AS
BEGIN
    DELETE FROM Game WHERE Id = @Id;
END
GO


CREATE OR ALTER PROCEDURE uspDeleteAllGames
AS
BEGIN
    DELETE FROM Game;
END
GO

CREATE OR ALTER PROCEDURE uspSelectGameWithId
    @Id INT
AS
BEGIN
    SELECT 
        g.Id,
        g.Name,
        g.ReleaseDate,
        -- Genres
        STUFF((
            SELECT DISTINCT ', ' + gen.Name
            FROM GameGenre gg
            JOIN Genre gen ON gg.GenreId = gen.Id
            WHERE gg.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Genres,

        -- Developers
        STUFF((
            SELECT DISTINCT ', ' + d.Name
            FROM GameDeveloper gd
            JOIN Developer d ON gd.DeveloperId = d.Id
            WHERE gd.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Developers,

        -- Platforms
        STUFF((
            SELECT DISTINCT ', ' + p.Name
            FROM GamePlatform gp
            JOIN Platform p ON gp.PlatformId = p.Id
            WHERE gp.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Platforms

    FROM Game g
    WHERE g.Id = @Id;
END
GO


CREATE OR ALTER PROCEDURE uspSelectAllGames
AS
BEGIN
    SELECT 
        g.Id,
        g.Name,
        g.ReleaseDate,
        
        -- Genres
        STUFF((
            SELECT DISTINCT ', ' + gen.Name
            FROM GameGenre gg
            JOIN Genre gen ON gg.GenreId = gen.Id
            WHERE gg.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Genres,

        -- Developers
        STUFF((
            SELECT DISTINCT ', ' + d.Name
            FROM GameDeveloper gd
            JOIN Developer d ON gd.DeveloperId = d.Id
            WHERE gd.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Developers,

        -- Platforms
        STUFF((
            SELECT DISTINCT ', ' + p.Name
            FROM GamePlatform gp
            JOIN Platform p ON gp.PlatformId = p.Id
            WHERE gp.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Platforms

    FROM Game g;
END
GO


CREATE OR ALTER PROCEDURE uspSelectGamesByPlatformId
    @PlatformId INT
AS
BEGIN
    SELECT g.*
    FROM Game g
    INNER JOIN GamePlatform gp ON g.Id = gp.GameId
    WHERE gp.PlatformId = @PlatformId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectGamesByGenreId
    @GenreId INT
AS
BEGIN
    SELECT g.*
    FROM Game g
    INNER JOIN GameGenre gg ON g.Id = gg.GameId
    WHERE gg.GenreId = @GenreId;
END
GO

CREATE OR ALTER PROCEDURE uspAddGenreToGame
    @GameId INT,
    @GenreId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM GameGenre WHERE GameId = @GameId AND GenreId = @GenreId
    )
    BEGIN
        INSERT INTO GameGenre (GameId, GenreId)
        VALUES (@GameId, @GenreId);
    END
END
GO

CREATE OR ALTER PROCEDURE uspRemoveGenresFromGame
    @GameId INT
AS
BEGIN
    DELETE FROM GameGenre WHERE GameId = @GameId;
END
GO

CREATE OR ALTER PROCEDURE uspAddPlatformToGame
    @GameId INT,
    @PlatformId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM GamePlatform WHERE GameId = @GameId AND PlatformId = @PlatformId
    )
    BEGIN
        INSERT INTO GamePlatform (GameId, PlatformId)
        VALUES (@GameId, @PlatformId);
    END
END
GO

CREATE OR ALTER PROCEDURE uspRemovePlatformsFromGame
    @GameId INT
AS
BEGIN
    DELETE FROM GamePlatform WHERE GameId = @GameId;
END
GO

CREATE OR ALTER PROCEDURE uspAddDeveloperToGame
    @GameId INT,
    @DeveloperId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM GameDeveloper WHERE GameId = @GameId AND DeveloperId = @DeveloperId
    )
    BEGIN
        INSERT INTO GameDeveloper (GameId, DeveloperId)
        VALUES (@GameId, @DeveloperId);
    END
END
GO

CREATE OR ALTER PROCEDURE uspRemoveDevelopersFromGame
    @GameId INT
AS
BEGIN
    DELETE FROM GameDeveloper WHERE GameId = @GameId;
END
GO


-- FAV Games

CREATE OR ALTER PROCEDURE uspInsertFavoriteGame
    @UserId INT,
    @GameId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM FavoriteGame WHERE UserId = @UserId AND GameId = @GameId
    )
    BEGIN
        INSERT INTO FavoriteGame (UserId, GameId)
        VALUES (@UserId, @GameId);
    END
END
GO

CREATE OR ALTER PROCEDURE uspSelectFavoriteGamesByUserId
    @UserId INT
AS
BEGIN
    SELECT 
        g.Id,
        g.Name,
        g.ReleaseDate,

        -- Genres
        STUFF((
            SELECT DISTINCT ', ' + gen.Name
            FROM GameGenre gg
            JOIN Genre gen ON gg.GenreId = gen.Id
            WHERE gg.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Genres,

        -- Developers
        STUFF((
            SELECT DISTINCT ', ' + d.Name
            FROM GameDeveloper gd
            JOIN Developer d ON gd.DeveloperId = d.Id
            WHERE gd.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Developers,

        -- Platforms
        STUFF((
            SELECT DISTINCT ', ' + p.Name
            FROM GamePlatform gp
            JOIN Platform p ON gp.PlatformId = p.Id
            WHERE gp.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Platforms

    FROM Game g
    INNER JOIN FavoriteGame fg ON g.Id = fg.GameId
    WHERE fg.UserId = @UserId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectFavoriteGamesByGameId
    @GameId INT
AS
BEGIN
    SELECT 
        g.Id,
        g.Name,
        g.ReleaseDate,

        -- Genres
        STUFF((
            SELECT DISTINCT ', ' + gen.Name
            FROM GameGenre gg
            JOIN Genre gen ON gg.GenreId = gen.Id
            WHERE gg.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Genres,

        -- Developers
        STUFF((
            SELECT DISTINCT ', ' + d.Name
            FROM GameDeveloper gd
            JOIN Developer d ON gd.DeveloperId = d.Id
            WHERE gd.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Developers,

        -- Platforms
        STUFF((
            SELECT DISTINCT ', ' + p.Name
            FROM GamePlatform gp
            JOIN Platform p ON gp.PlatformId = p.Id
            WHERE gp.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Platforms

    FROM Game g
    INNER JOIN FavoriteGame fg ON g.Id = fg.GameId
    WHERE fg.GameId = @GameId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectAllFavoriteGames
AS
BEGIN
    SELECT 
        g.Id,
        g.Name,
        g.ReleaseDate,

        -- Genres
        STUFF((
            SELECT DISTINCT ', ' + gen.Name
            FROM GameGenre gg
            JOIN Genre gen ON gg.GenreId = gen.Id
            WHERE gg.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Genres,

        -- Developers
        STUFF((
            SELECT DISTINCT ', ' + d.Name
            FROM GameDeveloper gd
            JOIN Developer d ON gd.DeveloperId = d.Id
            WHERE gd.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Developers,

        -- Platforms
        STUFF((
            SELECT DISTINCT ', ' + p.Name
            FROM GamePlatform gp
            JOIN Platform p ON gp.PlatformId = p.Id
            WHERE gp.GameId = g.Id
            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') AS Platforms

    FROM Game g
    INNER JOIN FavoriteGame fg ON g.Id = fg.GameId;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteAllFavoriteGames
AS
BEGIN
    DELETE FROM FavoriteGame;
END
GO

-- FAV ARTICLES

CREATE OR ALTER PROCEDURE uspInsertFavouriteArticle
    @UserId INT,
    @ArticleId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM FavoriteArticle WHERE UserId = @UserId AND ArticleId = @ArticleId
    )
    BEGIN
        INSERT INTO FavoriteArticle (UserId, ArticleId)
        VALUES (@UserId, @ArticleId);
    END
END
GO

CREATE OR ALTER PROCEDURE uspSelectFavouriteArticlesByUserId
    @UserId INT
AS
BEGIN
    SELECT a.*
    FROM Article a
    INNER JOIN FavoriteArticle fa ON fa.ArticleId = a.Id
    WHERE fa.UserId = @UserId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectFavouriteArticlesByGameId
    @GameId INT
AS
BEGIN
    SELECT a.*
    FROM Article a
    INNER JOIN ArticleGame ag ON ag.ArticleId = a.Id
    INNER JOIN FavoriteArticle fa ON fa.ArticleId = a.Id
    WHERE ag.GameId = @GameId;
END
GO

CREATE OR ALTER PROCEDURE uspSelectAllFavouriteArticles
AS
BEGIN
    SELECT a.*
    FROM Article a
    INNER JOIN FavoriteArticle fa ON fa.ArticleId = a.Id;
END
GO


CREATE OR ALTER PROCEDURE uspDeleteAllFavouriteArticles
AS
BEGIN
    DELETE FROM FavoriteArticle;
END
GO

-- COMMENT

CREATE OR ALTER PROCEDURE uspInsertComment
    @Title NVARCHAR(255),
    @Content NVARCHAR(MAX),
    @UserId INT,
    @GameId INT,
    @CommentId INT OUTPUT
AS
BEGIN
    INSERT INTO Comment (Title, Content, UserId, GameId)
    VALUES (@Title, @Content, @UserId, @GameId);

    SET @CommentId = SCOPE_IDENTITY();
END
GO

CREATE OR ALTER PROCEDURE uspSelectCommentsByGameId
    @GameId INT
AS
BEGIN
    SELECT Id, Title, Content
    FROM Comment
    WHERE GameId = @GameId
    ORDER BY CreatedAt DESC;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteAllComments
AS
BEGIN
    DELETE FROM Comment;
END
GO

-- REPORT

CREATE OR ALTER PROCEDURE uspInsertReport
    @Title NVARCHAR(255),
    @Content NVARCHAR(MAX),
    @UserId INT,
    @ArticleId INT,
    @ReportId INT OUTPUT
AS
BEGIN
    INSERT INTO Report (Title, Content, UserId, ArticleId)
    VALUES (@Title, @Content, @UserId, @ArticleId);

    SET @ReportId = SCOPE_IDENTITY();
END
GO

CREATE OR ALTER PROCEDURE uspSelectReportsByArticleId
    @ArticleId INT
AS
BEGIN
    SELECT Id, Title, Content
    FROM Report
    WHERE ArticleId = @ArticleId
    ORDER BY CreatedAt DESC;
END
GO

CREATE OR ALTER PROCEDURE uspSelectAllReports
AS
BEGIN
    SELECT Id, Title, Content
    FROM Report
    ORDER BY CreatedAt DESC;
END
GO

CREATE OR ALTER PROCEDURE uspDeleteAllReports
AS
BEGIN
    DELETE FROM Report;
END
GO



---- ADMIN -----

select * from [User]

UPDATE [User]
SET RoleId = 1
WHERE Username = 'admin'

--- ADMIN END -----

