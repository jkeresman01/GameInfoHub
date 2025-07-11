USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspAddGenreToGame]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   PROCEDURE [dbo].[uspAddGenreToGame]
    @GameId INT,
    @GenreName NVARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @GenreId INT;

    SELECT @GenreId = Id FROM Genre WHERE Name = @GenreName;

    IF @GenreId IS NULL
    BEGIN
        INSERT INTO Genre (Name) VALUES (@GenreName);
        SET @GenreId = SCOPE_IDENTITY();
    END

    IF NOT EXISTS (SELECT 1 FROM GameGenre WHERE GameId = @GameId AND GenreId = @GenreId)
    BEGIN
        INSERT INTO GameGenre (GameId, GenreId) VALUES (@GameId, @GenreId);
    END
END
GO
