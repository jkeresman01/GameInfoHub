USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspSelectGamesByGenreId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectGamesByGenreId]
    @GenreId INT
AS
BEGIN
    SELECT g.*
    FROM Game g
    INNER JOIN GameGenre gg ON g.Id = gg.GameId
    WHERE gg.GenreId = @GenreId;
END
GO
