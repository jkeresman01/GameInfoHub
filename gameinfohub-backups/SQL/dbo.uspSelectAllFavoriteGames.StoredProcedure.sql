USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspSelectAllFavoriteGames]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectAllFavoriteGames]
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
