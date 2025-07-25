USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspSelectGenreWithId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[uspSelectGenreWithId]
    @GenreId INT
AS
BEGIN
    SELECT Id, Name
    FROM Genre
    WHERE Id = @GenreId;
END
GO
