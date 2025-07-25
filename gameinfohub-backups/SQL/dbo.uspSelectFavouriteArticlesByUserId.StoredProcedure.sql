USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspSelectFavouriteArticlesByUserId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectFavouriteArticlesByUserId]
    @UserId INT
AS
BEGIN
    SELECT a.*
    FROM Article a
    INNER JOIN FavoriteArticle fa ON fa.ArticleId = a.Id
    WHERE fa.UserId = @UserId;
END
GO
