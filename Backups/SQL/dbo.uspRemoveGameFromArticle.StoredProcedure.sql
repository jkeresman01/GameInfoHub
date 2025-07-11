USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspRemoveGameFromArticle]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspRemoveGameFromArticle]
    @ArticleId INT,
    @GameId INT
AS
BEGIN
    DELETE FROM ArticleGame WHERE ArticleId = @ArticleId AND GameId = @GameId;
END
GO
