USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspCreateGame]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- Game

CREATE   PROCEDURE [dbo].[uspCreateGame]
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
