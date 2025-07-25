USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspSelectFavouriteArticlesByGameId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectFavouriteArticlesByGameId]
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
