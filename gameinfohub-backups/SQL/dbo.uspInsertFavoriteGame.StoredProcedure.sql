USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspInsertFavoriteGame]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- FAV Games

CREATE   PROCEDURE [dbo].[uspInsertFavoriteGame]
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
