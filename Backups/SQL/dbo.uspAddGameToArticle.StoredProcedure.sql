USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspAddGameToArticle]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspAddGameToArticle]
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
