USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspUpdateGenreWithId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[uspUpdateGenreWithId]
    @GenreId INT,
    @Name NVARCHAR(100)
AS
BEGIN
    UPDATE Genre
    SET Name = @Name
    WHERE Id = @GenreId;
END
GO
