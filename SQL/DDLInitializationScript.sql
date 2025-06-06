CREATE DATABASE [GameArticles]
USE [GameArticles]
GO
/****** Object:  Table [dbo].[Article]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Article](
	[ArticleId] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NOT NULL,
	[Link] [nvarchar](500) NOT NULL,
	[Description] [nvarchar](max) NULL,
	[PubDate] [datetime2](7) NOT NULL,
	[PicturePath] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED
(
	[ArticleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Link] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ArticleCategory]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ArticleCategory](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ArticleId] [int] NOT NULL,
	[CategoryId] [int] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[ArticleId] ASC,
	[CategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ArticleGame]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ArticleGame](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ArticleId] [int] NOT NULL,
	[GameId] [int] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[ArticleId] ASC,
	[GameId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED
(
	[CategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Game]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Game](
	[GameId] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED
(
	[GameId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[RoleID] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[RoleName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](100) NOT NULL,
	[FirstName] [nvarchar](100) NOT NULL,
	[LastName] [nvarchar](100) NOT NULL,
	[PasswordHash] [nvarchar](255) NOT NULL,
	[Email] [nvarchar](255) NOT NULL,
	[PicturePath] [nvarchar](255) NOT NULL,
	[IsActive] [bit] NOT NULL,
	[RoleID] [int] NOT NULL,
	[CreatedAt] [datetime] NULL,
	[UpdatedAt] [datetime] NULL,
PRIMARY KEY CLUSTERED
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[User] ADD  DEFAULT ((1)) FOR [IsActive]
GO
ALTER TABLE [dbo].[User] ADD  DEFAULT (getdate()) FOR [CreatedAt]
GO
ALTER TABLE [dbo].[User] ADD  DEFAULT (getdate()) FOR [UpdatedAt]
GO
ALTER TABLE [dbo].[ArticleCategory]  WITH CHECK ADD FOREIGN KEY([ArticleId])
REFERENCES [dbo].[Article] ([ArticleId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ArticleCategory]  WITH CHECK ADD FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Category] ([CategoryId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ArticleGame]  WITH CHECK ADD FOREIGN KEY([ArticleId])
REFERENCES [dbo].[Article] ([ArticleId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ArticleGame]  WITH CHECK ADD FOREIGN KEY([GameId])
REFERENCES [dbo].[Game] ([GameId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([RoleID])
GO
/****** Object:  StoredProcedure [dbo].[uspActivateProfileForUserWithId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspActivateProfileForUserWithId]
	@UserID INT
AS
BEGIN
	UPDATE [User]
    SET
        IsActive = 1,
        UpdatedAt = GETDATE()
    WHERE UserID = @UserID;
END
GO
/****** Object:  StoredProcedure [dbo].[uspCreateArticle]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspCreateArticle]
    @Title NVARCHAR(255),
    @Link NVARCHAR(500),
    @Description NVARCHAR(MAX),
    @PubDate DATETIME2,
    @PicturePath NVARCHAR(500),
    @ArticleId INT OUTPUT
AS
BEGIN
    INSERT INTO Article (Title, Link, Description, PubDate, PicturePath)
    VALUES (@Title, @Link, @Description, @PubDate, @PicturePath);

    SET @ArticleId = SCOPE_IDENTITY();
END
GO
/****** Object:  StoredProcedure [dbo].[uspCreateUser]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspCreateUser]
	@UserId INT OUTPUT,
    @Username NVARCHAR(100),
	@FirstName NVARCHAR(100),
	@LastName NVARCHAR(100),
    @PasswordHash NVARCHAR(255),
    @Email NVARCHAR(255),
	@PicturePath NVARCHAR(255)
AS
BEGIN
    INSERT INTO [User]
	(
		Username,
		FirstName,
		LastName,
		PasswordHash,
		Email,
		PicturePath,
		RoleID
	)
    VALUES
	(
		@Username,
		@FirstName,
		@LastName,
		@PasswordHash,
		@Email,
		@PicturePath,
		(SELECT RoleID FROM Role WHERE RoleName = 'User')
	)

	SET @UserID = SCOPE_IDENTITY()
END;
GO
/****** Object:  StoredProcedure [dbo].[uspDeactivateProfileForUserWithId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspDeactivateProfileForUserWithId]
	@UserID INT
AS
BEGIN
	UPDATE [User]
    SET
        IsActive = 0,
        UpdatedAt = GETDATE()
    WHERE UserID = @UserID;
END
GO
/****** Object:  StoredProcedure [dbo].[uspDeleteArticleWithId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspDeleteArticleWithId]
    @ArticleId INT
AS
BEGIN
    DELETE FROM Article
    WHERE ArticleId = @ArticleId;
END
GO
/****** Object:  StoredProcedure [dbo].[uspDeleteUserWithId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspDeleteUserWithId]
    @UserID INT
AS
BEGIN
    DELETE FROM [User]
    WHERE UserID = @UserID;
END;
GO
/****** Object:  StoredProcedure [dbo].[uspExistsArticleWithLink]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspExistsArticleWithLink]
    @Link NVARCHAR(500),
    @Exists BIT OUTPUT
AS
BEGIN
    IF EXISTS (SELECT 1 FROM Article WHERE Link = @Link)
        SET @Exists = 1;
    ELSE
        SET @Exists = 0;
END
GO
/****** Object:  StoredProcedure [dbo].[uspExistsUserWithEmail]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspExistsUserWithEmail]
    @Email NVARCHAR(255),
    @Exists BIT OUTPUT
AS
BEGIN
    IF EXISTS (SELECT * FROM [User] WHERE Email = @Email)
        SET @Exists = 1;
    ELSE
        SET @Exists = 0;
END;
GO
/****** Object:  StoredProcedure [dbo].[uspExistsUserWithUsername]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE   PROCEDURE [dbo].[uspExistsUserWithUsername]
    @Username NVARCHAR(100),
    @Exists BIT OUTPUT
AS
BEGIN
    IF EXISTS (SELECT * FROM [User] WHERE Username = @Username)
        SET @Exists = 1;
    ELSE
        SET @Exists = 0;
END;
GO
/****** Object:  StoredProcedure [dbo].[uspSelectAllArticles]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectAllArticles]
AS
BEGIN
    SELECT ArticleId, Title, Link, Description, PubDate, PicturePath
    FROM Article;
END
GO
/****** Object:  StoredProcedure [dbo].[uspSelectAllUsers]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectAllUsers]
AS
BEGIN
 SELECT
        u.UserID,
        u.Username,
        u.PasswordHash,
        u.Email,
        u.FirstName,
        u.LastName,
		u.PicturePath,
		u.IsActive,
        u.CreatedAt,
        u.UpdatedAt,
        r.RoleName
    FROM [User] u
    JOIN [Role] r ON u.RoleID = r.RoleID
END;
GO
/****** Object:  StoredProcedure [dbo].[uspSelectArticlesByCategoryName]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectArticlesByCategoryName]
    @CategoryName NVARCHAR(100)
AS
BEGIN
    SELECT a.ArticleId, a.Title, a.Link, a.Description, a.PubDate, a.PicturePath
    FROM Article a
    INNER JOIN ArticleCategory ac ON a.ArticleId = ac.ArticleId
    INNER JOIN Category c ON c.CategoryId = ac.CategoryId
    WHERE c.Name = @CategoryName;
END
GO
/****** Object:  StoredProcedure [dbo].[uspSelectArticlesByGameId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectArticlesByGameId]
    @GameId INT
AS
BEGIN
    SELECT a.ArticleId, a.Title, a.Link, a.Description, a.PubDate, a.PicturePath
    FROM Article a
    INNER JOIN ArticleGame ag ON a.ArticleId = ag.ArticleId
    WHERE ag.GameId = @GameId;
END
GO
/****** Object:  StoredProcedure [dbo].[uspSelectArticlesByTitle]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectArticlesByTitle]
    @Title NVARCHAR(255)
AS
BEGIN
    SELECT ArticleId, Title, Link, Description, PubDate, PicturePath
    FROM Article
    WHERE Title LIKE '%' + @Title + '%';
END
GO
/****** Object:  StoredProcedure [dbo].[uspSelectArticleWithId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectArticleWithId]
    @ArticleId INT
AS
BEGIN
    SELECT ArticleId, Title, Link, Description, PubDate, PicturePath
    FROM Article
    WHERE ArticleId = @ArticleId;
END
GO
/****** Object:  StoredProcedure [dbo].[uspSelectUserWithId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectUserWithId]
    @UserID INT
AS
BEGIN
    SELECT
        u.UserID,
        u.Username,
        u.PasswordHash,
        u.Email,
        u.FirstName,
        u.LastName,
		u.PicturePath,
		u.IsActive,
        u.CreatedAt,
        u.UpdatedAt,
        r.RoleName
    FROM [User] u
    JOIN [Role] r ON u.RoleID = r.RoleID
    WHERE u.UserID = @UserID;
END;
GO
/****** Object:  StoredProcedure [dbo].[uspSelectUserWithUsername]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectUserWithUsername]
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
		u.PicturePath,
		u.IsActive,
        u.CreatedAt,
        u.UpdatedAt,
        r.RoleName
    FROM [User] u
    JOIN [Role] r ON u.RoleID = r.RoleID
    WHERE u.Username = @Username;
END;
GO
/****** Object:  StoredProcedure [dbo].[uspUpdateArticleWithId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE   PROCEDURE [dbo].[uspUpdateArticleWithId]
    @ArticleId INT,
    @Title NVARCHAR(255),
    @Link NVARCHAR(500),
    @Description NVARCHAR(MAX),
    @PubDate DATETIME2,
    @PicturePath NVARCHAR(500)
AS
BEGIN
    UPDATE Article
    SET
        Title = @Title,
        Link = @Link,
        Description = @Description,
        PubDate = @PubDate,
        PicturePath = @PicturePath
    WHERE ArticleId = @ArticleId;
END
GO
/****** Object:  StoredProcedure [dbo].[uspUpdateUserWithId]    Script Date: 6/6/2025 2:22:48 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspUpdateUserWithId]
    @UserID INT,
    @Username NVARCHAR(100),
	@FirstName NVARCHAR(100),
	@LastName NVARCHAR(100),
    @PasswordHash NVARCHAR(255),
    @PicturePath NVARCHAR(255),
    @Email NVARCHAR(255)
AS
BEGIN
    UPDATE [User]
    SET
        Username = @Username,
		FirstName = @FirstName,
		LastName = @LastName,
        PasswordHash = @PasswordHash,
		PicturePath = @PicturePath,
        Email = @Email,
        UpdatedAt = GETDATE()
    WHERE UserID = @UserID;
END;
GO

