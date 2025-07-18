USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspInsertFavouriteArticle]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- FAV ARTICLES

CREATE   PROCEDURE [dbo].[uspInsertFavouriteArticle]
    @UserId INT,
    @ArticleId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM FavoriteArticle WHERE UserId = @UserId AND ArticleId = @ArticleId
    )
    BEGIN
        INSERT INTO FavoriteArticle (UserId, ArticleId)
        VALUES (@UserId, @ArticleId);
    END
END
GO
