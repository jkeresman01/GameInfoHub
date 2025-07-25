USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspSelectReportsByArticleId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectReportsByArticleId]
    @ArticleId INT
AS
BEGIN
    SELECT Id, Title, Content
    FROM Report
    WHERE ArticleId = @ArticleId
    ORDER BY CreatedAt DESC;
END
GO
