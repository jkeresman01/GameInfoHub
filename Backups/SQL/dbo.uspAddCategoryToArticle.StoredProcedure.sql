USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspAddCategoryToArticle]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspAddCategoryToArticle]
    @ArticleId INT,
    @CategoryId INT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM ArticleCategory WHERE ArticleId = @ArticleId AND CategoryId = @CategoryId
    )
    BEGIN
        INSERT INTO ArticleCategory (ArticleId, CategoryId)
        VALUES (@ArticleId, @CategoryId);
    END
END
GO
